package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that an energy card was used.
 *
 * @author Juan Urrutia
 */
public class EnergyCardPlayedEvent extends AbstractEvent {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitEnergyCardPlayedEvent(this);
    }

}
