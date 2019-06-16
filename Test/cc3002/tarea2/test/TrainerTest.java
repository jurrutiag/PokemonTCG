package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.ElectricAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.FightingAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.FireAttack;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.StrongAttack;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.AbstractPokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FireTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.GrassTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1.ElectricPhase1PokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2.ElectricPhase2PokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainerTest {

    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;

    private IAttack[] attacks;
    private IAttack[] attacks2;
    private IAttack[] attacks3;

    private IEnergyCard electricEnergyCard;
    private IEnergyCard fightingEnergyCard;
    private IEnergyCard fireEnergyCard;
    private IEnergyCard grassEnergyCard;
    private IEnergyCard psychicEnergyCard;
    private IEnergyCard waterEnergyCard;

    private ICard electricPokemon;

    //TODO: tests for discarded cards.

    @Before
    public void setUp() {
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        trainer3 = new Trainer();

        attacks = new IAttack[] {new ElectricAttack()};
        attacks2 = new IAttack[] {new ElectricAttack(), new FightingAttack(), new StrongAttack()};
        attacks3 = new IAttack[] {new ElectricAttack(), new FightingAttack(), new FireAttack()};

        electricEnergyCard = new ElectricEnergyCard();
        fightingEnergyCard = new FightingEnergyCard();
        fireEnergyCard = new FireEnergyCard();
        grassEnergyCard = new GrassEnergyCard();
        psychicEnergyCard = new PsychicEnergyCard();
        waterEnergyCard = new WaterEnergyCard();


        electricPokemon = new ElectricTypePokemonCard(trainer1);

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
        trainer1.swapActivePokemon();
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

        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals(50, trainer2.getActivePokemon().getHp());

        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
        trainer1.selectBenchPokemon(0);
        trainer1.playCard();
        trainer1.playCard();

        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals(40, trainer2.getActivePokemon().getHp());

        trainer1.setOpponent(trainer3);
        trainer3.setOpponent(trainer1);

        trainer3.addCard(new ElectricTypePokemonCard(50, attacks2, trainer3));
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks, trainer1));

        trainer3.selectHandCard(0);
        trainer3.playCard();
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.swapActivePokemon();

        assertEquals(50, trainer1.getActivePokemon().getHp());

        trainer3.selectAbility(0);
        assertEquals(50, trainer1.getActivePokemon().getHp());
        trainer3.addCard(new ElectricEnergyCard());
        trainer3.addCard(new ElectricEnergyCard());
        trainer3.selectHandCard(0);
        trainer3.playCard();
        trainer3.selectHandCard(0);
        trainer3.playCard();
        trainer3.useAbility();

        assertEquals(40, trainer1.getActivePokemon().getHp());

        trainer3.selectAbility(2);
        trainer3.useAbility();

        assertEquals(10, trainer1.getActivePokemon().getHp());
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
        trainer1.addCard(new ElectricEnergyCard());
        assertEquals(1, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        trainer1.playCard();
        assertEquals(0, trainer1.handSize());
        assertEquals(1, trainer1.benchSize());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().energySetSize());



        trainer1.addCard(electricEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        trainer1.addCard(fightingEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        trainer1.addCard(fireEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        trainer1.addCard(grassEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        trainer1.addCard(psychicEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        trainer1.addCard(waterEnergyCard);
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();


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
        trainer1.addCard(new ElectricEnergyCard());
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
        trainer1.selectBenchPokemon(1);
        trainer1.swapActivePokemon();
        assertEquals(3, trainer1.maxNumAttacks());

        trainer1.addCard(new ElectricTypePokemonCard(50, attacks3, trainer1));
        trainer1.playCard();
        trainer1.selectBenchPokemon(2);
        trainer1.swapActivePokemon();
        assertEquals(3, trainer1.maxNumAttacks());
    }

    @Test
    public void deadPokemonRemoved() throws Exception {
        trainer1.addCard(new ElectricTypePokemonCard(50, attacks, trainer1));
        trainer2.addCard(new FireTypePokemonCard(50, attacks, trainer2));

        trainer1.playCard();
        trainer2.playCard();

        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(new ElectricEnergyCard());
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

    @Test
    public void prizeCard() {
        assertEquals(0, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(1, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(2, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(3, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(4, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(5, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(6, trainer1.getPrizeCards().size());
        trainer1.drawPrizeCard();
        assertEquals(6, trainer1.getPrizeCards().size());
    }

    @Test
    public void deckTest() {
        assertEquals(60, trainer1.deckSize());
        trainer1.drawCard();
        assertEquals(59, trainer1.deckSize());

        for (int i = 0; i < 59; i ++) {
            trainer1.drawCard();
        }

        assertEquals(0, trainer1.deckSize());
        assertEquals(60, trainer1.handSize());
        trainer1.drawCard();
        assertEquals(60, trainer1.handSize());

        trainer1.addCardToDeck(electricPokemon);
        trainer1.drawCard();
        trainer1.selectHandCard(60);
        assertEquals(electricPokemon, trainer1.getSelectedCard());
    }

    @Test
    public void discardPile() {
        IBasicPokemon basicPokemon = new ElectricTypePokemonCard(trainer1);
        IPhase1Pokemon phase1Pokemon = new ElectricPhase1PokemonCard(trainer1);
        IPhase2Pokemon phase2Pokemon = new ElectricPhase2PokemonCard(trainer1);

        trainer1.addCard(basicPokemon);
        trainer1.addCard(phase1Pokemon);
        trainer1.addCard(phase2Pokemon);
        assertTrue(trainer1.getDiscardPile().isEmpty());
        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertTrue(trainer1.getDiscardPile().isEmpty());
        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertEquals(basicPokemon, trainer1.getDiscardPile().get(0));
        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertEquals(phase1Pokemon, trainer1.getDiscardPile().get(1));
    }
}