package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Support card played event, notifies a support card was played
 */
public class SupportCardPlayedEvent extends AbstractEvent {
    /**
     * {@inheritDoc}
     * @param eventVisitor
     */
    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitSupportCardPlayed(this);
    }
}
