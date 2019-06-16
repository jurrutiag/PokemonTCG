package cc3002.tarea2.game.cards.trainer.support;

import cc3002.tarea2.game.cards.trainer.ITrainerCard;

/**
 * Interface for support cards
 *
 * @author Juan Urrutia
 */
public interface ISupportCard extends ITrainerCard {
    /**
     * Executes the effect of the card.
     */
    public void executeEffect();
}
