package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.trainer.object.AbstractObjectCard;

public class SuperRodObject extends AbstractObjectCard {
    public SuperRodObject() {
    }

    public SuperRodObject(Trainer trainer) {
        super(trainer);
    }

    @Override
    public String getDescription() {
        return "Throw a coin, if it's heads, put an evolved Pokemon from the discard pile on your hand. If it's tails put a basic Pokemon from the discard pile on your hand";
    }

    @Override
    public String getName() {
        return "Super Rod";
    }

}
