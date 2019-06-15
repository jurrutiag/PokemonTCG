package cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * Electric IAttack, represents an attack that requires electric energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class ElectricAttack extends AbstractAttack {

    public ElectricAttack() {
        super(10);
    }

    @Override
    public String getDescription() {
        return "IAttack of electricity";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setElectricEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "ElectricAttack";
    }

}
