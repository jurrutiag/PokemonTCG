package cc3002.tarea2.game.cards.trainer.support;

import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Abstract support card class.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractSupportCard extends AbstractTrainerCard implements ISupportCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor cardVisitor) throws PlayCardException {
        super.accept(cardVisitor);
        cardVisitor.visitSupportCard(this);
    }
}
