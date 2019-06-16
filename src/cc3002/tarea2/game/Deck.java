package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.energies.ElectricEnergyCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1.ElectricPhase1PokemonCard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that implement a deck for holding cards.
 *
 * @author Juan Urrutia
 */
public class Deck {

    /**
     * An array containing the cards of the deck.
     */
    private ArrayList<ICard> cards = new ArrayList<>();

    /**
     * The trainer owner of the deck.
     */
    private Trainer trainer;

    /**
     * Constructor of Deck
     * @param size The deck size.
     * @param trainer The deck owner.
     */
    public Deck(int size, Trainer trainer) {
        this.trainer = trainer;

        for (int i = 0; i < size; i++) {
            double randomNumber = Math.random();
            if (randomNumber < 0.2)
                cards.add(new ElectricTypePokemonCard(trainer));
            else if (randomNumber >= 0.2 && randomNumber < 0.4)
                cards.add(new FightingTypePokemonCard(trainer));
            else if (randomNumber >= 0.4 && randomNumber < 0.6)
                cards.add(new ElectricTypePokemonCard(trainer));
            else if (randomNumber >= 0.6 && randomNumber < 0.8)
                cards.add(new ElectricPhase1PokemonCard(trainer));
            else
                cards.add(new ElectricEnergyCard());
        }

    }

    /**
     * Draws an amount of top cards.
     * @param i The amount of cards to draw.
     * @return Returns an array list with the cards.
     */
    public ArrayList<ICard> drawTopCards(int i) {
        ArrayList<ICard> drawnCards = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            if (!cards.isEmpty()) {
                ICard card = cards.get(0);
                cards.remove(0);
                drawnCards.add(card);
            }
        }
        return drawnCards;
    }

    /**
     * Draws an amount of bottom cards.
     * @param i The amount of cards to be drawn.
     * @return Returns an array list with the drawn cards.
     */
    public ArrayList<ICard> drawBottomCards(int i) {
        ArrayList<ICard> drawnCards = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            if (!cards.isEmpty()) {
                ICard card = cards.get(cards.size() - 1);
                cards.remove(cards.size() - 1);
                drawnCards.add(card);
            }
        }
        return drawnCards;
    }

    /**
     * Adds a card to the top of the deck.
     * @param card The card to be added.
     */
    public void addTopCard(ICard card) {
        cards.add(0, card);
    }

    /**
     * Adds a card to the bottom of the deck.
     * @param card The card to be added.
     */
    public void addBottomCard(ICard card) {
        cards.add(card);
    }

    /**
     * Shuffles the cards on the deck.
     */
    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    /**
     *
     * @return Returns true if the deck is empty.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     *
     * @return Returns the size of the deck.
     */
    public int getSize() {
        return cards.size();
    }
}
