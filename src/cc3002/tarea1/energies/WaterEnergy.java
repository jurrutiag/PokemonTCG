package cc3002.tarea1.energies;

import cc3002.tarea1.Energy;
import cc3002.tarea1.EnergySet;

/**
 * Class representing a water energy for the Pokemons to be binded allowing them to cast abilities.
 */
public class WaterEnergy extends Energy {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTo(EnergySet energies) {
        energies.addWater();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "WaterEnergy";
    }
}
