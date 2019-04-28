package cc3002.tarea1.game;

/**
 * Represents an energy card, required for the Pokemons to cast abilities.
 *
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
     * @param energySet Energy set that will be used for storing the energy that calls the method
     */
    public void addTo(EnergySet energySet) {
        energySet.replaceValue(this.getName(), energySet.getEnergies(this) + 1);
    }

    /**
     * Removes this energy from an EnergySet.
     * @param energySet The EnergySet from which this energy will be removed.
     */
    public void beRemovedFrom(EnergySet energySet) {
        if (energySet.getEnergies(this) - 1 >= 0) {
            energySet.replaceValue(this.getName(), energySet.getEnergies(this) - 1);
        } else {
            energySet.replaceValue(this.getName(), 0);
        }
    }

    /**
     * Makes the player play this energy card.
     * @param trainer The trainer that plays the card.
     */
    public void bePlayedBy(Trainer trainer) {
        trainer.addEnergy(this);
    }

    /**
     * {@inheritDoc}
     */
    public abstract String getName();

}
