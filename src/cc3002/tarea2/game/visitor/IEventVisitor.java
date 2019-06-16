package cc3002.tarea2.game.visitor;

import cc3002.tarea2.game.events.*;

/**
 * Interface for classes that can visit event visitables.
 *
 * @author Juan Urrutia
 */
public interface IEventVisitor {

    /**
     * Visits an attack event.
     * @param attackEvent the event to visit.
     */
    public void visitAttackEvent(AttackEvent attackEvent);

    /**
     * Visits an active pokemon died event.
     * @param activePokemonDiedEvent the event to visit.
     */
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent);

    /**
     * Visits an energy card played event.
     * @param energyCardPlayedEvent the event to visit.
     */
    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent);

    /**
     * Visits a once a turn ability effect event.
     * @param onceATurnAbilityEffect the event to visit.
     */
    public void visitOnceATurnAbilityEffect(OnceATurnAbilityEffect onceATurnAbilityEffect);

    /**
     * Visits an instant ability played event.
     * @param instantAbilityPlayedEvent the event to visit.
     */
    public void visitInstantAbilityPlayedEvent(InstantAbilityPlayedEvent instantAbilityPlayedEvent);

    /**
     * Visits a stadium card played event.
     * @param stadiumCardPlayed the event to visit.
     */
    public void visitStadiumCardPlayed(StadiumCardPlayedEvent stadiumCardPlayed);

}
