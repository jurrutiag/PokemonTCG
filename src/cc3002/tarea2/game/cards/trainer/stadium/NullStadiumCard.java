package cc3002.tarea2.game.cards.trainer.stadium;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.visitor.IStadiumVisitor;

public class NullStadiumCard extends AbstractStadiumCard {
    @Override
    public void executeEffect(Trainer trainer) {

    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void acceptStadiumVisitor(IStadiumVisitor visitor) {
        visitor.acceptNullStadium(this);
    }
}
