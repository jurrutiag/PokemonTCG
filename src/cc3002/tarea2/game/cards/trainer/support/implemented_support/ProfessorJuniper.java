package cc3002.tarea2.game.cards.trainer.support.implemented_support;

import cc3002.tarea2.game.cards.trainer.support.AbstractSupportCard;

/**
 * Professor Juniper support card.
 *
 * @author Juan Urrutia
 */
public class ProfessorJuniper extends AbstractSupportCard {

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect() {
        for (int i = 0; i < this.getTrainer().getHand().size(); i ++) {
            this.getTrainer().selectHandCard(i);
            this.getTrainer().discardSelectedFromHand();
        }
        this.getTrainer().drawTopCards(7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Discard your hand and draw 7 cards.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Professor Juniper";
    }
}
