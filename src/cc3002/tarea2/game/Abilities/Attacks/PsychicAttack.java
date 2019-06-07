package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;

/**
 * Psychic Attack, represents an attack that requires psychic energies, created for testing.
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
        return "Attack of psyche";
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

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}