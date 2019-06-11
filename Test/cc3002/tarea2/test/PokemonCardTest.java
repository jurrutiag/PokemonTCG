package cc3002.tarea2.test;

import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.*;
import cc3002.tarea2.game.cards.energies.AbstractEnergyCard;
import cc3002.tarea2.game.cards.pokemon.AbstractPokemonCard;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCardTest {

    private Trainer trainer1;
    private Trainer trainer2;

    private IAttack[] attacks2;
    private IAttack[] attacks3;

    private AbstractEnergyCard electricEnergyCard;
    private AbstractEnergyCard fightingEnergyCard;
    private AbstractEnergyCard fireEnergyCard;
    private AbstractEnergyCard grassEnergyCard;
    private AbstractEnergyCard psychicEnergyCard;
    private AbstractEnergyCard waterEnergyCard;

    private AbstractPokemonCard electricPokemonCard;
    private AbstractPokemonCard fightingPokemonCard;
    private AbstractPokemonCard firePokemonCard;
    private AbstractPokemonCard grassPokemonCard;
    private AbstractPokemonCard psychicPokemonCard;
    private AbstractPokemonCard waterPokemonCard;

    private AbstractPokemonCard electricPokemonCard2;
    private AbstractPokemonCard fightingPokemonCard2;
    private AbstractPokemonCard firePokemonCard2;
    private AbstractPokemonCard grassPokemonCard2;
    private AbstractPokemonCard psychicPokemonCard2;
    private AbstractPokemonCard waterPokemonCard2;


    @Before
    public void setUp() {
        IAttack[] electricAttacks = new IAttack[]{new ElectricAttack()};
        IAttack[] fightingAttacks = new IAttack[]{new FightingAttack()};
        IAttack[] fireAttacks = new IAttack[]{new FireAttack()};
        IAttack[] grassAttacks = new IAttack[]{new GrassAttack()};
        IAttack[] psychicAttacks = new IAttack[]{new PsychicAttack()};
        IAttack[] waterAttacks = new IAttack[]{new WaterAttack()};

        attacks2 = new IAttack[] {new ElectricAttack(), new FightingAttack()};
        attacks3 = new IAttack[] {new ElectricAttack(), new FightingAttack(), new FireAttack()};

        electricEnergyCard = new ElectricEnergyCard(trainer1);
        fightingEnergyCard = new FightingEnergyCard(trainer1);
        fireEnergyCard = new FireEnergyCard(trainer1);
        grassEnergyCard = new GrassEnergyCard(trainer1);
        psychicEnergyCard = new PsychicEnergyCard(trainer1);
        waterEnergyCard = new WaterEnergyCard(trainer1);

        trainer1 = new Trainer();
        trainer2 = new Trainer();

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        electricPokemonCard = new ElectricTypePokemonCard(50, electricAttacks, trainer1);
        fightingPokemonCard = new FightingTypePokemonCard(50, fightingAttacks, trainer1);
        firePokemonCard = new FireTypePokemonCard(50, fireAttacks, trainer1);
        grassPokemonCard = new GrassTypePokemonCard(50, grassAttacks, trainer1);
        psychicPokemonCard = new PsychicTypePokemonCard(50, psychicAttacks, trainer1);
        waterPokemonCard = new WaterTypePokemonCard(50, waterAttacks, trainer1);

        electricPokemonCard2 = new ElectricTypePokemonCard(50, electricAttacks, trainer2);
        fightingPokemonCard2 = new FightingTypePokemonCard(50, fightingAttacks, trainer2);
        firePokemonCard2 = new FireTypePokemonCard(50, fireAttacks, trainer2);
        grassPokemonCard2 = new GrassTypePokemonCard(50, grassAttacks, trainer2);
        psychicPokemonCard2 = new PsychicTypePokemonCard(50, psychicAttacks, trainer2);
        waterPokemonCard2 = new WaterTypePokemonCard(50, waterAttacks, trainer2);
    }

    @Test
    public void getHp() throws Exception {
        assertEquals(50, electricPokemonCard.getHp());
        electricPokemonCard.setHp(100);
        assertEquals(100, electricPokemonCard.getHp());

        assertEquals(50, fightingPokemonCard.getHp());
        fightingPokemonCard.setHp(100);
        assertEquals(100, fightingPokemonCard.getHp());

        assertEquals(50, firePokemonCard.getHp());
        firePokemonCard.setHp(100);
        assertEquals(100, firePokemonCard.getHp());

        assertEquals(50, grassPokemonCard.getHp());
        grassPokemonCard.setHp(100);
        assertEquals(100, grassPokemonCard.getHp());

        assertEquals(50, psychicPokemonCard.getHp());
        psychicPokemonCard.setHp(100);
        assertEquals(100, psychicPokemonCard.getHp());

        assertEquals(50, waterPokemonCard.getHp());
        waterPokemonCard.setHp(100);
        assertEquals(100, waterPokemonCard.getHp());
    }

    @Test
    public void getAttacksAmount() throws Exception {
        assertEquals(1, electricPokemonCard.getAbilitiesAmount());
        assertEquals(1, fightingPokemonCard.getAbilitiesAmount());
        assertEquals(1, firePokemonCard.getAbilitiesAmount());
        assertEquals(1, grassPokemonCard.getAbilitiesAmount());
        assertEquals(1, psychicPokemonCard.getAbilitiesAmount());
        assertEquals(1, waterPokemonCard.getAbilitiesAmount());

        electricPokemonCard = new ElectricTypePokemonCard(50, attacks2, trainer1);
        fightingPokemonCard = new FightingTypePokemonCard(50, attacks2, trainer1);
        firePokemonCard = new FireTypePokemonCard(50, attacks2, trainer1);
        grassPokemonCard = new GrassTypePokemonCard(50, attacks2, trainer1);
        psychicPokemonCard = new PsychicTypePokemonCard(50, attacks2, trainer1);
        waterPokemonCard = new WaterTypePokemonCard(50, attacks2, trainer1);

        assertEquals(2, electricPokemonCard.getAbilitiesAmount());
        assertEquals(2, fightingPokemonCard.getAbilitiesAmount());
        assertEquals(2, firePokemonCard.getAbilitiesAmount());
        assertEquals(2, grassPokemonCard.getAbilitiesAmount());
        assertEquals(2, psychicPokemonCard.getAbilitiesAmount());
        assertEquals(2, waterPokemonCard.getAbilitiesAmount());

        electricPokemonCard = new ElectricTypePokemonCard(50, attacks3, trainer1);
        fightingPokemonCard = new FightingTypePokemonCard(50, attacks3, trainer1);
        firePokemonCard = new FireTypePokemonCard(50, attacks3, trainer1);
        grassPokemonCard = new GrassTypePokemonCard(50, attacks3, trainer1);
        psychicPokemonCard = new PsychicTypePokemonCard(50, attacks3, trainer1);
        waterPokemonCard = new WaterTypePokemonCard(50, attacks3, trainer1);

        assertEquals(3, electricPokemonCard.getAbilitiesAmount());
        assertEquals(3, fightingPokemonCard.getAbilitiesAmount());
        assertEquals(3, firePokemonCard.getAbilitiesAmount());
        assertEquals(3, grassPokemonCard.getAbilitiesAmount());
        assertEquals(3, psychicPokemonCard.getAbilitiesAmount());
        assertEquals(3, waterPokemonCard.getAbilitiesAmount());
    }

    @Test
    public void receiveDamage() throws Exception {
        electricPokemonCard.receiveDamage(10);
        assertEquals(40, electricPokemonCard.getHp());
        electricPokemonCard.receiveDamage(30);
        assertEquals(10, electricPokemonCard.getHp());
        electricPokemonCard.setHp(100);
        assertEquals(100, electricPokemonCard.getHp());

        fightingPokemonCard.receiveDamage(10);
        assertEquals(40, fightingPokemonCard.getHp());
        fightingPokemonCard.receiveDamage(30);
        assertEquals(10, fightingPokemonCard.getHp());
        fightingPokemonCard.setHp(100);
        assertEquals(100, fightingPokemonCard.getHp());

        firePokemonCard.receiveDamage(10);
        assertEquals(40, firePokemonCard.getHp());
        firePokemonCard.receiveDamage(30);
        assertEquals(10, firePokemonCard.getHp());
        firePokemonCard.setHp(100);
        assertEquals(100, firePokemonCard.getHp());

        grassPokemonCard.receiveDamage(10);
        assertEquals(40, grassPokemonCard.getHp());
        grassPokemonCard.receiveDamage(30);
        assertEquals(10, grassPokemonCard.getHp());
        grassPokemonCard.setHp(100);
        assertEquals(100, grassPokemonCard.getHp());

        psychicPokemonCard.receiveDamage(10);
        assertEquals(40, psychicPokemonCard.getHp());
        psychicPokemonCard.receiveDamage(30);
        assertEquals(10, psychicPokemonCard.getHp());
        psychicPokemonCard.setHp(100);
        assertEquals(100, psychicPokemonCard.getHp());

        waterPokemonCard.receiveDamage(10);
        assertEquals(40, waterPokemonCard.getHp());
        waterPokemonCard.receiveDamage(30);
        assertEquals(10, waterPokemonCard.getHp());
        waterPokemonCard.setHp(100);
        assertEquals(100, waterPokemonCard.getHp());

    }

    @Test
    public void attack() throws Exception {
        electricPokemonCard2.setHp(40);
        fightingPokemonCard2.setHp(40);
        firePokemonCard2.setHp(40);
        grassPokemonCard2.setHp(40);
        psychicPokemonCard2.setHp(40);
        waterPokemonCard2.setHp(40);

        trainer2.addCard(electricPokemonCard2);
        trainer2.playCard();
        electricPokemonCard.addElectricEnergy();
        electricPokemonCard.addElectricEnergy();
        electricPokemonCard.useAbility(0);
        assertEquals(new ElectricTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(30, trainer2.getActivePokemon().getHp());
        electricPokemonCard.useAbility(0);
        electricPokemonCard.useAbility(0);
        electricPokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());

        trainer2.addCard(fightingPokemonCard2);
        trainer2.playCard();
        fightingPokemonCard.addFightingEnergy();
        fightingPokemonCard.addFightingEnergy();
        fightingPokemonCard.useAbility(0);
        assertEquals(new FightingTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(30, trainer2.getActivePokemon().getHp());
        fightingPokemonCard.useAbility(0);
        fightingPokemonCard.useAbility(0);
        fightingPokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());

        trainer2.addCard(firePokemonCard2);
        trainer2.playCard();
        firePokemonCard.addFireEnergy();
        firePokemonCard.addFireEnergy();
        firePokemonCard.useAbility(0);
        assertEquals(new FireTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(30, trainer2.getActivePokemon().getHp());
        firePokemonCard.useAbility(0);
        firePokemonCard.useAbility(0);
        firePokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());

        trainer2.addCard(grassPokemonCard2);
        trainer2.playCard();
        grassPokemonCard.addGrassEnergy();
        grassPokemonCard.addGrassEnergy();
        grassPokemonCard.useAbility(0);
        assertEquals(new GrassTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(30, trainer2.getActivePokemon().getHp());
        grassPokemonCard.useAbility(0);
        grassPokemonCard.useAbility(0);
        grassPokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());

        trainer2.addCard(psychicPokemonCard2);
        trainer2.playCard();
        psychicPokemonCard.addPsychicEnergy();
        psychicPokemonCard.addPsychicEnergy();
        psychicPokemonCard.useAbility(0);
        assertEquals(new PsychicTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(20, trainer2.getActivePokemon().getHp());
        psychicPokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());

        trainer2.addCard(waterPokemonCard2);
        trainer2.playCard();
        waterPokemonCard.addWaterEnergy();
        waterPokemonCard.addWaterEnergy();
        waterPokemonCard.useAbility(0);
        assertEquals(new WaterTypePokemonCard(trainer2).getName(), trainer2.getActivePokemon().getName());
        assertEquals(30, trainer2.getActivePokemon().getHp());
        waterPokemonCard.useAbility(0);
        waterPokemonCard.useAbility(0);
        waterPokemonCard.useAbility(0);
        assertEquals(0, trainer2.benchSize());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, electricPokemonCard.getId());
        assertEquals(2, fightingPokemonCard.getId());
        assertEquals(3, firePokemonCard.getId());
        assertEquals(4, grassPokemonCard.getId());
        assertEquals(5, psychicPokemonCard.getId());
        assertEquals(6, waterPokemonCard.getId());
    }

    @Test
    public void receiveGrassAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(60, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(20, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(60, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(60, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(60, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receiveGrassAttack(new TestAttack());
        assertEquals(20, waterPokemonCard.getHp());

    }

    @Test
    public void receiveFireAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(60, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(60, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(60, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(20, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(60, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receiveFireAttack(new TestAttack());
        assertEquals(60, waterPokemonCard.getHp());
    }

    @Test
    public void receiveWaterAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(60, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(60, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(20, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(90, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(60, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receiveWaterAttack(new TestAttack());
        assertEquals(60, waterPokemonCard.getHp());
    }

    @Test
    public void receiveElectricAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(60, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(60, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(60, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(60, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(60, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receiveElectricAttack(new TestAttack());
        assertEquals(20, waterPokemonCard.getHp());
    }

    @Test
    public void receiveFightingAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(20, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(60, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(60, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(60, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(90, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receiveFightingAttack(new TestAttack());
        assertEquals(90, waterPokemonCard.getHp());
    }

    @Test
    public void receivePsychicAttack() throws Exception {
        electricPokemonCard.setHp(100);
        electricPokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(60, electricPokemonCard.getHp());

        fightingPokemonCard.setHp(100);
        fightingPokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(20, fightingPokemonCard.getHp());

        firePokemonCard.setHp(100);
        firePokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(60, firePokemonCard.getHp());

        grassPokemonCard.setHp(100);
        grassPokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(60, grassPokemonCard.getHp());

        psychicPokemonCard.setHp(100);
        psychicPokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(20, psychicPokemonCard.getHp());

        waterPokemonCard.setHp(100);
        waterPokemonCard.receivePsychicAttack(new TestAttack());
        assertEquals(60, waterPokemonCard.getHp());
    }

    @Test
    public void getAttackDamage() throws Exception {
        assertEquals(10, electricPokemonCard.getAttackDamage(1));
        assertEquals(10, fightingPokemonCard.getAttackDamage(1));
        assertEquals(10, firePokemonCard.getAttackDamage(1));
        assertEquals(10, grassPokemonCard.getAttackDamage(1));
        assertEquals(10, psychicPokemonCard.getAttackDamage(1));
        assertEquals(10, waterPokemonCard.getAttackDamage(1));
    }

    @Test
    public void dead() throws Exception {
        grassPokemonCard.setHp(1);

        trainer1.addCard(grassPokemonCard);
        trainer1.playCard();
        trainer1.addCard(firePokemonCard);
        trainer1.playCard();

        assertEquals(grassPokemonCard.getId(), trainer1.getActivePokemon().getId());

        trainer1.getActivePokemon().receiveDamage(1);

        assertEquals(firePokemonCard.getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void getTrainer() throws Exception {
        assertEquals(trainer1, electricPokemonCard.getTrainer());
        assertEquals(trainer1, fightingPokemonCard.getTrainer());
        assertEquals(trainer1, firePokemonCard.getTrainer());
        assertEquals(trainer1, grassPokemonCard.getTrainer());
        assertEquals(trainer1, psychicPokemonCard.getTrainer());
        assertEquals(trainer1, waterPokemonCard.getTrainer());

        assertEquals(trainer2, electricPokemonCard2.getTrainer());
        assertEquals(trainer2, fightingPokemonCard2.getTrainer());
        assertEquals(trainer2, firePokemonCard2.getTrainer());
        assertEquals(trainer2, grassPokemonCard2.getTrainer());
        assertEquals(trainer2, psychicPokemonCard2.getTrainer());
        assertEquals(trainer2, waterPokemonCard2.getTrainer());
    }

    @Test
    public void bindEnergy() {
        assertEquals(0, electricPokemonCard.getEnergySet().getElectricEnergies());
        assertEquals(0, electricPokemonCard.getEnergySet().getFightingEnergies());
        assertEquals(0, electricPokemonCard.getEnergySet().getFireEnergies());
        assertEquals(0, electricPokemonCard.getEnergySet().getGrassEnergies());
        assertEquals(0, electricPokemonCard.getEnergySet().getPsychicEnergies());
        assertEquals(0, electricPokemonCard.getEnergySet().getWaterEnergies());

        electricPokemonCard.addElectricEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getElectricEnergies());
        electricPokemonCard.addFightingEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getFightingEnergies());
        electricPokemonCard.addFireEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getFireEnergies());
        electricPokemonCard.addGrassEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getGrassEnergies());
        electricPokemonCard.addPsychicEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getPsychicEnergies());
        electricPokemonCard.addWaterEnergy();
        assertEquals(1, electricPokemonCard.getEnergySet().getWaterEnergies());

    }

    @Test
    public void getName() {
        assertEquals("ElectricTypePokemonCard", electricPokemonCard.getName());
        assertEquals("FightingTypePokemonCard", fightingPokemonCard.getName());
        assertEquals("FireTypePokemonCard", firePokemonCard.getName());
        assertEquals("GrassTypePokemonCard", grassPokemonCard.getName());
        assertEquals("PsychicTypePokemonCard", psychicPokemonCard.getName());
        assertEquals("WaterTypePokemonCard", waterPokemonCard.getName());
    }

}