package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;

/**
 * Fighting Attack, represents an attack that requires fighting energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class FightingAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Physical attack";
    }

    @Override
    public EnergySet getCost() {
        EnergySet set = new EnergySet();
        set.setFightingEnergies(2);
        return set;
    }

    @Override
    public String getName() {
        return "FightingAttack";
    }

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}