package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.trainer.ObjectTrainerCard;

public class ExpShareObject extends ObjectTrainerCard {

    @Override
    public String getName() {
        return "Exp. Share";
    }

    @Override
    public String getDescription() {
        return "Gives the possibility to move an energy from the active pokemon to the pokemon that holds this card in case the active pokemon dies.";
    }
}
