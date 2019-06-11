package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.events.*;

public interface IEventVisitor {
    public void visitAttackEvent(AttackEvent attackEvent);
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent);

    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent);
    public void visitPokemonCardPlayedEvent(PokemonCardPlayedEvent pokemonCardPlayedEvent);
    public void visitTrainerCardPlayedEvent(TrainerCardPlayedEvent trainerCardPlayedEvent);
}
