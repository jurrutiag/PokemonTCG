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
        //TODO review the possibility of changing EnergySet implementation.
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

    public int getElectricEnergies() {
        return energies.get(EnergyType.ELECTRIC);
    }

    public int getFightingEnergies() {
        return energies.get(EnergyType.FIGHTING);
    }

    public int getFireEnergies() {
        return energies.get(EnergyType.FIRE);
    }

    public int getGrassEnergies() {
        return energies.get(EnergyType.GRASS);
    }

    public int getPsychicEnergies() {
        return energies.get(EnergyType.PSYCHIC);
    }

    public int getWaterEnergies() {
        return energies.get(EnergyType.WATER);
    }



    public void setElectricEnergies(int value) {
        energies.replace(EnergyType.ELECTRIC, value);
    }

    public void setFightingEnergies(int value) {
        energies.replace(EnergyType.FIGHTING, value);
    }

    public void setFireEnergies(int value) {
        energies.replace(EnergyType.FIRE, value);
    }

    public void setGrassEnergies(int value) {
        energies.replace(EnergyType.GRASS, value);
    }

    public void setPsychicEnergies(int value) {
        energies.replace(EnergyType.PSYCHIC, value);
    }

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
     * Adds an EnergySet to the current set.
     * @param energySet The EnergySet to be added.
     */
    public void addTo(EnergySet energySet) {
        for (EnergyType type : EnergyType.values()) {
            energySet.energies.put(type, energySet.energies.get(type) + this.energies.get(type));
        }
    }

    /**
     * Removes an EnergySet from another, that is, subtraction of sets
     * @param energySet The set from which this set will be removed.
     */
    public void beRemovedFrom(EnergySet energySet) {
        for (EnergyType type : EnergyType.values()) {
            if (energySet.energies.get(type) - this.energies.get(type) >= 0) {
                energySet.energies.put(type, energySet.energies.get(type) - this.energies.get(type));
            } else {
                energySet.energies.put(type, 0);
            }
        }
    }

    public void addElectricEnergy() {
        this.setElectricEnergies(this.getElectricEnergies() + 1);
    }


    public void addFightingEnergy() {
        this.setFightingEnergies(this.getFightingEnergies() + 1);
    }

    public void addFireEnergy() {
        this.setFireEnergies(this.getFireEnergies() + 1);
    }

    public void addGrassEnergy() {
        this.setGrassEnergies(this.getGrassEnergies() + 1);
    }

    public void addPsychicEnergy() {
        this.setPsychicEnergies(this.getPsychicEnergies() + 1);
    }

    public void addWaterEnergy() {
        this.setWaterEnergies(this.getWaterEnergies() + 1);
    }

}
