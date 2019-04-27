package cc3002.tarea1.game;

/**
 * Interface provided for adding energies and EnergySet
 *
 * @author Juan Urrutia
 */
public interface IEnergy {
    /**
     * Adds an IEnergy to an energySet
     * @param energySet The energy set that will add the IEnergy.
     */
    void addTo(EnergySet energySet);

    void beRemovedFrom(EnergySet energySet);
}
