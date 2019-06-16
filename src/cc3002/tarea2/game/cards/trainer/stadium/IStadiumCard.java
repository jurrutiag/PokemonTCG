package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;
import cc3002.tarea2.game.visitor.stadium.IStadiumVisitable;

/**
 * Interface for stadium card
 *
 * @author Juan Urrutia
 */
public interface IStadiumCard extends ITrainerCard, IStadiumVisitable {

    /**
     * Executes the stadium effect.
     * @param trainer The trainer that will receive the stadium effect. (stadiums affect all players)
     */
    public void executeEffect(Trainer trainer);
}
