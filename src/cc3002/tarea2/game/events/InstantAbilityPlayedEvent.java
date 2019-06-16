package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that an instant use ability was used.
 *
 * @author Juan Urrutia
 */
public class InstantAbilityPlayedEvent extends AbstractEvent {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitInstantAbilityPlayedEvent(this);
    }

}
