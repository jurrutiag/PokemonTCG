package cc3002.tarea2.game.cards;

import cc3002.tarea2.game.visitor.Visitor;

public abstract class TrainerCard implements ITrainerCard {
    @Override
    public String toString() {
        return "TrainerCard Card: " + this.getName();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTrainerCard(this);
    }

    @Override
    public boolean isActivelySelectable() {
        return false;
    }
}
