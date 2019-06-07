package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.trainer.ObjectTrainerCard;

public class SuperRodObject extends ObjectTrainerCard {
    @Override
    public String getDescription() {
        return "Throw a coin, if it's heads, put an evolved Pokemon from the discard pile on your hand. If it's tails put a basic Pokemon from the discard pile on your hand";
    }

    @Override
    public String getName() {
        return "Super Rod";
    }

}
