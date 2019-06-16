package cc3002.tarea2.game.visitor.card;

import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.cards.trainer.object.IInstantObject;
import cc3002.tarea2.game.cards.trainer.object.INonInstantObject;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.support.ISupportCard;

/**
 * Interface for classes that can visit card visitables.
 *
 * @author Juan Urrutia
 */
public interface ICardVisitor {
    /**
     * Visits a basic Pokemon.
     * @param basicPokemon The pokemon to be visited.
     */
    public void visitBasicPokemon(IBasicPokemon basicPokemon);

    /**
     * Visits a phase 1 Pokemon.
     * @param phase1Pokemon The pokemon to be visited.
     */
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon);

    /**
     * Visits a phase 2 Pokemon.
     * @param phase2Pokemon The pokemon to be visited.
     */
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon);

    /**
     * Visits an electric energy card.
     * @param electricEnergyCard The card to be visited.
     */
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard);

    /**
     * Visits a fighting energy card.
     * @param fightingEnergyCard The card to be visited.
     */
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard);

    /**
     * Visits a fire energy card.
     * @param fireEnergyCard The card to be visited.
     */
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard);

    /**
     * Visits a grass energy card.
     * @param grassEnergyCard The card to be visited.
     */
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard);

    /**
     * Visits a psychic energy card.
     * @param psychicEnergyCard The card to be visited.
     */
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard);

    /**
     * Visits a water energy card.
     * @param waterEnergyCard The card to be visited.
     */
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard);

    /**
     * Visits a general pokemon card.
     * @param pokemonCard The card to be visited.
     */
    public void visitPokemonCard(IPokemonCard pokemonCard);

    /**
     * Visits a general energy card.
     * @param energyCard The card to be visited.
     */
    public void visitEnergyCard(IEnergyCard energyCard);

    /**
     * Visits a general trainer card.
     * @param trainerCard The card to be visited.
     */
    public void visitTrainerCard(ITrainerCard trainerCard);


    /**
     * Visits a general object card.
     * @param objectCard The card to be visited.
     */
    public void visitObjectCard(IObjectCard objectCard);

    /**
     * Visits a general support card.
     * @param supportCard The card to be visited.
     */
    public void visitSupportCard(ISupportCard supportCard);

    /**
     * Visits a general stadium card.
     * @param stadiumCard The card to be visited.
     */
    public void visitStadiumCard(IStadiumCard stadiumCard);

    /**
     * Visits an instant object.
     * @param abstractInstantObject The object to be visited.
     */
    public void visitInstantObjectCard(IInstantObject abstractInstantObject);

    /**
     * Visits a non instant object.
     * @param abstractNonInstantObject The object to be visited.
     */
    public void visitNonInstantObjectCard(INonInstantObject abstractNonInstantObject);
}
