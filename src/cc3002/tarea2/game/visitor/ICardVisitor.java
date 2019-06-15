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

public interface ICardVisitor {
    public void visitBasicPokemon(IBasicPokemon basicPokemon);
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon);
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon);

    public void visitElectricEnergyCard(ElectricEnergyCard electricEnergyCard);
    public void visitFightingEnergyCard(FightingEnergyCard fightingEnergyCard);
    public void visitFireEnergyCard(FireEnergyCard fireEnergyCard);
    public void visitGrassEnergyCard(GrassEnergyCard grassEnergyCard);
    public void visitPsychicEnergyCard(PsychicEnergyCard psychicEnergyCard);
    public void visitWaterEnergyCard(WaterEnergyCard waterEnergyCard);

    public void visitPokemonCard(IPokemonCard pokemonCard);
    public void visitEnergyCard(IEnergyCard energyCard);
    public void visitTrainerCard(ITrainerCard trainerCard);

    public void visitObjectCard(IObjectCard objectCard);
    public void visitSupportCard(ISupportCard supportCard);
    public void visitStadiumCard(IStadiumCard stadiumCard);

    public void visitInstantObjectCard(IInstantObject abstractInstantObject);

    public void visitNonInstantObjectCard(INonInstantObject abstractNonInstantObject);
}
