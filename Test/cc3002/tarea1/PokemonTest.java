package cc3002.tarea1;

import cc3002.tarea1.pokemons.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonTest {

    Trainer trainer1;
    Trainer trainer2;

    Attack[] attacks1;
    Attack[] attacks2;
    Attack[] attacks3;

    Pokemon electricPokemon;
    Pokemon fightingPokemon;
    Pokemon firePokemon;
    Pokemon grassPokemon;
    Pokemon psychicPokemon;
    Pokemon waterPokemon;

    Pokemon electricPokemon2;
    Pokemon fightingPokemon2;
    Pokemon firePokemon2;
    Pokemon grassPokemon2;
    Pokemon psychicPokemon2;
    Pokemon waterPokemon2;


    @Before
    public void setUp() {
        attacks1 = new Attack[] {new ScratchAttack()};
        attacks2 = new Attack[] {new ScratchAttack(), new ScratchAttack()};
        attacks3 = new Attack[] {new ScratchAttack(), new ScratchAttack(), new ScratchAttack()};

        trainer1 = new Trainer();
        trainer2 = new Trainer();

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        electricPokemon = new ElectricTypePokemon(50, attacks1, trainer1);
        fightingPokemon = new FightingTypePokemon(50, attacks1, trainer1);
        firePokemon = new FireTypePokemon(50, attacks1, trainer1);
        grassPokemon = new GrassTypePokemon(50, attacks1, trainer1);
        psychicPokemon = new PsychicPokemon(50, attacks1, trainer1);
        waterPokemon = new WaterTypePokemon(50, attacks1, trainer1);

        electricPokemon2 = new ElectricTypePokemon(50, attacks1, trainer2);
        fightingPokemon2 = new FightingTypePokemon(50, attacks1, trainer2);
        firePokemon2 = new FireTypePokemon(50, attacks1, trainer2);
        grassPokemon2 = new GrassTypePokemon(50, attacks1, trainer2);
        psychicPokemon2 = new PsychicPokemon(50, attacks1, trainer2);
        waterPokemon2 = new WaterTypePokemon(50, attacks1, trainer2);
    }

    @Test
    public void getHp() throws Exception {
        assertEquals(50, electricPokemon.getHp());
        electricPokemon.setHp(100);
        assertEquals(100, electricPokemon.getHp());

        assertEquals(50, fightingPokemon.getHp());
        fightingPokemon.setHp(100);
        assertEquals(100, fightingPokemon.getHp());

        assertEquals(50, firePokemon.getHp());
        firePokemon.setHp(100);
        assertEquals(100, firePokemon.getHp());

        assertEquals(50, grassPokemon.getHp());
        grassPokemon.setHp(100);
        assertEquals(100, grassPokemon.getHp());

        assertEquals(50, psychicPokemon.getHp());
        psychicPokemon.setHp(100);
        assertEquals(100, psychicPokemon.getHp());

        assertEquals(50, waterPokemon.getHp());
        waterPokemon.setHp(100);
        assertEquals(100, waterPokemon.getHp());
    }

    @Test
    public void getAttacksAmount() throws Exception {
        assertEquals(1, electricPokemon.getAttacksAmount());
        assertEquals(1, fightingPokemon.getAttacksAmount());
        assertEquals(1, firePokemon.getAttacksAmount());
        assertEquals(1, grassPokemon.getAttacksAmount());
        assertEquals(1, psychicPokemon.getAttacksAmount());
        assertEquals(1, waterPokemon.getAttacksAmount());

        electricPokemon = new ElectricTypePokemon(50, attacks2, trainer1);
        fightingPokemon = new FightingTypePokemon(50, attacks2, trainer1);
        firePokemon = new FireTypePokemon(50, attacks2, trainer1);
        grassPokemon = new GrassTypePokemon(50, attacks2, trainer1);
        psychicPokemon = new PsychicPokemon(50, attacks2, trainer1);
        waterPokemon = new WaterTypePokemon(50, attacks2, trainer1);

        assertEquals(2, electricPokemon.getAttacksAmount());
        assertEquals(2, fightingPokemon.getAttacksAmount());
        assertEquals(2, firePokemon.getAttacksAmount());
        assertEquals(2, grassPokemon.getAttacksAmount());
        assertEquals(2, psychicPokemon.getAttacksAmount());
        assertEquals(2, waterPokemon.getAttacksAmount());

        electricPokemon = new ElectricTypePokemon(50, attacks3, trainer1);
        fightingPokemon = new FightingTypePokemon(50, attacks3, trainer1);
        firePokemon = new FireTypePokemon(50, attacks3, trainer1);
        grassPokemon = new GrassTypePokemon(50, attacks3, trainer1);
        psychicPokemon = new PsychicPokemon(50, attacks3, trainer1);
        waterPokemon = new WaterTypePokemon(50, attacks3, trainer1);

        assertEquals(3, electricPokemon.getAttacksAmount());
        assertEquals(3, fightingPokemon.getAttacksAmount());
        assertEquals(3, firePokemon.getAttacksAmount());
        assertEquals(3, grassPokemon.getAttacksAmount());
        assertEquals(3, psychicPokemon.getAttacksAmount());
        assertEquals(3, waterPokemon.getAttacksAmount());
    }

    @Test
    public void receiveDamage() throws Exception {
        electricPokemon.receiveDamage(10);
        assertEquals(40, electricPokemon.getHp());
        electricPokemon.receiveDamage(40);
        assertEquals(0, electricPokemon.getHp());
        electricPokemon.receiveDamage(100);
        assertEquals(0, electricPokemon.getHp());
        electricPokemon.setHp(100);
        assertEquals(100, electricPokemon.getHp());

        fightingPokemon.receiveDamage(10);
        assertEquals(40, fightingPokemon.getHp());
        fightingPokemon.receiveDamage(40);
        assertEquals(0, fightingPokemon.getHp());
        fightingPokemon.receiveDamage(100);
        assertEquals(0, fightingPokemon.getHp());
        fightingPokemon.setHp(100);
        assertEquals(100, fightingPokemon.getHp());

        firePokemon.receiveDamage(10);
        assertEquals(40, firePokemon.getHp());
        firePokemon.receiveDamage(40);
        assertEquals(0, firePokemon.getHp());
        firePokemon.receiveDamage(100);
        assertEquals(0, firePokemon.getHp());
        firePokemon.setHp(100);
        assertEquals(100, firePokemon.getHp());

        grassPokemon.receiveDamage(10);
        assertEquals(40, grassPokemon.getHp());
        grassPokemon.receiveDamage(40);
        assertEquals(0, grassPokemon.getHp());
        grassPokemon.receiveDamage(100);
        assertEquals(0, grassPokemon.getHp());
        grassPokemon.setHp(100);
        assertEquals(100, grassPokemon.getHp());

        psychicPokemon.receiveDamage(10);
        assertEquals(40, psychicPokemon.getHp());
        psychicPokemon.receiveDamage(40);
        assertEquals(0, psychicPokemon.getHp());
        psychicPokemon.receiveDamage(100);
        assertEquals(0, psychicPokemon.getHp());
        psychicPokemon.setHp(100);
        assertEquals(100, psychicPokemon.getHp());

        waterPokemon.receiveDamage(10);
        assertEquals(40, waterPokemon.getHp());
        waterPokemon.receiveDamage(40);
        assertEquals(0, waterPokemon.getHp());
        waterPokemon.receiveDamage(100);
        assertEquals(0, waterPokemon.getHp());
        waterPokemon.setHp(100);
        assertEquals(100, waterPokemon.getHp());

    }

    @Test
    public void attack() throws Exception {
        electricPokemon2.setHp(10);
        fightingPokemon2.setHp(10);
        firePokemon2.setHp(10);
        grassPokemon2.setHp(10);
        psychicPokemon2.setHp(20);
        waterPokemon2.setHp(10);

        trainer2.addCard(electricPokemon2);
        trainer2.addPokemonToBench(0);
        electricPokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());

        trainer2.addCard(fightingPokemon2);
        trainer2.addPokemonToBench(0);
        fightingPokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());

        trainer2.addCard(firePokemon2);
        trainer2.addPokemonToBench(0);
        firePokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());

        trainer2.addCard(grassPokemon2);
        trainer2.addPokemonToBench(0);
        grassPokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());

        trainer2.addCard(psychicPokemon2);
        trainer2.addPokemonToBench(0);
        psychicPokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());

        trainer2.addCard(waterPokemon2);
        trainer2.addPokemonToBench(0);
        waterPokemon.attack(1, trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHp());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, electricPokemon.getId());
        assertEquals(2, fightingPokemon.getId());
        assertEquals(3, firePokemon.getId());
        assertEquals(4, grassPokemon.getId());
        assertEquals(5, psychicPokemon.getId());
        assertEquals(6, waterPokemon.getId());
    }

    @Test
    public void receiveGrassAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receiveGrassAttack(40);
        assertEquals(60, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receiveGrassAttack(40);
        assertEquals(20, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receiveGrassAttack(40);
        assertEquals(60, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receiveGrassAttack(40);
        assertEquals(60, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receiveGrassAttack(40);
        assertEquals(60, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receiveGrassAttack(40);
        assertEquals(20, waterPokemon.getHp());

    }

    @Test
    public void receiveFireAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receiveFireAttack(40);
        assertEquals(60, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receiveFireAttack(40);
        assertEquals(60, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receiveFireAttack(40);
        assertEquals(60, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receiveFireAttack(40);
        assertEquals(20, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receiveFireAttack(40);
        assertEquals(60, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receiveFireAttack(40);
        assertEquals(60, waterPokemon.getHp());
    }

    @Test
    public void receiveWaterAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receiveWaterAttack(40);
        assertEquals(60, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receiveWaterAttack(40);
        assertEquals(60, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receiveWaterAttack(40);
        assertEquals(20, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receiveWaterAttack(40);
        assertEquals(90, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receiveWaterAttack(40);
        assertEquals(60, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receiveWaterAttack(40);
        assertEquals(60, waterPokemon.getHp());
    }

    @Test
    public void receiveElectricAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receiveElectricAttack(40);
        assertEquals(60, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receiveElectricAttack(40);
        assertEquals(60, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receiveElectricAttack(40);
        assertEquals(60, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receiveElectricAttack(40);
        assertEquals(60, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receiveElectricAttack(40);
        assertEquals(60, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receiveElectricAttack(40);
        assertEquals(20, waterPokemon.getHp());
    }

    @Test
    public void receiveFightingAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receiveFightingAttack(40);
        assertEquals(20, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receiveFightingAttack(40);
        assertEquals(60, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receiveFightingAttack(40);
        assertEquals(60, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receiveFightingAttack(40);
        assertEquals(60, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receiveFightingAttack(40);
        assertEquals(90, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receiveFightingAttack(40);
        assertEquals(90, waterPokemon.getHp());
    }

    @Test
    public void receivePsychicAttack() throws Exception {
        electricPokemon.setHp(100);
        electricPokemon.receivePsychicAttack(40);
        assertEquals(60, electricPokemon.getHp());

        fightingPokemon.setHp(100);
        fightingPokemon.receivePsychicAttack(40);
        assertEquals(20, fightingPokemon.getHp());

        firePokemon.setHp(100);
        firePokemon.receivePsychicAttack(40);
        assertEquals(60, firePokemon.getHp());

        grassPokemon.setHp(100);
        grassPokemon.receivePsychicAttack(40);
        assertEquals(60, grassPokemon.getHp());

        psychicPokemon.setHp(100);
        psychicPokemon.receivePsychicAttack(40);
        assertEquals(20, psychicPokemon.getHp());

        waterPokemon.setHp(100);
        waterPokemon.receivePsychicAttack(40);
        assertEquals(60, waterPokemon.getHp());
    }

    @Test
    public void getAttackDamage() throws Exception {
        assertEquals(10, electricPokemon.getAttackDamage(1));
        assertEquals(10, fightingPokemon.getAttackDamage(1));
        assertEquals(10, firePokemon.getAttackDamage(1));
        assertEquals(10, grassPokemon.getAttackDamage(1));
        assertEquals(10, psychicPokemon.getAttackDamage(1));
        assertEquals(10, waterPokemon.getAttackDamage(1));
    }

    @Test
    public void dead() throws Exception {
        grassPokemon.setHp(1);

        trainer1.addCard(grassPokemon);
        trainer1.addPokemonToBench(0);
        trainer1.addCard(firePokemon);
        trainer1.addPokemonToBench(0);

        assertEquals(grassPokemon.getId(), trainer1.getActivePokemon().getId());

        trainer1.getActivePokemon().receiveDamage(1);

        assertEquals(firePokemon.getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void getTrainer() throws Exception {
        assertEquals(trainer1, electricPokemon.getTrainer());
        assertEquals(trainer1, fightingPokemon.getTrainer());
        assertEquals(trainer1, firePokemon.getTrainer());
        assertEquals(trainer1, grassPokemon.getTrainer());
        assertEquals(trainer1, psychicPokemon.getTrainer());
        assertEquals(trainer1, waterPokemon.getTrainer());

        assertEquals(trainer2, electricPokemon2.getTrainer());
        assertEquals(trainer2, fightingPokemon2.getTrainer());
        assertEquals(trainer2, firePokemon2.getTrainer());
        assertEquals(trainer2, grassPokemon2.getTrainer());
        assertEquals(trainer2, psychicPokemon2.getTrainer());
        assertEquals(trainer2, waterPokemon2.getTrainer());
    }

}