package cc3002.tarea2.game.cards.trainer;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.TrainerCard;

public abstract class ObjectTrainerCard extends TrainerCard implements IObjectCard {

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof IObjectCard) && ((IObjectCard) obj).getDescription().equals(this.getDescription()) && ((IObjectCard) obj).getName().equals(this.getName());
    }

    @Override
    public boolean bePlayedBy(Trainer trainer) {
        return trainer.getSelectedPokemon().associateObject(this);
    }

}
