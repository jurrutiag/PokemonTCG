package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

public class InstantAbilityPlayedEvent extends AbstractEvent {

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitInstantAbilityPlayedEvent(this);
    }

}
