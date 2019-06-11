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

public interface ICardVisitor {
    public void visitBasicPokemon(IBasicPokemon basicPokemon);
    public void visitPhase1Pokemon(IPhase1Pokemon phase1Pokemon);
    public void visitPhase2Pokemon(IPhase2Pokemon phase2Pokemon);

    public void visitElectricPokemon(IElectricPokemon electricPokemon);
    public void visitFightingPokemon(IFightingPokemon fightingPokemon);
    public void visitFirePokemon(IFirePokemon firePokemon);
    public void visitGrassPokemon(IGrassPokemon grassPokemon);
    public void visitPsychicPokemon(IPsychicPokemon psychicPokemon);
    public void visitWaterPokemon(IWaterPokemon waterPokemon);

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

    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent);
    public void visitAttackEvent(AttackEvent attackEvent);
}
