package cc3002.tarea2.game.ability.attack.implemented_attacks;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.AbstractAttack;

/**
 * Psychic IAttack, represents an attack that requires psychic energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class PsychicAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "IAttack of psyche";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setPsychicEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "PsychicAttack";
    }

}