package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class AbstractStadiumCard extends AbstractTrainerCard implements IStadiumCard {
    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitStadiumCard(this);
    }
}
