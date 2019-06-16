package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

/**
 * Class representing an event that notifies that a stadium card was played.
 *
 * @author Juan Urrutia
 */
public class StadiumCardPlayedEvent extends AbstractEvent {

    /**
     * The stadium card that was played.
     */
    private IStadiumCard stadiumCard;

    /**
     * Constructor for stadium card played event.
     * @param stadiumCard The stadium card that was played.
     */
    public StadiumCardPlayedEvent(IStadiumCard stadiumCard) {
        this.stadiumCard = stadiumCard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitStadiumCardPlayed(this);
    }

    /**
     *
     * @return Returns the stadium card.
     */
    public IStadiumCard getStadiumCard() {
        return this.stadiumCard;
    }
}
