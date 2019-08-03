package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Object that gets equipped to the pokemon.
 *
 * @author Juan Urrutia
 */
public abstract class AbstractNonInstantObject extends AbstractObjectCard implements INonInstantObject {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitNonInstantObjectCard(this);
    }
}
