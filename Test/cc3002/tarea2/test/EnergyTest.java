package cc3002.tarea2.test;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnergyTest {
    private IEnergyCard electricEnergyCard;
    private IEnergyCard fightingEnergyCard;
    private IEnergyCard fireEnergyCard;
    private IEnergyCard grassEnergyCard;
    private IEnergyCard psychicEnergyCard;
    private IEnergyCard waterEnergyCard;

    private EnergySet energies1;
    private EnergySet energies2;

    private ICard electricPokemon;
    private ICard fightingPokemon;

    private Trainer trainer1;

    @Before
    public void setUp() {
        trainer1 = new Trainer();

        electricEnergyCard = new ElectricEnergyCard();
        fightingEnergyCard = new FightingEnergyCard();
        fireEnergyCard = new FireEnergyCard();
        grassEnergyCard = new GrassEnergyCard();
        psychicEnergyCard = new PsychicEnergyCard();
        waterEnergyCard = new WaterEnergyCard();

        energies1 = new EnergySet();
        energies2 = new EnergySet();

        electricPokemon = new ElectricTypePokemonCard(trainer1);
        fightingPokemon = new FightingTypePokemonCard(trainer1);


    }

    @Test
    public void addEnergy() throws Exception {
        assertEquals(0, energies1.getElectricEnergies());
        assertEquals(0, energies1.getPsychicEnergies());
        assertEquals(0, energies1.getFireEnergies());
        assertEquals(0, energies1.getGrassEnergies());
        assertEquals(0, energies1.getPsychicEnergies());
        assertEquals(0, energies1.getWaterEnergies());

        energies1.addElectricEnergy();
        assertEquals(1, energies1.getElectricEnergies());
        energies1.addFightingEnergy();
        assertEquals(1, energies1.getFightingEnergies());
        energies1.addFireEnergy();
        assertEquals(1, energies1.getFireEnergies());
        energies1.addGrassEnergy();
        assertEquals(1, energies1.getGrassEnergies());
        energies1.addPsychicEnergy();
        assertEquals(1, energies1.getPsychicEnergies());
        energies1.addWaterEnergy();
        assertEquals(1, energies1.getWaterEnergies());

        energies1.addElectricEnergy();
        assertEquals(2, energies1.getElectricEnergies());
        energies1.addFightingEnergy();
        assertEquals(2, energies1.getFightingEnergies());
        energies1.addFireEnergy();
        assertEquals(2, energies1.getFireEnergies());
        energies1.addGrassEnergy();
        assertEquals(2, energies1.getGrassEnergies());
        energies1.addPsychicEnergy();
        assertEquals(2, energies1.getPsychicEnergies());
        energies1.addWaterEnergy();
        assertEquals(2, energies1.getWaterEnergies());
    }

    @Test
    public void includesEnergy() throws Exception {
        energies1 = new EnergySet();
        energies1.setElectricEnergies(2);
        EnergySet energies2 = new EnergySet();
        energies2.setElectricEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1.setFightingEnergies(2);
        energies2.setFightingEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1.setFireEnergies(2);
        energies2.setFireEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1.setGrassEnergies(2);
        energies2.setGrassEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1.setPsychicEnergies(2);
        energies2.setPsychicEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1.setWaterEnergies(2);
        energies2.setWaterEnergies(1);

        assertTrue(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));

        energies1 = new EnergySet();
        energies1.addElectricEnergy();
        energies1.addFightingEnergy();
        energies1.addFireEnergy();
        energies1.addGrassEnergy();
        energies1.addPsychicEnergy();
        energies1.addWaterEnergy();
        energies2 = new EnergySet();
        energies2.addElectricEnergy();
        energies2.addFightingEnergy();
        energies2.addFireEnergy();
        energies2.addGrassEnergy();
        energies2.addPsychicEnergy();
        energies2.addWaterEnergy();

        assertTrue(energies1.includesEnergies(energies2));
        assertTrue(energies2.includesEnergies(energies1));

        energies1 = new EnergySet();
        energies1.setElectricEnergies(2);
        energies1.addFightingEnergy();
        energies1.addFireEnergy();
        energies1.addGrassEnergy();
        energies1.addPsychicEnergy();
        energies1.addWaterEnergy();

        energies2 = new EnergySet();
        energies2.addElectricEnergy();
        energies2.addFightingEnergy();
        energies2.addFireEnergy();
        energies2.addGrassEnergy();
        energies2.addPsychicEnergy();
        energies2.setWaterEnergies(2);

        assertFalse(energies1.includesEnergies(energies2));
        assertFalse(energies2.includesEnergies(energies1));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("ElectricEnergyCard", electricEnergyCard.getName());
        assertEquals("FightingEnergyCard", fightingEnergyCard.getName());
        assertEquals("FireEnergyCard", fireEnergyCard.getName());
        assertEquals("GrassEnergyCard", grassEnergyCard.getName());
        assertEquals("PsychicEnergyCard", psychicEnergyCard.getName());
        assertEquals("WaterEnergyCard", waterEnergyCard.getName());
    }

    @Test
    public void energySetSize() throws Exception {
        assertEquals(0, energies1.energySetSize());
        energies1.addWaterEnergy();
        assertEquals(1, energies1.energySetSize());
        energies1.addElectricEnergy();
        assertEquals(2, energies1.energySetSize());
        energies1.addFireEnergy();
        assertEquals(3, energies1.energySetSize());
        energies1.addFightingEnergy();
        assertEquals(4, energies1.energySetSize());
        energies1.addPsychicEnergy();
        assertEquals(5, energies1.energySetSize());
        energies1.addGrassEnergy();
        assertEquals(6, energies1.energySetSize());

    }

    @Test
    public void equals() throws Exception {
        assertEquals(energies1, energies2);
        energies1.addElectricEnergy();
        energies2.addElectricEnergy();
        assertEquals(energies1, energies2);
        energies1.addFightingEnergy();
        energies2.addFightingEnergy();
        assertEquals(energies1, energies2);
        energies1.addFireEnergy();
        energies2.addFireEnergy();
        assertEquals(energies1, energies2);
        energies1.addGrassEnergy();
        energies2.addGrassEnergy();
        assertEquals(energies1, energies2);
        energies1.addPsychicEnergy();
        energies2.addPsychicEnergy();
        assertEquals(energies1, energies2);
        energies1.addWaterEnergy();
        energies2.addWaterEnergy();
        assertEquals(energies1, energies2);
        energies1.addElectricEnergy();
        assertFalse(energies1.equals(energies2));
    }

    @Test
    public void bindEnergyToOther() throws Exception {
        trainer1.addCard(electricEnergyCard);
        trainer1.addCard(electricPokemon);
        trainer1.addCard(fightingPokemon);
        trainer1.selectHandCard(1);
        trainer1.playCard();
        trainer1.selectHandCard(1);
        trainer1.playCard();

        trainer1.selectHandCard(0);
        trainer1.selectBenchPokemon(1);
        trainer1.playCard();
        EnergySet toVerify = new EnergySet();
        toVerify.addElectricEnergy();
        assertEquals(toVerify, trainer1.getSelectedPokemon().getEnergySet());
    }

}