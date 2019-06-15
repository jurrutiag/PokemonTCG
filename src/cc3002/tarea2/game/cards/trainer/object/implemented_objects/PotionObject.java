package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.cards.trainer.object.AbstractInstantObject;

public class PotionObject extends AbstractInstantObject {
    @Override
    public void executeEffect() {
        this.getPokemon().setHp(this.getPokemon().getHp() + 20);
    }

    @Override
    public String getDescription() {
        return "Removes up to 2 damage counters on the pokemon.";
    }

    @Override
    public String getName() {
        return "PotionObject";
    }
}
