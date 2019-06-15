package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.visitor.IStadiumVisitable;

public interface IStadiumCard extends ITrainerCard, IStadiumVisitable {
    public void executeEffect(Trainer trainer);
}
