package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.support.ISupportCard;
import cc3002.tarea2.game.exceptions.PokemonWithoutPreevolutionPlayedException;

import java.util.ArrayList;

public class CardInfoVisitor extends AbstractCardVisitor {

    private ArrayList<String> infoStrings = new ArrayList<>();

    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        infoStrings.add("Pokemon phase: Basic");
    }

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) throws PokemonWithoutPreevolutionPlayedException {
        infoStrings.add("Pokemon phase: Phase 1");
    }

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) throws PokemonWithoutPreevolutionPlayedException {
        infoStrings.add("Pokemon phase: Phase 2");
    }

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {
        infoStrings.add("Card type: Pokemon");
        infoStrings.add("Pokemon Max HP: " + pokemonCard.getMaxHp());
        infoStrings.add("Pokemon Abilities: ");
        for (IAbility ability : pokemonCard.getAbilities()) {
            infoStrings.add("\t" + ability.getName());
        }
    }

    @Override
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard) {
        infoStrings.add("Energy type: Electric");
    }

    @Override
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard) {
        infoStrings.add("Energy type: Fighting");
    }

    @Override
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard) {
        infoStrings.add("Energy type: Fire");
    }

    @Override
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard) {
        infoStrings.add("Energy type: Grass");
    }

    @Override
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard) {
        infoStrings.add("Energy type: Psychic");
    }

    @Override
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard) {
        infoStrings.add("Energy type: Water");
    }

    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        infoStrings.add("Card type: Energy");
    }

    @Override
    public void visitObjectCard(IObjectCard objectCard) {
        infoStrings.add("Card type: Trainer Object");
        infoStrings.add("Card Description: " + objectCard.getDescription());
    }

    @Override
    public void visitSupportCard(ISupportCard supportCard) {
        infoStrings.add("Card type: Trainer Support");
        infoStrings.add("Card Description: " + supportCard.getDescription());
    }

    @Override
    public void visitStadiumCard(IStadiumCard stadiumCard) {
        infoStrings.add("Card type: Trainer Stadium");
        infoStrings.add("Card Description: " + stadiumCard.getDescription());
    }

    @Override
    public void visitCard(ICard card) {
        infoStrings.add("Card name: " + card.getName());
    }

    public ArrayList<String> getStrings() {
        return this.infoStrings;
    }

}
