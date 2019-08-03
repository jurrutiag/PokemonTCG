package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Object that executes its effect immediately.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractInstantObject extends AbstractObjectCard implements IInstantObject {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitInstantObjectCard(this);
    }
}
