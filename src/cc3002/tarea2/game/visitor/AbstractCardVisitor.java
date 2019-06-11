package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.*;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.events.AttackEvent;

public abstract class AbstractCardVisitor implements ICardVisitor {
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {}
    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon) {}
    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon) {}

    @Override
    public void visitElectricPokemon(IElectricPokemon electricPokemon) {}
    @Override
    public void visitFightingPokemon(IFightingPokemon fightingPokemon) {}
    @Override
    public void visitFirePokemon(IFirePokemon firePokemon) {}
    @Override
    public void visitGrassPokemon(IGrassPokemon grassPokemon) {}
    @Override
    public void visitPsychicPokemon(IPsychicPokemon psychicPokemon) {}
    @Override
    public void visitWaterPokemon(IWaterPokemon waterPokemon) {}

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
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {}
    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {}
}
