package cc3002.tarea2.game.cards.trainer;

import cc3002.tarea2.game.cards.AbstractCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Trainer class made for trainer cards.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitTrainerCard(this);
    }
}
