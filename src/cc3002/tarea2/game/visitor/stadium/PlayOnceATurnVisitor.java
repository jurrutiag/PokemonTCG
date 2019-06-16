package cc3002.tarea2.game.visitor.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.implemented_stadium.LuckyStadium;

/**
 * Class that perform actions that can only be performed once a turn using visitor pattern.
 *
 * @author Juan Urrutia
 */
public class PlayOnceATurnVisitor implements IStadiumVisitor {

    /**
     * The trainer that played the card.
     */
    private Trainer trainer;

    /**
     * The visitor constructor.
     * @param trainer The trainer that played the card.
     */
    public PlayOnceATurnVisitor(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitLuckyStadium(LuckyStadium stadiumCard) {
        stadiumCard.executeEffect(trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void acceptNullStadium(NullStadiumCard nullStadiumCard) {

    }
}
