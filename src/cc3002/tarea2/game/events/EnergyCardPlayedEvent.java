package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.energies.IEnergyCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class EnergyCardPlayedEvent implements IEvent {

    private IEnergyCard energyCard;

    public EnergyCardPlayedEvent(IEnergyCard energyCard) {
        this.energyCard = energyCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitEnergyCardPlayedEvent(this);
    }

    public IEnergyCard getEnergyCard() {
        return this.energyCard;
    }
}
