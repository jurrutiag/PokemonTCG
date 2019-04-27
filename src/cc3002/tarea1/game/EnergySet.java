package cc3002.tarea1.game;

import cc3002.tarea1.game.energies.*;
import java.util.HashMap;

/**
 * Class that represents a set of energy cards, it is made of a HashMap indexed with Strings
 * that point to integers representing the number of energies it currently has.
 *
 * @author Juan Urrutia
 */
public class EnergySet implements IEnergy{

    /**
     * A HashMap for the base structure of the set.
     */
    private HashMap<String, Integer> energies;

    /**
     * Creates an energy set with default values of zero for each energy, representing an empty set.
     */
    public EnergySet() {
        this(0, 0, 0, 0, 0, 0);
    }

    /**
     * Creates an energy set with predefined values.
     * @param electric the ammount of electric energies the set has.
     * @param fighting the ammount of fighting energies the set has.
     * @param fire the ammount of fire energies the set has.
     * @param grass the ammount of grass energies the set has.
     * @param psychic the ammount of psychic energies the set has.
     * @param water the ammount of water energies the set has.
     */
    public EnergySet(int electric, int fighting, int fire, int grass, int psychic, int water) {
        energies = new HashMap<String, Integer>();

        energies.put(new ElectricEnergy().getName(), electric);
        energies.put(new FightingEnergy().getName(), fighting);
        energies.put(new FireEnergy().getName(), fire);
        energies.put(new GrassEnergy().getName(), grass);
        energies.put(new PsychicEnergy().getName(), psychic);
        energies.put(new WaterEnergy().getName(), water);
    }

    /**
     *
     * @return Returns the ammount of energies the Set has.
     */
    public int energySetSize() {
        int sum = 0;
        for (String key : energies.keySet()) {
            sum += energies.get(key);
        }
        return sum;
    }

    /**
     * Adds an energy to the set that receives the message. This method sends a message
     * to the energy that wants to be added, uses double dispatch.
     * @param energy The energy to be added to the set.
     */
    public void addEnergy(IEnergy energy) {
        energy.addTo(this);
    }

    /**
     * Removes an IEnergy from the current set.
     * @param energy
     */
    public void removeEnergy(IEnergy energy) {
        energy.beRemovedFrom(this);
    }

    /**
     *
     * @param energy Energy to be asked for.
     * @return Returns the amount of a specific energy in the set.
     */
    public int getEnergies(Energy energy) {
        return energies.get(energy.getName());
    }

    /**
     * Replaces the value stored in key in the HashMap for a new value
     * @param key The key of the Set which value will be replaced.
     * @param value The value to be changed to.
     */
    public void replaceValue(String key, int value) {
        energies.replace(key, value);
    }

    /**
     * Checks if the object that receives this message has energySet as a subset.
     * @param energySet Set that will be verified as a subset of the set that receives the message.
     * @return Returns true if energySet is a subset of the energy set that receives the message, false otherwise.
     */
    public boolean includesEnergies(EnergySet energySet) {
        boolean isIncluded = true;
        for (String key : energies.keySet()) {
            isIncluded = isIncluded && (this.energies.get(key) >= energySet.energies.get(key));
        }
        return isIncluded;
    }

    /**
     * Adds a an EnergySet to the current set.
     * @param energySet The EnergySet to be added.
     */
    @Override
    public void addTo(EnergySet energySet) {
        for (String key: this.energies.keySet()) {
            energySet.energies.put(key, energySet.energies.get(key) + this.energies.get(key));
        }
    }

    /**
     * Removes an EnergySet from another, that is, subtraction of sets
     * @param energySet The set from which this set will be removed.
     */
    public void beRemovedFrom(EnergySet energySet) {
        for (String key: this.energies.keySet()) {
            if (energySet.energies.get(key) - this.energies.get(key) >= 0) {
                energySet.energies.put(key, energySet.energies.get(key) - this.energies.get(key));
            } else {
                energySet.energies.put(key, 0);
            }
        }
    }
}
