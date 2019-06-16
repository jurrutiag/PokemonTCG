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
 * Class implementing an abstract card visitor using template pattern.
 * so that visitors dont have to implement all methods if they dont need them.
 * @author Juan Urrutia
 */
public abstract class AbstractCardVisitor implements ICardVisitor {

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitObjectCard(IObjectCard objectCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitSupportCard(ISupportCard supportCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitStadiumCard(IStadiumCard stadiumCard) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitInstantObjectCard(IInstantObject abstractInstantObject) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitNonInstantObjectCard(INonInstantObject abstractNonInstantObject) {}

}
