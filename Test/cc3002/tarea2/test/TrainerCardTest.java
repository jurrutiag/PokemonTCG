package cc3002.tarea2.test;

import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.ElectricAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.FightingAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.FireAttack;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.AbstractPokemonCard;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.FireTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.GrassTypePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainerCardTest {

    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;

    private IAttack[] attacks;
    private IAttack[] attacks2;
    private IAttack[] attacks3;

    //TODO: tests for discarded cards.

    @Before
    public void setUp() {
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        trainer3 = new Trainer();

        attacks = new IAttack[] {new ElectricAttack()};
        attacks2 = new IAttack[] {new ElectricAttack(), new FightingAttack()};
        attacks3 = new IAttack[] {new ElectricAttack(), new FightingAttack(), new FireAttack()};

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
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
        trainer1.swapActivePokemon(1);
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    @Test
    public void setOpponent() throws Exception {
        trainer3.addCard(new GrassTypePokemonCard(50, attacks, trainer3));
        trainer3.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getOpponent().getActivePokemon().getId());
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer3).getId(), trainer3.getOpponent().getActivePokemon().getId());
    }

    @Test
    public void getActivePokemon() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getActivePokemon().getId());
    }

    //TODO make tests for abilities too.
    @Test
    public void useAbility() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer2.addCard(new GrassTypePokemonCard(50, attacks, trainer2));
        trainer2.playCard();

        assertEquals(50, trainer2.getActivePokemon().getHp());

        trainer1.useAbility();

        assertEquals(50, trainer2.getActivePokemon().getHp());

        trainer1.addCard(new ElectricEnergyCard(trainer1));
        trainer1.addCard(new ElectricEnergyCard(trainer1));
        trainer1.selectBenchPokemon(0);
        trainer1.playCard();
        trainer1.playCard();

        trainer1.useAbility();

        assertEquals(40, trainer2.getActivePokemon().getHp());

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        trainer1.useAbility();
    }

    @Test
    public void getCardFromHand() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), ((AbstractPokemonCard) trainer1.getHand().get(0)).getId());
    }

    @Test
    public void getCardFromBench() throws Exception {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        assertEquals(new GrassTypePokemonCard(50, attacks, trainer1).getId(), trainer1.getBench().get(0).getId());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        assertEquals(0, trainer1.handSize());
    }

    @Test
    public void playCard() throws Exception {
        assertEquals(0, trainer1.benchSize());
        assertEquals(0, trainer1.handSize());
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        assertEquals(1, trainer1.handSize());
        assertEquals(0, trainer1.benchSize());
        trainer1.playCard();
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.addCard(new ElectricEnergyCard(trainer1));
        assertEquals(1, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.playCard();
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
        trainer1.playCard();

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertTrue(trainer1.benchSize() <= 5);
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertTrue(trainer1.benchSize() <= 5);
    }

    @Test
    public void benchFull() {
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertEquals(6, trainer1.benchSize());

        trainer1.addCard(new GrassTypePokemonCard(50, attacks, trainer1));
        trainer1.playCard();

        assertEquals(6, trainer1.benchSize());
    }

    @Test
    public void addEnergy() {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks,trainer1));
        trainer1.playCard();
        trainer1.addCard(new ElectricEnergyCard(trainer1));
        trainer1.selectBenchPokemon(0);
        trainer1.playCard();

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
        trainer1.playCard();
        assertEquals(1, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemonCard(50, attacks2, trainer1));
        trainer1.playCard();
        trainer1.swapActivePokemon(1);
        assertEquals(2, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemonCard(50, attacks3, trainer1));
        trainer1.playCard();
        trainer1.swapActivePokemon(2);
        assertEquals(3, trainer1.maxNumAttacks());
    }

    @Test
    public void deadPokemonRemoved() throws Exception {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks, trainer1));
        trainer2.addCard(new FireTypePokemonCard(50, attacks, trainer2));

        trainer1.playCard();
        trainer2.playCard();

        trainer1.addCard(new ElectricEnergyCard(trainer1));
        trainer1.addCard(new ElectricEnergyCard(trainer1));
        trainer1.playCard();
        trainer1.playCard();

        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);

        assertEquals(1, trainer2.benchSize());
        trainer1.useAbility();
        trainer1.useAbility();
        trainer1.useAbility();
        trainer1.useAbility();
        trainer1.useAbility();
        assertEquals(0, trainer2.benchSize());
    }
}