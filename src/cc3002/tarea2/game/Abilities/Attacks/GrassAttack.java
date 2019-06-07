package cc3002.tarea2.game.Abilities.Attacks;

import cc3002.tarea2.game.Abilities.AbstractAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.IPokemonCard;


/**
 * Grass Attack, represents an attack that requires grass energies, created for testing.
 *
 * @author Juan Urrutia
 */
public class GrassAttack extends AbstractAttack {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Attack of grass";
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

    @Override
    public void executeEffect(IPokemonCard pokemon) {
        return;
    }
}