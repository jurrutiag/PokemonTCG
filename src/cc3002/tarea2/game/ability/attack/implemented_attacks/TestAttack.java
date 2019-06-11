package cc3002.tarea2.game.ability.attack.implemented_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * TestAttack represents an attack made for testing double dispatch on implemented_pokemons.
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
        return "IAttack for testing";
    }

    @Override
    public EnergySet getCost() {
        return new EnergySet();
    }

    @Override
    public String getName() {
        return "TestAttack";
    }

}
