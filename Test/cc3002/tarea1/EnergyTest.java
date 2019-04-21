package cc3002.tarea1;

import cc3002.tarea1.energies.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnergyTest {
    Energy electricEnergy;
    Energy fightingEnergy;
    Energy fireEnergy;
    Energy grassEnergy;
    Energy psychicEnergy;
    Energy waterEnergy;

    EnergySet energies;
    EnergySet energies2;

    @Before
    public void setUp() {
        electricEnergy = new ElectricEnergy();
        fightingEnergy = new FightingEnergy();
        fireEnergy = new FireEnergy();
        grassEnergy = new GrassEnergy();
        psychicEnergy = new PsychicEnergy();
        waterEnergy = new WaterEnergy();

        energies = new EnergySet();
    }

    @Test
    public void addEnergy() {
        assertEquals(0, energies.getElectricEnergies());
        assertEquals(0, energies.getFightingEnergies());
        assertEquals(0, energies.getFireEnergies());
        assertEquals(0, energies.getGrassEnergies());
        assertEquals(0, energies.getPsychicEnergies());
        assertEquals(0, energies.getWaterEnergies());

        energies.addElectric();
        assertEquals(1, energies.getElectricEnergies());
        energies.addFighting();
        assertEquals(1, energies.getFightingEnergies());
        energies.addFire();
        assertEquals(1, energies.getFireEnergies());
        energies.addGrass();
        assertEquals(1, energies.getGrassEnergies());
        energies.addPsychic();
        assertEquals(1, energies.getPsychicEnergies());
        energies.addWater();
        assertEquals(1, energies.getWaterEnergies());

        energies.addElectric();
        assertEquals(2, energies.getElectricEnergies());
        energies.addFighting();
        assertEquals(2, energies.getFightingEnergies());
        energies.addFire();
        assertEquals(2, energies.getFireEnergies());
        energies.addGrass();
        assertEquals(2, energies.getGrassEnergies());
        energies.addPsychic();
        assertEquals(2, energies.getPsychicEnergies());
        energies.addWater();
        assertEquals(2, energies.getWaterEnergies());
    }

    @Test
    public void includesEnergy() {
        energies = new EnergySet(2, 0, 0, 0, 0, 0);
        energies2 = new EnergySet(1, 0, 0, 0, 0, 0);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(0, 2, 0, 0, 0, 0);
        energies2 = new EnergySet(0, 1, 0, 0, 0, 0);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(0, 0, 2, 0, 0, 0);
        energies2 = new EnergySet(0, 0, 1, 0, 0, 0);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(0, 0, 0, 2, 0, 0);
        energies2 = new EnergySet(0, 0, 0, 1, 0, 0);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(0, 0, 0, 0, 2, 0);
        energies2 = new EnergySet(0, 0, 0, 0, 1, 0);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(0, 0, 0, 0, 0, 2);
        energies2 = new EnergySet(0, 0, 0, 0, 0, 1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet(1, 1, 1, 1, 1, 1);
        energies2 = new EnergySet(1, 1, 1, 1, 1, 1);

        assertTrue(energies.includesEnergies(energies2));
        assertTrue(energies2.includesEnergies(energies));

        energies = new EnergySet(2, 1, 1, 1, 1, 1);
        energies2 = new EnergySet(1, 1, 1, 1, 1, 2);

        assertFalse(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));
    }

}