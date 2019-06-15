package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

public class AttackEvent extends AbstractEvent {


    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitAttackEvent(this);
    }

}