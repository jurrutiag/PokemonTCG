package cc3002.tarea1.energies;

import cc3002.tarea1.Energy;
import cc3002.tarea1.EnergySet;

/**
 * Class representing a fire energy for the Pokemons to be binded allowing them to cast abilities.
 */
public class FireEnergy extends Energy {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTo(EnergySet energies) {
        energies.addFire();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "FireEnergy";
    }
}
