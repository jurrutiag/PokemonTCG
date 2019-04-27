package cc3002.tarea1;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 * @author Juan Urrutia
 */
public abstract class Energy implements Card, IEnergy {


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActivelySelectable() {
        return false;
    }


    /**
     * Add an energy to an energy set.
     *
     * @param energies Energy set that will be used for storing the energy that calls the method
     */
    public abstract void addTo(EnergySet energies);

    /**
     *
     * @return Returns the name of the energy.
     */
    public abstract String getName();

}
