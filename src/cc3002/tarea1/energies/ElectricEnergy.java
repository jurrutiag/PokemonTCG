package cc3002.tarea1.energies;

import cc3002.tarea1.Energy;
import cc3002.tarea1.EnergySet;

public class ElectricEnergy extends Energy {

    public void addTo(EnergySet energies) {
        energies.addElectric();
    }
}
