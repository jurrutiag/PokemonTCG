package cc3002.tarea2.game.visitor;

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

public abstract class AbstractCardVisitor implements ICardVisitor {
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {}
    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {}
    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {}

    @Override
    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard) {}
    @Override
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard) {}
    @Override
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard) {}
    @Override
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard) {}
    @Override
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard) {}
    @Override
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard) {}

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {}
    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {}
    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {}

    @Override
    public void visitObjectCard(IObjectCard objectCard) {}
    @Override
    public void visitSupportCard(ISupportCard supportCard) {}
    @Override
    public void visitStadiumCard(IStadiumCard stadiumCard) {}

    @Override
    public void visitInstantObjectCard(IInstantObject abstractInstantObject) {}

    @Override
    public void visitNonInstantObjectCard(INonInstantObject abstractNonInstantObject) {}

}
