package cc3002.tarea2.game.cards.trainer.object.implemented_objects;

import cc3002.tarea2.game.cards.trainer.object.AbstractInstantObject;

/**
 * Potion. Instant object that restores some pokemon's health.
 *
 * @author Juan Urrutia
 */
public class PotionObject extends AbstractInstantObject {

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeEffect() {
        this.getPokemon().setHp(this.getPokemon().getHp() + 20);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Removes up to 2 damage counters on the pokemon.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "PotionObject";
    }
}
