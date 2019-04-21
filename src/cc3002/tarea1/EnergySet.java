package cc3002.tarea1;

import java.util.HashMap;

public class EnergySet {

    private HashMap<String, Integer> energies;

    public EnergySet() {
        this(0, 0, 0, 0, 0, 0);
    }

    public EnergySet(int electric, int fighting, int fire, int grass, int psychic, int water) {
        energies = new HashMap<String, Integer>();

        energies.put("Electric", electric);
        energies.put("Fighting", fighting);
        energies.put("Fire", fire);
        energies.put("Grass", grass);
        energies.put("Psychic", psychic);
        energies.put("Water", water);
    }

    public void addEnergy(Energy energy) {
        energy.addTo(this);
    }

    public int getFireEnergies() {
        return energies.get("Fire");
    }

    public int getGrassEnergies() {
        return energies.get("Grass");
    }

    public int getPsychicEnergies() {
        return energies.get("Psychic");
    }

    public int getWaterEnergies() {
        return energies.get("Water");
    }

    public int getElectricEnergies() {
        return energies.get("Electric");
    }

    public int getFightingEnergies() {
        return energies.get("Fighting");
    }


    public void addElectric() {
        energies.replace("Electric", energies.get("Electric") + 1);
    }

    public void addFighting() {
        energies.replace("Fighting", energies.get("Fighting") + 1);
    }

    public void addFire() {
        energies.replace("Fire", energies.get("Fire") + 1);
    }

    public void addGrass() {
        energies.replace("Grass", energies.get("Grass") + 1);
    }

    public void addPsychic() {
        energies.replace("Psychic", energies.get("Psychic") + 1);
    }

    public void addWater() {
        energies.replace("Water", energies.get("Water") + 1);
    }

    public boolean includesEnergies(EnergySet energySet) {
        boolean isIncluded = true;
        for (String key : energies.keySet()) {
            isIncluded = isIncluded && (this.energies.get(key) >= energySet.energies.get(key));
        }
        return isIncluded;
    }
}
