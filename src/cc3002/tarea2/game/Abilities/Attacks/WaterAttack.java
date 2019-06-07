package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;

/**
 * Water Attack, represents an attack that requires water energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class WaterAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of water";
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

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}