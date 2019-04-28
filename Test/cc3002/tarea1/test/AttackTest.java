package cc3002.tarea1.test;

import cc3002.tarea1.game.Abilities.Attacks.*;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.EnergySet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttackTest {

    private Attack electricAttack;
    private Attack fightingAttack;
    private Attack fireAttack;
    private Attack grassAttack;
    private Attack psychicAttack;
    private Attack waterAttack;

    private EnergySet electricCost;
    private EnergySet fightingCost;
    private EnergySet fireCost;
    private EnergySet grassCost;
    private EnergySet psychicCost;
    private EnergySet waterCost;

    @Before
    public void setUp() {
        electricAttack = new ElectricAttack();
        fightingAttack = new FightingAttack();
        fireAttack = new FireAttack();
        grassAttack = new GrassAttack();
        psychicAttack = new PsychicAttack();
        waterAttack = new WaterAttack();

        electricCost = new EnergySet(2, 0, 0, 0, 0, 0);
        fightingCost = new EnergySet(0, 2, 0, 0, 0, 0);
        fireCost = new EnergySet(0, 0, 2, 0, 0, 0);
        grassCost = new EnergySet(0, 0, 0, 2, 0, 0);
        psychicCost = new EnergySet(0, 0, 0, 0, 2, 0);
        waterCost = new EnergySet(0, 0, 0, 0, 0, 2);
    }

    @Test
    public void getDamage() {
        assertEquals(10, electricAttack.getDamage());
        assertEquals(10, fightingAttack.getDamage());
        assertEquals(10, fireAttack.getDamage());
        assertEquals(10, grassAttack.getDamage());
        assertEquals(10, psychicAttack.getDamage());
        assertEquals(10, waterAttack.getDamage());
    }

    @Test
    public void getDescription() {
        assertEquals("Attack of electricity", electricAttack.getDescription());
        assertEquals("Physical attack", fightingAttack.getDescription());
        assertEquals("Attack of fire", fireAttack.getDescription());
        assertEquals("Attack of grass", grassAttack.getDescription());
        assertEquals("Attack of psyche", psychicAttack.getDescription());
        assertEquals("Attack of water", waterAttack.getDescription());
    }

    @Test
    public void getCost() {
        assertTrue(electricAttack.getCost().includesEnergies(electricCost) && electricCost.includesEnergies(electricAttack.getCost()));
        assertTrue(fightingAttack.getCost().includesEnergies(fightingCost) && fightingCost.includesEnergies(fightingAttack.getCost()));
        assertTrue(fireAttack.getCost().includesEnergies(fireCost) && fireCost.includesEnergies(fireAttack.getCost()));
        assertTrue(grassAttack.getCost().includesEnergies(grassCost) && grassCost.includesEnergies(grassAttack.getCost()));
        assertTrue(psychicAttack.getCost().includesEnergies(psychicCost) && psychicCost.includesEnergies(psychicAttack.getCost()));
        assertTrue(waterAttack.getCost().includesEnergies(waterCost) && waterCost.includesEnergies(waterAttack.getCost()));
    }

    @Test
    public void getName() {
        assertEquals("ElectricAttack", electricAttack.getName());
        assertEquals("FightingAttack", fightingAttack.getName());
        assertEquals("FireAttack", fireAttack.getName());
        assertEquals("GrassAttack", grassAttack.getName());
        assertEquals("PsychicAttack", psychicAttack.getName());
        assertEquals("WaterAttack", waterAttack.getName());
    }
}