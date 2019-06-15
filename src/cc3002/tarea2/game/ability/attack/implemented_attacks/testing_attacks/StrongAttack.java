package cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * Strong IAttack, represents a strong attack that doesnt require energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class StrongAttack extends AbstractAttack {
    public StrongAttack() {
        super(30);
    }


    @Override
    public String getDescription() {
        return "Strong Attack";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        return set;
    }

    @Override
    public String getName() {
        return "StrongAttack";
    }


}