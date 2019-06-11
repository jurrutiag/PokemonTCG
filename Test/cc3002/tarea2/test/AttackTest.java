package cc3002.tarea2.test;

import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.ability.attack.implemented_attacks.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttackTest {

    private IAttack electricAttack;
    private IAttack fightingAttack;
    private IAttack fireAttack;
    private IAttack grassAttack;
    private IAttack psychicAttack;
    private IAttack waterAttack;

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

        electricCost = new EnergySet();
        electricCost.setElectricEnergies(2);
        fightingCost = new EnergySet();
        fightingCost.setFightingEnergies(2);
        fireCost = new EnergySet();
        fireCost.setFireEnergies(2);
        grassCost = new EnergySet();
        grassCost.setGrassEnergies(2);
        psychicCost = new EnergySet();
        psychicCost.setPsychicEnergies(2);
        waterCost = new EnergySet();
        waterCost.setWaterEnergies(2);
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
        assertEquals("IAttack of electricity", electricAttack.getDescription());
        assertEquals("Physical attack", fightingAttack.getDescription());
        assertEquals("IAttack of fire", fireAttack.getDescription());
        assertEquals("IAttack of grass", grassAttack.getDescription());
        assertEquals("IAttack of psyche", psychicAttack.getDescription());
        assertEquals("IAttack of water", waterAttack.getDescription());
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