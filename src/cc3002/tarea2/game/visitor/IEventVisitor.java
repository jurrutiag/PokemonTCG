package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.events.*;

public interface IEventVisitor {

    public void visitAttackEvent(AttackEvent attackEvent);
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent);

    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent);

    public void visitOnceATurnAbilityEffect(OnceATurnAbilityEffect onceATurnAbilityEffect);

    public void visitInstantAbilityPlayedEvent(InstantAbilityPlayedEvent instantAbilityPlayedEvent);

    public void visitStadiumCardPlayed(StadiumCardPlayedEvent stadiumCardPlayed);

}
