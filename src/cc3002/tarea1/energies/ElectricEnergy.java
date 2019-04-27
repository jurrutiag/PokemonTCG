package cc3002.tarea1.energies;

import cc3002.tarea1.Energy;
import cc3002.tarea1.EnergySet;

/**
 * Class representing an electric energy for the Pokemons to be binded allowing them to cast abilities.
 */
public class ElectricEnergy extends Energy {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTo(EnergySet energies) {
        energies.addElectric();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "ElectricEnergy";
    }
}
