package cc3002.tarea1;

/**
 * Interface provided for adding energies and EnergySet
 */
public interface IEnergy {
    /**
     * Adds an IEnergy to an energySet
     * @param energySet The energy set that will add the IEnergy.
     */
    void addTo(EnergySet energySet);
}
