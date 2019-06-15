package cc3002.tarea2.game.cards.trainer;

import cc3002.tarea2.game.cards.AbstractCard;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {

    @Override
    public String toString() {
        return "AbstractTrainerCard ICard: " + this.getName();
    }

    @Override
    public void accept(ICardVisitor visitor) {
        visitor.visitTrainerCard(this);
    }

    @Override
    public boolean isActivelySelectable() {
        return false;
    }
}
