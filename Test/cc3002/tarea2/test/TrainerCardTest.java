package cc3002.tarea2.test;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.Abilities.Attacks.ElectricAttack;
import cc3002.tarea2.game.Abilities.Attacks.FightingAttack;
import cc3002.tarea2.game.Abilities.Attacks.FireAttack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.PokemonCard;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.pokemons.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.pokemons.FireTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.pokemons.GrassTypePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainerCardTest {

    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;

    private Attack[] attacks;
    private Attack[] attacks2;
    private Attack[] attacks3;

    //TODO: tests for discarded cards.

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
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
        trainer1.swapActivePokemon(1);
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void setOpponent() throws Exception {
        trainer3.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer3.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getOpponent().getActivePokemon().getId());
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer3.getOpponent().getActivePokemon().getId());
    }

    @Test
    public void getActivePokemon() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    //TODO make tests for abilities too.
    @Test
    public void useAbility() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer2.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer2.playCard(0);

        assertEquals(50, trainer2.getActivePokemon().getHp());

        trainer1.useAbility(0);

        assertEquals(50, trainer2.getActivePokemon().getHp());

        trainer1.addEnergy(new ElectricEnergyCard());
        trainer1.addEnergy(new ElectricEnergyCard());

        trainer1.useAbility(0);

        assertEquals(40, trainer2.getActivePokemon().getHp());

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        trainer1.useAbility(0);
    }

    @Test
    public void getCardFromHand() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), ((PokemonCard) trainer1.getHand().get(0)).getId());
    }

    @Test
    public void getCardFromBench() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getBench().get(0).getId());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.playCard(0);
        assertEquals(0, trainer1.handSize());
    }

    @Test
    public void playCard() throws Exception {
        assertEquals(0, trainer1.benchSize());
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        assertEquals(0, trainer1.benchSize());
        trainer1.playCard(0);
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.addCard(new ElectricEnergyCard());
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
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(2, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(3, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(4, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(5, trainer1.handSize());
    }

    @Test
    public void benchNotFull() {
        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertTrue(trainer1.benchSize() <= 5);
    }

    @Test
    public void benchFull() {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(6, trainer1.benchSize());

        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);

        assertEquals(6, trainer1.benchSize());
    }

    @Test
    public void addEnergy() {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks,trainer1));
        trainer1.playCard(0);
        trainer1.addEnergy(new ElectricEnergyCard());

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getFireEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getGrassEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getPsychicEnergies());
        assertEquals(0, trainer1.getActivePokemon().getEnergySet().getWaterEnergies());
    }

    @Test
    public void maxNumAttacks() throws Exception {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard(0);
        assertEquals(1, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemonCard(50, attacks2, trainer1));
        trainer1.playCard(0);
        trainer1.swapActivePokemon(1);
        assertEquals(2, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemonCard(50, attacks3, trainer1));
        trainer1.playCard(0);
        trainer1.swapActivePokemon(2);
        assertEquals(3, trainer1.maxNumAttacks());
    }

    @Test
    public void deadPokemonRemoved() throws Exception {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks, trainer1));
        trainer2.addCard(new FireTypePokemonCard(50, attacks, trainer2));

        trainer1.playCard(0);
        trainer2.playCard(0);

        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.playCard(0);
        trainer1.playCard(0);

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        assertEquals(1, trainer2.benchSize());
        trainer1.useAbility(0);
        trainer1.useAbility(0);
        trainer1.useAbility(0);
        trainer1.useAbility(0);
        trainer1.useAbility(0);
        assertEquals(0, trainer2.benchSize());
    }
}