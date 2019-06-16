package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Abstract stadium class representing a stadium.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractStadiumCard extends AbstractTrainerCard implements IStadiumCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitStadiumCard(this);
    }
}
