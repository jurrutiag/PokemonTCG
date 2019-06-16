package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that an active pokemon died.
 *
 * @author Juan Urrutia
 */
public class ActivePokemonDiedEvent extends AbstractEvent {
    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitActivePokemonDiedEvent(this);
    }
}
