package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhasePokemon;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.events.EnergyCardPlayedEvent;
import cc3002.tarea2.game.events.PokemonCardPlayedEvent;
import cc3002.tarea2.game.events.TrainerCardPlayedEvent;
import cc3002.tarea2.game.searching.methods.SearchPokemonByID;
import cc3002.tarea2.game.visitor.AbstractCardVisitor;

import java.util.ArrayList;

public class PlayVisitor extends AbstractCardVisitor {

    private boolean playedCorrectly = false;
    private Trainer trainer;

    public PlayVisitor(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard) {
        trainer.getSelectedPokemon().addElectricEnergy();
        playedCorrectly = true;
    }
    @Override
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard) {
        trainer.getSelectedPokemon().addFightingEnergy();
        playedCorrectly = true;
    }
    @Override
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard) {
        trainer.getSelectedPokemon().addFireEnergy();
        playedCorrectly = true;
    }
    @Override
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard) {
        trainer.getSelectedPokemon().addGrassEnergy();
        playedCorrectly = true;
    }
    @Override
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard) {
        trainer.getSelectedPokemon().addPsychicEnergy();
        playedCorrectly = true;
    }
    @Override
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard) {
        trainer.getSelectedPokemon().addWaterEnergy();
        playedCorrectly = true;
    }

    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        playedCorrectly = basicPokemon.getTrainer().addPokemonToBench(basicPokemon);
    }

    public void visitPhasePokemon(IPhasePokemon phasePokemon) {
        ArrayList<IPokemonCard> preevolutions = this.trainer.search(new SearchPokemonByID(phasePokemon.getPreevolutionId()), this.trainer.getBench());
        if (!preevolutions.isEmpty()) {
            EnergySet preevolutionEnergySet = preevolutions.get(0).getEnergySet();
            this.trainer.getBench().remove(preevolutions.get(0));
            phasePokemon.setEnergies(preevolutionEnergySet);
            this.trainer.getBench().add(phasePokemon);
            playedCorrectly = true;
            return;
        }
        playedCorrectly = false;
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {
        this.visitPhasePokemon(phase1Pokemon);
    }

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {
        this.visitPhasePokemon(phase2Pokemon);
    }

    @Override
    public void visitObjectCard(IObjectCard objectCard) {
        playedCorrectly = this.trainer.getSelectedPokemon().associateObject(objectCard);
    }

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {
        this.trainer.notifyEvent(new PokemonCardPlayedEvent(pokemonCard));
    }

    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        this.trainer.notifyEvent(new EnergyCardPlayedEvent(energyCard));
    }

    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {
        this.trainer.notifyEvent(new TrainerCardPlayedEvent(trainerCard));
    }

    public boolean wasPlayedCorrectly() {
        return playedCorrectly;
    }
}
