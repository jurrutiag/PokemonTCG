package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class StadiumCardPlayedEvent extends AbstractEvent {

    private IStadiumCard stadiumCard;

    public StadiumCardPlayedEvent(IStadiumCard stadiumCard) {
        this.stadiumCard = stadiumCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitStadiumCardPlayed(this);
    }

    public IStadiumCard getStadiumCard() {
        return this.stadiumCard;
    }
}
