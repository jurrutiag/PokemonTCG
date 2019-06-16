package cc3002.tarea2.test;

import cc3002.tarea2.game.Deck;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    private Deck emptyStartDeck;
    private Deck card60Deck;

    private ICard electricPokemon;
    private ICard fightingPokemon;

    private Trainer trainer1;
    private Trainer trainer2;

    @Before
    public void setUp() throws Exception {
        this.trainer1 = new Trainer();
        this.trainer2 = new Trainer();
        this.emptyStartDeck = new Deck(0, trainer1);
        this.card60Deck = new Deck(60, trainer2);
        this.electricPokemon = new ElectricTypePokemonCard(trainer1);
        this.fightingPokemon = new FightingTypePokemonCard(trainer1);
    }

    @Test
    public void drawTopCard() {
        assertTrue(this.emptyStartDeck.drawTopCards(1).isEmpty());
        this.card60Deck.drawTopCards(1).get(0);
        assertEquals(59, this.card60Deck.getSize());
        assertFalse(this.card60Deck.drawTopCards(1).isEmpty());
        assertEquals(58, this.card60Deck.getSize());
        for (int i = 0; i < 58; i++) {
            this.card60Deck.drawTopCards(1).get(0);
        }
        assertTrue(this.emptyStartDeck.drawTopCards(1).isEmpty());

        this.emptyStartDeck.addTopCard(electricPokemon);
        assertEquals(electricPokemon, this.emptyStartDeck.drawTopCards(1).get(0));
        assertTrue(this.emptyStartDeck.drawTopCards(1).isEmpty());

        this.emptyStartDeck.addTopCard(electricPokemon);
        this.emptyStartDeck.addTopCard(fightingPokemon);
        assertEquals(fightingPokemon, this.emptyStartDeck.drawTopCards(1).get(0));
        assertEquals(electricPokemon, this.emptyStartDeck.drawTopCards(1).get(0));
    }

    @Test
    public void drawBottomCard() {
        assertTrue(this.emptyStartDeck.drawBottomCards(1).isEmpty());
        this.card60Deck.drawBottomCards(1);
        assertEquals(59, this.card60Deck.getSize());
        assertFalse(this.card60Deck.drawBottomCards(1).isEmpty());
        assertEquals(58, this.card60Deck.getSize());
        for (int i = 0; i < 58; i++) {
            this.card60Deck.drawBottomCards(1);
        }
        assertTrue(this.emptyStartDeck.drawBottomCards(1).isEmpty());

        this.emptyStartDeck.addBottomCard(electricPokemon);
        assertEquals(electricPokemon, this.emptyStartDeck.drawBottomCards(1).get(0));
        assertTrue(this.emptyStartDeck.drawBottomCards(1).isEmpty());

        this.emptyStartDeck.addBottomCard(electricPokemon);
        this.emptyStartDeck.addBottomCard(fightingPokemon);
        assertEquals(fightingPokemon, this.emptyStartDeck.drawBottomCards(1).get(0));
        assertEquals(electricPokemon, this.emptyStartDeck.drawBottomCards(1).get(0));
    }

    @Test
    public void addCard() {
        assertEquals(60, this.card60Deck.getSize());
        this.card60Deck.addTopCard(electricPokemon);
        assertEquals(61, this.card60Deck.getSize());
        this.card60Deck.drawTopCards(1);
        assertEquals(60, this.card60Deck.getSize());
    }

    @Test
    public void shuffleCards() {
        assertEquals(0, this.emptyStartDeck.getSize());

        this.emptyStartDeck.addTopCard(electricPokemon);
        this.emptyStartDeck.addTopCard(fightingPokemon);

        this.emptyStartDeck.shuffleCards();
        this.card60Deck.shuffleCards();
    }

    @Test
    public void isEmpty() {
        assertTrue(this.emptyStartDeck.isEmpty());
        assertFalse(this.card60Deck.isEmpty());
    }
}