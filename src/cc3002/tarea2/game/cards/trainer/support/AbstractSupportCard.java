package cc3002.tarea2.game.cards.trainer.support;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;

public abstract class AbstractSupportCard extends AbstractTrainerCard implements ISupportCard {
    public AbstractSupportCard(Trainer trainer) {
        super(trainer);
    }

    public AbstractSupportCard() {

    }
}
