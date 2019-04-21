package cc3002.tarea1;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 * @author Juan Urrutia
 */
public abstract class Energy implements Card {

    /**
     * Checks if the card can be used as an active pokemon, in this case,
     * the card is an Energy so the answer is always no.
     *
     * @return Boolean value that represents if the card is selectable as active pokemon.
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

}
