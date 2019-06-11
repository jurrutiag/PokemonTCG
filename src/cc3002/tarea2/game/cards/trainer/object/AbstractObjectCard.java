package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.AbstractTrainerCard;

public abstract class AbstractObjectCard extends AbstractTrainerCard implements IObjectCard {

    public AbstractObjectCard(Trainer trainer) {
        super(trainer);
    }

    public AbstractObjectCard() {
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IObjectCard) && ((IObjectCard) obj).getDescription().equals(this.getDescription()) && ((IObjectCard) obj).getName().equals(this.getName());
    }

}
