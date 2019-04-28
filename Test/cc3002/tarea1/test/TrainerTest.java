package cc3002.tarea1.test;

import cc3002.tarea1.game.Abilities.Attacks.ElectricAttack;
import cc3002.tarea1.game.Abilities.Attacks.FightingAttack;
import cc3002.tarea1.game.Abilities.Attacks.FireAttack;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.EnergySet;
import cc3002.tarea1.game.Pokemon;
import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.energies.*;
import cc3002.tarea1.game.pokemons.ElectricTypePokemon;
import cc3002.tarea1.game.pokemons.FireTypePokemon;
import cc3002.tarea1.game.pokemons.GrassTypePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainerTest {

    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;

    private Attack[] attacks;
    private Attack[] attacks2;
    private Attack[] attacks3;

    @Before
    public void setUp() {
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        trainer3 = new Trainer();

        attacks = new Attack[] {new ElectricAttack()};
        attacks2 = new Attack[] {new ElectricAttack(), new FightingAttack()};
        attacks3 = new Attack[] {new ElectricAttack(), new FightingAttack(), new FireAttack()};

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);
    }

    @Test
    public void getOpponent() throws Exception {
        assertEquals(trainer2, trainer1.getOpponent());
        assertEquals(trainer1, trainer2.getOpponent());
    }

    @Test
    public void swapActivePokemon() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
        trainer1.swapActivePokemon(1);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void swapNextNotDead() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.getActivePokemon().receiveDamage(trainer1.getActivePokemon().getHp());

        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());

        trainer1.swapNextNotDead();

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());

        trainer1.swapNextNotDead();

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void setOpponent() throws Exception {
        trainer3.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer3.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getOpponent().getActivePokemon().getId());
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer3.getOpponent().getActivePokemon().getId());
    }

    @Test
    public void getActivePokemon() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void activePokemonAttack() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addEnergy(new EnergySet(2, 0, 0, 0, 0, 0));
        trainer2.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer2.playCard(0);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getHp(), trainer2.getActivePokemon().getHp());

        trainer1.activePokemonAttack(1);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getHp() - trainer1.getActivePokemon().getAttackDamage(1), trainer2.getActivePokemon().getHp());
    }

    @Test
    public void getCardFromHand() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), ((Pokemon) trainer1.getCardFromHand(0)).getId());
    }

    @Test
    public void getCardFromBench() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getCardFromBench(0).getId());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.playCard(0);
        assertEquals(0, trainer1.handSize());
    }

    @Test
    public void playCard() throws Exception {
        assertEquals(0, trainer1.benchSize());
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        assertEquals(0, trainer1.benchSize());
        trainer1.playCard(0);
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.addCard(new ElectricEnergy());
        assertEquals(1, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.playCard(0);
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().energySetSize());
    }

    @Test
    public void handSize() {
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(2, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(3, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(4, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(5, trainer1.handSize());
    }

    @Test
    public void benchNotFull() {
        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
    }

    @Test
    public void benchFull() {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(6, trainer1.benchSize());

        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(6, trainer1.benchSize());
    }

    @Test
    public void addEnergy() {
        trainer1.addCard(new ElectricTypePokemon(50, attacks,trainer1));
        trainer1.playCard(0);
        trainer1.addEnergy(new ElectricEnergy());

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getEnergies(new ElectricEnergy()));
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getEnergies(new FightingEnergy()));
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getEnergies(new FireEnergy()));
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getEnergies(new GrassEnergy()));
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getEnergies(new PsychicEnergy()));
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getEnergies(new WaterEnergy()));
    }

    @Test
    public void maxNumAttacks() throws Exception {
        trainer1.addCard(new ElectricTypePokemon(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(1, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemon(50, attacks2, trainer1));
        trainer1.playCard(0);
        trainer1.swapActivePokemon(1);
        assertEquals(2, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemon(50, attacks3, trainer1));
        trainer1.playCard(0);
        trainer1.swapActivePokemon(2);
        assertEquals(3, trainer1.maxNumAttacks());
    }

    @Test
    public void deadPokemonRemoved() throws Exception {
        trainer1.addCard(new ElectricTypePokemon(50, attacks, trainer1));
        trainer2.addCard(new FireTypePokemon(50, attacks, trainer2));

        trainer1.playCard(0);
        trainer2.playCard(0);

        trainer1.addCard(new ElectricEnergy());
        trainer1.addCard(new ElectricEnergy());
        trainer1.playCard(0);
        trainer1.playCard(0);

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        assertEquals(1, trainer2.benchSize());
        trainer1.activePokemonAttack(1);
        trainer1.activePokemonAttack(1);
        trainer1.activePokemonAttack(1);
        trainer1.activePokemonAttack(1);
        trainer1.activePokemonAttack(1);
        assertEquals(0, trainer2.benchSize());
    }
}