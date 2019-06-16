package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that an attack was performed.
 *
 * @author Juan Urrutia
 */
public class AttackEvent extends AbstractEvent {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitAttackEvent(this);
    }

}
