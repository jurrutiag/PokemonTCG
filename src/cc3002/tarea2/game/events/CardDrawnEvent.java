package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class CardDrawnEvent extends AbstractEvent {

    private ICard card;

    public CardDrawnEvent(ICard card) {
        this.card = card;
    }

    public ICard getCard() {
        return this.card;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitCardDrawnEvent(this);
    }
}
