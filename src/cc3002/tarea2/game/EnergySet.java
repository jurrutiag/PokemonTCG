package cc3002.tarea2.game;

import java.util.EnumMap;

/**
 * Class that represents a set of energy cards, it is made of a HashMap indexed with Strings
 * that point to integers representing the number of energies it currently has.
 *
 * @author Juan Urrutia
 */
public class EnergySet {

    /**
     * A HashMap for the base structure of the set.
     */
    private EnumMap<EnergyType, Integer> energies;

    /**
     * Creates an energy set with predefined zero values.
     */
    public EnergySet() {
        energies = new EnumMap<>(EnergyType.class);

        for (EnergyType type : EnergyType.values()) {
            energies.put(type, 0);
        }
    }

    /**
     *
     * @return Returns the ammount of energies the Set has.
     */
    public int energySetSize() {
        int sum = 0;
        for (EnergyType type : EnergyType.values()) {
            sum += energies.get(type);
        }
        return sum;
    }

    /**
     *
     * @return Returns the electric energies.
     */
    public int getElectricEnergies() {
        return energies.get(EnergyType.ELECTRIC);
    }

    /**
     *
     * @return Returns the fighting energies.
     */
    public int getFightingEnergies() {
        return energies.get(EnergyType.FIGHTING);
    }

    /**
     *
     * @return Returns the fire energies.
     */
    public int getFireEnergies() {
        return energies.get(EnergyType.FIRE);
    }

    /**
     *
     * @return Returns the grass energies.
     */
    public int getGrassEnergies() {
        return energies.get(EnergyType.GRASS);
    }

    /**
     *
     * @return Returns the psychic energies.
     */
    public int getPsychicEnergies() {
        return energies.get(EnergyType.PSYCHIC);
    }

    /**
     *
     * @return Returns the water energies.
     */
    public int getWaterEnergies() {
        return energies.get(EnergyType.WATER);
    }


    /**
     * Sets the electric energies to a value.
     * @param value the value to set.
     */
    public void setElectricEnergies(int value) {
        energies.replace(EnergyType.ELECTRIC, value);
    }

    /**
     * Sets the fighting energies to a value.
     * @param value the value to set.
     */
    public void setFightingEnergies(int value) {
        energies.replace(EnergyType.FIGHTING, value);
    }

    /**
     * Sets the fire energies to a value.
     * @param value the value to set.
     */
    public void setFireEnergies(int value) {
        energies.replace(EnergyType.FIRE, value);
    }

    /**
     * Sets the grass energies to a value.
     * @param value the value to set.
     */
    public void setGrassEnergies(int value) {
        energies.replace(EnergyType.GRASS, value);
    }

    /**
     * Sets the psychic energies to a value.
     * @param value the value to set.
     */
    public void setPsychicEnergies(int value) {
        energies.replace(EnergyType.PSYCHIC, value);
    }

    /**
     * Sets the water energies to a value.
     * @param value the value to set.
     */
    public void setWaterEnergies(int value) {
        energies.replace(EnergyType.WATER, value);
    }

    /**
     * Checks if the object that receives this message has energySet as a subset.
     * @param energySet Set that will be verified as a subset of the set that receives the message.
     * @return Returns true if energySet is a subset of the energy set that receives the message, false otherwise.
     */
    public boolean includesEnergies(EnergySet energySet) {
        boolean isIncluded = true;
        for (EnergyType type : EnergyType.values()) {
            isIncluded = isIncluded && (this.energies.get(type) >= energySet.energies.get(type));
        }
        return isIncluded;
    }


    /**
     * Adds one electric energy to the set.
     */
    public void addElectricEnergy() {
        this.setElectricEnergies(this.getElectricEnergies() + 1);
    }

    /**
     * Adds one fighting energy to the set.
     */
    public void addFightingEnergy() {
        this.setFightingEnergies(this.getFightingEnergies() + 1);
    }

    /**
     * Adds one fire energy to the set.
     */
    public void addFireEnergy() {
        this.setFireEnergies(this.getFireEnergies() + 1);
    }

    /**
     * Adds one grass energy to the set.
     */
    public void addGrassEnergy() {
        this.setGrassEnergies(this.getGrassEnergies() + 1);
    }

    /**
     * Adds one psychic energy to the set.
     */
    public void addPsychicEnergy() {
        this.setPsychicEnergies(this.getPsychicEnergies() + 1);
    }

    /**
     * Adds one water energy to the set.
     */
    public void addWaterEnergy() {
        this.setWaterEnergies(this.getWaterEnergies() + 1);
    }

    /**
     *
     * @return Returns the total amount of energies.
     */
    public int getTotalEnergies() {
        int total = 0;
        for (EnergyType energyType : energies.keySet()) {
            total += energies.get(energyType);
        }
        return total;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EnergySet) {
            for (EnergyType energyType : energies.keySet()) {
                if (((EnergySet) obj).energies.get(energyType) != this.energies.get(energyType)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
