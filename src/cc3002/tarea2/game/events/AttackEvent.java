package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.turn.EventVisitor;

public class AttackEvent implements Event {
    @Override
    public void accept(EventVisitor visitor) {
        visitor.visitAttackEvent(this);
    }
}
