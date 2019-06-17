package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class that represents a Null Card, used as null object pattern.
 *
 * @author Juan Urrutia
 */
public class NullCard extends AbstractCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getDiscarded(Trainer trainer) {
        trainer.getHand().remove(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) {
    }
}
