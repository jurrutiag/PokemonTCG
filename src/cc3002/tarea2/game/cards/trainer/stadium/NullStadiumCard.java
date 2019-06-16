package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.stadium.IStadiumVisitor;

/**
 * Null stadium card implementing the null object pattern.
 *
 * @author Juan Urrutia
 */
public class NullStadiumCard extends AbstractStadiumCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(Trainer trainer) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "";
    }

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
    public void acceptStadiumVisitor(IStadiumVisitor visitor) {
        visitor.acceptNullStadium(this);
    }
}
