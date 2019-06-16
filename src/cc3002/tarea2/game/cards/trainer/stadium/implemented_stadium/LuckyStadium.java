package cc3002.tarea2.game.cards.trainer.stadium.implemented_stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.stadium.AbstractStadiumCard;
import cc3002.tarea2.game.visitor.stadium.IStadiumVisitor;

/**
 * Lucky stadium card, affects all players once a turn.
 *
 * @author Juan Urrutia
 */
public class LuckyStadium extends AbstractStadiumCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect(Trainer trainer) {
        double coin = Math.random();
        if (coin < 0.5) {
            trainer.drawCard();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Once a turn, the player can throw a coin, if heads, the player draws one card.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Lucky Stadium";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void acceptStadiumVisitor(IStadiumVisitor visitor) {
        visitor.visitLuckyStadium(this);
    }
}
