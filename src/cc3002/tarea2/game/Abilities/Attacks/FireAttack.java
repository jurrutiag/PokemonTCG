package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;

/**
 * Fire Attack, represents an attack that requires fire energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class FireAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of fire";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setFireEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "FireAttack";
    }

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}