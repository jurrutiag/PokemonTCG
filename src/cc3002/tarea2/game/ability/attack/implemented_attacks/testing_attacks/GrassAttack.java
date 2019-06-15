package cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;


/**
 * Grass IAttack, represents an attack that requires grass energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class GrassAttack extends AbstractAttack {
    public GrassAttack() {
        super(10);
    }

    @Override
    public String getDescription() {
        return "IAttack of grass";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setGrassEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "GrassAttack";
    }


}