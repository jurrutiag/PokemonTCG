package cc3002.tarea2.game.events;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that an ability that can be played once per turn was played.
 *
 * @author Juan Urrutia
 */
public class OnceATurnAbilityEffect extends AbstractEvent {
    /**
     * The ability that gets executed once a turn.
     */
    private IAbility ability;

    /**
     * Constructor of the event.
     * @param ability The ability to be executed once a turn.
     */
    public OnceATurnAbilityEffect(IAbility ability) {
        this.ability = ability;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitOnceATurnAbilityEffect(this);
    }

    /**
     *
     * @return Returns the event's ability.
     */
    public IAbility getAbility() {
        return this.ability;
    }
}
