package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;

/**
 * TestAttack represents an attack made for testing double dispatch on pokemons.
 *
 * @author Juan Urrutia
 */
public class TestAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Attack for testing";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet();
    }

    @Override
    public String getName() {
        return "TestAttack";
    }

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}
