package cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * Water IAttack, represents an attack that requires water energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class WaterAttack extends AbstractAttack {
    public WaterAttack() {
        super(10);
    }


    @Override
    public String getDescription() {
        return "IAttack of water";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setWaterEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "WaterAttack";
    }


}