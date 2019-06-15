package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.ICardVisitor;

public class NullCard extends AbstractCard {

    @Override
    public boolean isActivelySelectable() {
        return false;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void getDiscarded(Trainer trainer) {
        trainer.getHand().remove(this);
    }

    @Override
    public void accept(ICardVisitor visitor) {
    }
}
