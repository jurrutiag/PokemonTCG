package cc3002.tarea1;

import cc3002.tarea1.Abilities.Attacks.ElectricAttack;
import cc3002.tarea1.Abilities.Attacks.FightingAttack;
import cc3002.tarea1.Abilities.Attacks.FireAttack;
import cc3002.tarea1.energies.ElectricEnergy;
import cc3002.tarea1.pokemons.ElectricTypePokemon;
import cc3002.tarea1.pokemons.GrassTypePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainerTest {

    Trainer trainer1;
    Trainer trainer2;
    Trainer trainer3;

    Attack[] attacks;
    Attack[] attacks2;
    Attack[] attacks3;

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
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
        trainer1.swapActivePokemon(1);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void swapNextNotDead() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.getActivePokemon().receiveDamage(trainer1.getActivePokemon().getHp());

        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());

        trainer1.swapNextNotDead();

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());

        trainer1.swapNextNotDead();

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void setOpponent() throws Exception {
        trainer3.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer3.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getOpponent().getActivePokemon().getId());
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer3.getOpponent().getActivePokemon().getId());
    }

    @Test
    public void getActivePokemon() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void activePokemonAttack() throws Exception {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addEnergy(new EnergySet(2, 0, 0, 0, 0, 0));
        trainer2.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer2.addPokemonToBench(0);

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
        trainer1.addPokemonToBench(0);
        assertEquals(new GrassTypePokemon(50, attacks, trainer1).getId(), trainer1.getCardFromBench(0).getId());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.addPokemonToBench(0);
        assertEquals(0, trainer1.handSize());
    }

    @Test
    public void addPokemonToBench() throws Exception {
        assertEquals(0, trainer1.benchSize());
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        assertEquals(0, trainer1.benchSize());
        trainer1.addPokemonToBench(0);
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
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
        trainer1.addPokemonToBench(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertTrue(trainer1.benchSize() <= 5);
    }

    @Test
    public void benchFull() {
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertEquals(6, trainer1.benchSize());

        trainer1.addCard(new GrassTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);

        assertEquals(6, trainer1.benchSize());
    }

    @Test
    public void addEnergy() {
        trainer1.addCard(new ElectricTypePokemon(50, attacks,trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.addEnergy(new ElectricEnergy());

        assertEquals(1, trainer1.getActivePokemon().getEnergies().getElectricEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergies().getFightingEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergies().getFireEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergies().getGrassEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergies().getPsychicEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergies().getWaterEnergies());
    }

    @Test
    public void maxNumAttacks() throws Exception {
        trainer1.addCard(new ElectricTypePokemon(50, attacks, trainer1));
        trainer1.addPokemonToBench(0);
        assertEquals(1, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemon(50, attacks2, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.swapActivePokemon(1);
        assertEquals(2, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemon(50, attacks3, trainer1));
        trainer1.addPokemonToBench(0);
        trainer1.swapActivePokemon(2);
        assertEquals(3, trainer1.maxNumAttacks());
    }
}