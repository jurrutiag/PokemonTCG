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
        assertEquals(0, energies.getEnergies(electricEnergy));
        assertEquals(0, energies.getEnergies(psychicEnergy));
        assertEquals(0, energies.getEnergies(fireEnergy));
        assertEquals(0, energies.getEnergies(grassEnergy));
        assertEquals(0, energies.getEnergies(psychicEnergy));
        assertEquals(0, energies.getEnergies(waterEnergy));

        energies.addEnergy(new ElectricEnergy());
        assertEquals(1, energies.getEnergies(electricEnergy));
        energies.addEnergy(new FightingEnergy());
        assertEquals(1, energies.getEnergies(fightingEnergy));
        energies.addEnergy(new FireEnergy());
        assertEquals(1, energies.getEnergies(fireEnergy));
        energies.addEnergy(new GrassEnergy());
        assertEquals(1, energies.getEnergies(grassEnergy));
        energies.addEnergy(new PsychicEnergy());
        assertEquals(1, energies.getEnergies(psychicEnergy));
        energies.addEnergy(new WaterEnergy());
        assertEquals(1, energies.getEnergies(waterEnergy));

        energies.addEnergy(new ElectricEnergy());
        assertEquals(2, energies.getEnergies(electricEnergy));
        energies.addEnergy(new FightingEnergy());
        assertEquals(2, energies.getEnergies(fightingEnergy));
        energies.addEnergy(new FireEnergy());
        assertEquals(2, energies.getEnergies(fireEnergy));
        energies.addEnergy(new GrassEnergy());
        assertEquals(2, energies.getEnergies(grassEnergy));
        energies.addEnergy(new PsychicEnergy());
        assertEquals(2, energies.getEnergies(psychicEnergy));
        energies.addEnergy(new WaterEnergy());
        assertEquals(2, energies.getEnergies(waterEnergy));
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

    @Test
    public void getName() {
        assertEquals("ElectricEnergy", electricEnergy.getName());
        assertEquals("FightingEnergy", fightingEnergy.getName());
        assertEquals("FireEnergy", fireEnergy.getName());
        assertEquals("GrassEnergy", grassEnergy.getName());
        assertEquals("PsychicEnergy", psychicEnergy.getName());
        assertEquals("WaterEnergy", waterEnergy.getName());
    }

    @Test
    public void energySetSize() {
        assertEquals(0, energies.energySetSize());
        energies.addEnergy(new WaterEnergy());
        assertEquals(1, energies.energySetSize());
        energies.addEnergy(new ElectricEnergy());
        assertEquals(2, energies.energySetSize());
        energies.addEnergy(new FireEnergy());
        assertEquals(3, energies.energySetSize());
        energies.addEnergy(new FightingEnergy());
        assertEquals(4, energies.energySetSize());
        energies.addEnergy(new PsychicEnergy());
        assertEquals(5, energies.energySetSize());
        energies.addEnergy(new GrassEnergy());
        assertEquals(6, energies.energySetSize());

        energies.removeEnergy(new WaterEnergy());
        assertEquals(5, energies.energySetSize());
        energies.removeEnergy(new WaterEnergy());
        assertEquals(5, energies.energySetSize());
        energies.removeEnergy(new EnergySet(7, 3, 4, 0, 5, 5));
        assertEquals(1, energies.energySetSize());
        energies.removeEnergy(new EnergySet(0, 0, 0, 100, 0, 0));
        assertEquals(0, energies.energySetSize());
        energies.addEnergy(new WaterEnergy());
        assertEquals(1, energies.energySetSize());

    }

}