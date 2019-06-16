package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhasePokemon;
import cc3002.tarea2.game.cards.trainer.object.IInstantObject;
import cc3002.tarea2.game.cards.trainer.object.INonInstantObject;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.support.ISupportCard;
import cc3002.tarea2.game.events.EnergyCardPlayedEvent;
import cc3002.tarea2.game.events.StadiumCardPlayedEvent;
import cc3002.tarea2.game.searching.methods.SearchPokemonByID;

import java.util.ArrayList;

/**
 * Class that plays any card by a trainer using visitor pattern.
 *
 * @author Juan Urrutia
 */
public class PlayVisitor extends AbstractCardVisitor {

    /**
     * Boolean representing if the card was played correctly.
     */
    private boolean playedCorrectly = true;

    /**
     * The trainer that played the card.
     */
    private Trainer trainer;

    /**
     * The constructor of play visitor.
     * @param trainer The trainer that executes it.
     */
    public PlayVisitor(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard) {
        trainer.getSelectedPokemon().addElectricEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard) {
        trainer.getSelectedPokemon().addFightingEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard) {
        trainer.getSelectedPokemon().addFireEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard) {
        trainer.getSelectedPokemon().addGrassEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard) {
        trainer.getSelectedPokemon().addPsychicEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard) {
        trainer.getSelectedPokemon().addWaterEnergy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        playedCorrectly = basicPokemon.getTrainer().addPokemonToBench(basicPokemon);
    }

    /**
     * Visits a general phase pokemon, to avoid duplication between phase 1 and 2.
     * @param phasePokemon The phase pokemon to be visited.
     */
    private void visitPhasePokemon(IPhasePokemon phasePokemon) {
        ArrayList<IPokemonCard> preevolutions = this.trainer.search(new SearchPokemonByID(phasePokemon.getPreevolutionId()), this.trainer.getBench());
        if (!preevolutions.isEmpty()) {
            EnergySet preevolutionEnergySet = preevolutions.get(0).getEnergySet();
            preevolutions.get(0).setEnergies(new EnergySet());
            this.trainer.discard(preevolutions.get(0));
            this.trainer.getBench().remove(preevolutions.get(0));
            phasePokemon.setEnergies(preevolutionEnergySet);
            this.trainer.getBench().add(phasePokemon);
            playedCorrectly = true;
            return;
        }
        playedCorrectly = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {
        this.visitPhasePokemon(phase1Pokemon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {
        this.visitPhasePokemon(phase2Pokemon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitNonInstantObjectCard(INonInstantObject objectCard) {
        playedCorrectly = this.trainer.getSelectedPokemon().associateObject(objectCard);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitInstantObjectCard(IInstantObject objectCard) {
        objectCard.executeEffect();
        trainer.discard(objectCard);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitObjectCard(IObjectCard objectCard) {
        objectCard.setPokemon(trainer.getSelectedPokemon());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        if (this.trainer.getBench().size() > 0) {
            this.trainer.notifyEvent(new EnergyCardPlayedEvent());
        } else {
            playedCorrectly = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitSupportCard(ISupportCard supportCard) {
        supportCard.executeEffect();
        trainer.discard(supportCard);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStadiumCard(IStadiumCard stadiumCard) {
        trainer.notifyEvent(new StadiumCardPlayedEvent(stadiumCard));
    }

    /**
     *
     * @return Returns true if the card was played correctly.
     */
    public boolean wasPlayedCorrectly() {
        return playedCorrectly;
    }
}
