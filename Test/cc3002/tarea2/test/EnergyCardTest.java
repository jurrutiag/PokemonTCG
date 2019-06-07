package cc3002.tarea2.test;

import cc3002.tarea2.game.cards.EnergyCard;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.cards.energies.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnergyCardTest {
    private EnergyCard electricEnergyCard;
    private EnergyCard fightingEnergyCard;
    private EnergyCard fireEnergyCard;
    private EnergyCard grassEnergyCard;
    private EnergyCard psychicEnergyCard;
    private EnergyCard waterEnergyCard;

    private EnergySet energies;

    @Before
    public void setUp() {
        electricEnergyCard = new ElectricEnergyCard();
        fightingEnergyCard = new FightingEnergyCard();
        fireEnergyCard = new FireEnergyCard();
        grassEnergyCard = new GrassEnergyCard();
        psychicEnergyCard = new PsychicEnergyCard();
        waterEnergyCard = new WaterEnergyCard();

        energies = new EnergySet();
    }

    @Test
    public void addEnergy() {
        assertEquals(0, energies.getElectricEnergies());
        assertEquals(0, energies.getPsychicEnergies());
        assertEquals(0, energies.getFireEnergies());
        assertEquals(0, energies.getGrassEnergies());
        assertEquals(0, energies.getPsychicEnergies());
        assertEquals(0, energies.getWaterEnergies());

        energies.addElectricEnergy();
        assertEquals(1, energies.getElectricEnergies());
        energies.addFightingEnergy();
        assertEquals(1, energies.getFightingEnergies());
        energies.addFireEnergy();
        assertEquals(1, energies.getFireEnergies());
        energies.addGrassEnergy();
        assertEquals(1, energies.getGrassEnergies());
        energies.addPsychicEnergy();
        assertEquals(1, energies.getPsychicEnergies());
        energies.addWaterEnergy();
        assertEquals(1, energies.getWaterEnergies());

        energies.addElectricEnergy();
        assertEquals(2, energies.getElectricEnergies());
        energies.addFightingEnergy();
        assertEquals(2, energies.getFightingEnergies());
        energies.addFireEnergy();
        assertEquals(2, energies.getFireEnergies());
        energies.addGrassEnergy();
        assertEquals(2, energies.getGrassEnergies());
        energies.addPsychicEnergy();
        assertEquals(2, energies.getPsychicEnergies());
        energies.addWaterEnergy();
        assertEquals(2, energies.getWaterEnergies());
    }

    @Test
    public void includesEnergy() {
        energies = new EnergySet();
        energies.setElectricEnergies(2);
        EnergySet energies2 = new EnergySet();
        energies2.setElectricEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies.setFightingEnergies(2);
        energies2.setFightingEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies.setFireEnergies(2);
        energies2.setFireEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies.setGrassEnergies(2);
        energies2.setGrassEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies.setPsychicEnergies(2);
        energies2.setPsychicEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies.setWaterEnergies(2);
        energies2.setWaterEnergies(1);

        assertTrue(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));

        energies = new EnergySet();
        energies.addElectricEnergy();
        energies.addFightingEnergy();
        energies.addFireEnergy();
        energies.addGrassEnergy();
        energies.addPsychicEnergy();
        energies.addWaterEnergy();
        energies2 = new EnergySet();
        energies2.addElectricEnergy();
        energies2.addFightingEnergy();
        energies2.addFireEnergy();
        energies2.addGrassEnergy();
        energies2.addPsychicEnergy();
        energies2.addWaterEnergy();

        assertTrue(energies.includesEnergies(energies2));
        assertTrue(energies2.includesEnergies(energies));

        energies = new EnergySet();
        energies.setElectricEnergies(2);
        energies.addFightingEnergy();
        energies.addFireEnergy();
        energies.addGrassEnergy();
        energies.addPsychicEnergy();
        energies.addWaterEnergy();

        energies2 = new EnergySet();
        energies2.addElectricEnergy();
        energies2.addFightingEnergy();
        energies2.addFireEnergy();
        energies2.addGrassEnergy();
        energies2.addPsychicEnergy();
        energies2.setWaterEnergies(2);

        assertFalse(energies.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies));
    }

    @Test
    public void getName() {
        assertEquals("ElectricEnergyCard", electricEnergyCard.getName());
        assertEquals("FightingEnergyCard", fightingEnergyCard.getName());
        assertEquals("FireEnergyCard", fireEnergyCard.getName());
        assertEquals("GrassEnergyCard", grassEnergyCard.getName());
        assertEquals("PsychicEnergyCard", psychicEnergyCard.getName());
        assertEquals("WaterEnergyCard", waterEnergyCard.getName());
    }

    @Test
    public void energySetSize() {
        assertEquals(0, energies.energySetSize());
        energies.addWaterEnergy();
        assertEquals(1, energies.energySetSize());
        energies.addElectricEnergy();
        assertEquals(2, energies.energySetSize());
        energies.addFireEnergy();
        assertEquals(3, energies.energySetSize());
        energies.addFightingEnergy();
        assertEquals(4, energies.energySetSize());
        energies.addPsychicEnergy();
        assertEquals(5, energies.energySetSize());
        energies.addGrassEnergy();
        assertEquals(6, energies.energySetSize());

    }

}