package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.object.AbstractObjectCard;

public class ExpShareObject extends AbstractObjectCard {

    public ExpShareObject(Trainer trainer) {
        super(trainer);
    }

    public ExpShareObject() {
    }

    @Override
    public String getName() {
        return "Exp. Share";
    }

    @Override
    public String getDescription() {
        return "Gives the possibility to move an energy from the active pokemon to the pokemon that holds this card in case the active pokemon dies.";
    }
}
