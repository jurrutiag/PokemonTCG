package cc3002.tarea2.game.ability.attack.implemented_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * Fire IAttack, represents an attack that requires fire energies, created for testing.
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
        return "IAttack of fire";
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

}