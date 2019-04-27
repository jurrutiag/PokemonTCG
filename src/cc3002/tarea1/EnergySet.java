package cc3002.tarea1;

import cc3002.tarea1.energies.*;

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
     * Adds an energy to the set that receives the message. This method sends a message
     * to the energy that wants to be added, uses double dispatch.
     * @param energy The energy to be added to the set.
     */
    public void addEnergy(IEnergy energy) {
        energy.addTo(this);
    }

    /**
     *
     * @return Returns the ammount of fire energies in the set.
     */
    public int getFireEnergies() {
        return energies.get(new FireEnergy().getName());
    }

    /**
     *
     * @return Returns the ammount of grass energies in the set.
     */
    public int getGrassEnergies() {
        return energies.get(new GrassEnergy().getName());
    }

    /**
     *
     * @return Returns the ammount of psychic energies in the set.
     */
    public int getPsychicEnergies() {
        return energies.get(new PsychicEnergy().getName());
    }

    /**
     *
     * @return Returns the ammount of water energies in the set.
     */
    public int getWaterEnergies() {
        return energies.get(new WaterEnergy().getName());
    }

    /**
     *
     * @return Returns the ammount of electric energies in the set.
     */
    public int getElectricEnergies() {
        return energies.get(new ElectricEnergy().getName());
    }

    /**
     *
     * @return Returns the ammount of fighting energies in the set.
     */
    public int getFightingEnergies() {
        return energies.get(new FightingEnergy().getName());
    }


    /**
     * Adds one electric energy to the set.
     */
    public void addElectric() {
        energies.replace(new ElectricEnergy().getName(), energies.get(new ElectricEnergy().getName()) + 1);
    }

    /**
     * Adds one fighting energy to the set.
     */
    public void addFighting() {
        energies.replace(new FightingEnergy().getName(), energies.get(new FightingEnergy().getName()) + 1);
    }

    /**
     * Adds one fire energy to the set.
     */
    public void addFire() {
        energies.replace(new FireEnergy().getName(), energies.get(new FireEnergy().getName()) + 1);
    }

    /**
     * Adds one grass energy to the set.
     */
    public void addGrass() {
        energies.replace(new GrassEnergy().getName(), energies.get(new GrassEnergy().getName()) + 1);
    }

    /**
     * Adds one psychic energy to the set.
     */
    public void addPsychic() {
        energies.replace(new PsychicEnergy().getName(), energies.get(new PsychicEnergy().getName()) + 1);
    }

    /**
     * Adds one water energy to the set.
     */
    public void addWater() {
        energies.replace(new WaterEnergy().getName(), energies.get(new WaterEnergy().getName()) + 1);
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
}
