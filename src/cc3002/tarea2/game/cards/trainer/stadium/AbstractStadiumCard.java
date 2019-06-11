package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;

public abstract class AbstractStadiumCard extends AbstractTrainerCard implements IStadiumCard{
    public AbstractStadiumCard(Trainer trainer) {
        super(trainer);
    }

    public AbstractStadiumCard() {

    }
}
