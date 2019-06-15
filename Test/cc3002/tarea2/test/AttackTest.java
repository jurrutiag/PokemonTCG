package cc3002.tarea2.test;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.ElectricShock;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.*;
import cc3002.tarea2.game.cards.energies.ElectricEnergyCard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.FightingTypePokemonCard;
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
    private IAttack strongAttack;
    private IAttack testAttack;
    private IAttack electricShock;

    private IPokemonCard electricPokemon;
    private IPokemonCard fightingPokemon;
    private Trainer trainer1;
    private Trainer trainer2;

    private EnergySet electricCost;
    private EnergySet fightingCost;
    private EnergySet fireCost;
    private EnergySet grassCost;
    private EnergySet psychicCost;
    private EnergySet waterCost;
    private EnergySet testCost;
    private EnergySet strongCost;
    private EnergySet electricShockEnergies;

    @Before
    public void setUp() {
        electricAttack = new ElectricAttack();
        fightingAttack = new FightingAttack();
        fireAttack = new FireAttack();
        grassAttack = new GrassAttack();
        psychicAttack = new PsychicAttack();
        waterAttack = new WaterAttack();
        strongAttack = new StrongAttack();
        testAttack = new TestAttack();

        electricShock = new ElectricShock();
        electricShockEnergies = electricShock.getCost();
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        fightingPokemon = new FightingTypePokemonCard(100, new IAttack[] {}, trainer2);
        electricPokemon = new ElectricTypePokemonCard(100, new IAttack[] {new ElectricShock()}, trainer1);

        testCost = new EnergySet();
        strongCost = new EnergySet();
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
        assertEquals("Strong Attack", strongAttack.getDescription());
        assertEquals("IAttack for testing", testAttack.getDescription());
        assertEquals("Throw a coin, if it is tails, this pokemon receives 10 damage.", electricShock.getDescription());
    }

    @Test
    public void getCost() {
        assertTrue(electricAttack.getCost().includesEnergies(electricCost) && electricCost.includesEnergies(electricAttack.getCost()));
        assertTrue(fightingAttack.getCost().includesEnergies(fightingCost) && fightingCost.includesEnergies(fightingAttack.getCost()));
        assertTrue(fireAttack.getCost().includesEnergies(fireCost) && fireCost.includesEnergies(fireAttack.getCost()));
        assertTrue(grassAttack.getCost().includesEnergies(grassCost) && grassCost.includesEnergies(grassAttack.getCost()));
        assertTrue(psychicAttack.getCost().includesEnergies(psychicCost) && psychicCost.includesEnergies(psychicAttack.getCost()));
        assertTrue(waterAttack.getCost().includesEnergies(waterCost) && waterCost.includesEnergies(waterAttack.getCost()));
        assertTrue(testAttack.getCost().includesEnergies(testCost) && testCost.includesEnergies(testAttack.getCost()));
        assertTrue(strongAttack.getCost().includesEnergies(strongCost) && strongCost.includesEnergies(strongAttack.getCost()));
    }

    @Test
    public void getName() {
        assertEquals("ElectricAttack", electricAttack.getName());
        assertEquals("FightingAttack", fightingAttack.getName());
        assertEquals("FireAttack", fireAttack.getName());
        assertEquals("GrassAttack", grassAttack.getName());
        assertEquals("PsychicAttack", psychicAttack.getName());
        assertEquals("WaterAttack", waterAttack.getName());
        assertEquals("StrongAttack", strongAttack.getName());
        assertEquals("TestAttack", testAttack.getName());
        assertEquals("Electric Shock", electricShock.getName());
    }

    @Test
    public void electricShockTest() {
        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        trainer1.addCard(electricPokemon);
        trainer1.selectHandCard(0);
        trainer1.playCard();

        trainer2.addCard(fightingPokemon);
        trainer2.selectHandCard(0);
        trainer2.playCard();

        assertEquals(100, trainer2.getActivePokemon().getHp());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectAbility(0);
        trainer1.useAbility();
        assertTrue(trainer1.getActivePokemon().getHp() == 100 || trainer1.getActivePokemon().getHp() == 90);
        assertEquals(90, trainer2.getActivePokemon().getHp());
    }

    @Test
    public void testSetAttack() {
        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        trainer1.addCard(electricPokemon);
        trainer1.selectHandCard(0);
        trainer1.playCard();

        trainer2.addCard(fightingPokemon);
        trainer2.selectHandCard(0);
        trainer2.playCard();

        assertEquals(100, trainer2.getActivePokemon().getHp());

        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals(90, trainer2.getActivePokemon().getHp());

        electricShock.setDamage(20);
        trainer1.addCard(new ElectricTypePokemonCard(100, new IAbility[] {electricShock}, trainer1));
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectBenchPokemon(1);
        trainer1.swapActivePokemon();
        trainer1.selectBenchPokemon(0);
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals(70, trainer2.getActivePokemon().getHp());
    }
}