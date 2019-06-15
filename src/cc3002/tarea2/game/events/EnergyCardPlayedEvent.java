package cc3002.tarea2.game.events;

import cc3002.tarea2.game.visitor.IEventVisitor;

public class EnergyCardPlayedEvent extends AbstractEvent {


    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitEnergyCardPlayedEvent(this);
    }

}
