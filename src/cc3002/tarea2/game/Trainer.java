package cc3002.tarea2.game;

import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.NullCard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.events.CardDrawnEvent;
import cc3002.tarea2.game.exceptions.NotEnoughEnergiesForAbilityException;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.exceptions.WinException;
import cc3002.tarea2.game.searching.ISearchCardMethod;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.card.PlayVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * Class that represents a AbstractTrainerCard, the player of the game.
 *
 * @author Juan Urrutia
 */
public class Trainer extends Observable {

    private String name;

    /**
     * Array of cards that represents the hand of the trainer, it has no limits in size.
     */
    private ArrayList<ICard> hand;

    /**
     * Array of Pokemons that represent the bench of the trainer, it has a limit of 6 Pokemons
     * including the active AbstractPokemonCard, which is represented as the first element of the array.
     */
    private ArrayList<IPokemonCard> bench;

    /**
     * Pile where all discarded cards go.
     */
    private ArrayList<ICard> discardPile;

    /**
     * The trainer's prize cards
     */
    private ArrayList<ICard> prizeCards;

    /**
     * The opponent of the actual AbstractTrainerCard in the game.
     */
    private Trainer opponent;

    /**
     * Deck where the trainer gets the cards.
     */
    private Deck deck;

    /**
     * Index of the pokemon in the bench that will receive the effect of some played card.
     */
    private int benchPokemonSelected;

    /**
     * Index of the card that is selected in the hand.
     */
    private int handCardSelected;

    /**
     * Selected index of active pokemon ability.
     */
    private int abilityIndex;


    /**
     * Creates a AbstractTrainerCard with an empty hand and an empty bench.
     */
    public Trainer() {
        prizeCards = new ArrayList<>();
        hand = new ArrayList<>();
        bench = new ArrayList<>();
        deck = new Deck(60, this);
        discardPile = new ArrayList<>();
        benchPokemonSelected = 0;
        handCardSelected = 0;
        abilityIndex = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Notifies the trainer's observers of an event.
     * @param event the event to be notified.
     */
    public void notifyEvent(IEventVisitable event) {
        event.setTrainer(this);
        setChanged();
        notifyObservers(event);
    }

    public void handToDeck() {
        this.deck.addCards(this.hand);
        this.deck.shuffleCards();
        this.hand = new ArrayList<>();
    }

    /**
     * Sends a card to the discard pile (doesn't removes it from anywhere)
     * @param card the card to be discarded.
     */
    public void discard(ICard card) {
        card.getDiscarded(this);
    }

    /**
     * Discards the selected card from the hand. It also removes it.
     */
    public void discardSelectedFromHand() {
        this.discard(this.getSelectedCard());
        this.hand.remove(this.getSelectedCard());
    }

    /**
     *
     * @return Returns the discard pile.
     */
    public ArrayList<ICard> getDiscardPile() {
        return this.discardPile;
    }


    public void drawPrizeCards() {
        prizeCards.addAll(this.deck.drawTopCards(6));

    }

    public ICard getPrizeCard() throws WinException {

        ICard prize = prizeCards.get(0);
        prizeCards.remove(0);
        if (prizeCards.isEmpty())
            throw new WinException();

        return prize;
    }

    /**
     * Draws a card from the deck and inserts it in the hand.
     */
    public void drawCard() {
        this.drawTopCards(1);
    }

    /**
     * Draws the first i top cards.
     * @param i the number of cards to be drawn.
     */
    public void drawTopCards(int i) {
        ArrayList<ICard> cardsDrawn = this.deck.drawTopCards(i);
        hand.addAll(cardsDrawn);
        for (ICard card : cardsDrawn) {
            notifyEvent(new CardDrawnEvent(card));
        }
    }

    /**
     * Adds a card to the deck.
     * @param card The card to be added.
     */
    public void addCardToDeck(ICard card) {
        this.deck.addTopCard(card);
    }

    /**
     *
     * @return Returns the deck's actual size.
     */
    public int deckSize() {
        return this.deck.getSize();
    }

    /**
     *
     * @return Returns the opponent of the current trainer.
     */
    public Trainer getOpponent() {
        return opponent;
    }

    /**
     * Selects a pokemon for a card to be played on
     * @param index the index on the bench of the pokemon to be selected.
     */
    public void selectBenchPokemon(int index) {
        if (index < benchSize()) {
            benchPokemonSelected = index;
        }
    }

    /**
     * Selects a card from the hand.
     * @param index The index of the card to be selected.
     */
    public void selectHandCard(int index) {
        if (index < handSize()) {
            handCardSelected = index;
        }
    }

    /**
     * Plays a card from the hand and removes it from the hand if it was played successfully
     */
    public void playCard() throws PlayCardException {
        PlayVisitor playVisitor = new PlayVisitor(this);

        ICard playCard = hand.get(handCardSelected);

        try {
            playCard.accept(playVisitor);
            hand.remove(playCard);
        } catch (PlayCardException e) {
            throw e;
        }
    }

    /**
     * Swaps the active AbstractPokemonCard for another one in the bench.
     */
    public void swapActivePokemon() {
        if (bench.size() > this.benchPokemonSelected) {
            Collections.swap(bench, 0, this.benchPokemonSelected);
        }
    }

    /**
     * Sets the opponent of the trainer.
     * @param opponent The opponent to be assigned to the variable opponent of trainer.
     */
    public void setOpponent(Trainer opponent) {
        this.opponent = opponent;
    }

    /**
     *
     * @return Returns the current size of the bench.
     */
    public int benchSize() {
        return bench.size();
    }

    /**
     *
     * @return Returns the current size of the hand.
     */
    public int handSize() {
        return hand.size();
    }

    /**
     *
     * @return Returns the deck.
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     *
     * @return Returns the current active AbstractPokemonCard of the bench, that is the first AbstractPokemonCard in the bench
     */
    public IPokemonCard getActivePokemon() {
        return bench.get(0);
    }

    /**
     * Selects one of four abilities.
     * @param index the index of the ability.
     */
    public void selectAbility(int index) {
        if (index < 4) {
            abilityIndex = index;
        }
    }

    /**
     * Uses an active pokemon ability.
     */
    public void useAbility() throws NotEnoughEnergiesForAbilityException {
        getActivePokemon().useAbility(abilityIndex);
    }

    /**
     * @return Returns the hand.
     */
    public ArrayList<ICard> getHand() {
        return hand;
    }

    /**
     * Returns a AbstractPokemonCard from the bench.
     * @return Returns the selected AbstractPokemonCard.
     */
    public ArrayList<IPokemonCard> getBench() {
        return bench;
    }

    /**
     *
     * @return Returns the amount of abilities that the active AbstractPokemonCard has.
     */
    public int maxNumAttacks() {
        return getActivePokemon().getAbilitiesAmount();
    }

    /**
     * Adds a card to the hand.
     * @param card The ICard to be added.
     */
    public void addCard(ICard card) {
        card.setTrainer(this);
        hand.add(card);
    }


    /**
     *
     * @return Returns true if the bench is full.
     */
    private boolean checkBenchFull() {
        return !(bench.size() < 6);
    }

    /**
     * Moves a pokemon from the hand to the bench if the bench is not full, if it's full nothing is done.
     * @param pokemon The the pokemon to be moved.
     */
    public boolean addPokemonToBench(IPokemonCard pokemon) {
        if (!checkBenchFull()) {
            bench.add(pokemon);
            return true;
        }
        return false;
    }

    /**
     *
     * @return Returns the selected bench pokemon
     */
    public IPokemonCard getSelectedPokemon() {
        return bench.get(benchPokemonSelected);
    }

    /**
     *
     * @return Returns the selected hand card.
     */
    public ICard getSelectedCard() {
        if (hand.size() > handCardSelected) {
            return hand.get(handCardSelected);
        }
        return new NullCard();
    }

    /**
     * Notifies and discard a pokemon if it dies.
     * @param pokemonCard the pokemon that died.
     */
    public void pokemonDied(IPokemonCard pokemonCard) {
        if (pokemonCard == this.getActivePokemon()) {
            this.notifyEvent(new ActivePokemonDiedEvent());
        }
        discard(pokemonCard);
        bench.remove(pokemonCard);
    }


    /**
     * Method for searching in an ArrayList.
     * @param searchMethod the search method.
     * @param searchPlace the ArrayList to search.
     * @param <T> Generic used to avoid duplication of code for ICard and IPokemonCard (hand and bench)
     * @return Returns an ArrayList with all the <T> objects that fulfill the requirements.
     */
    public <T> ArrayList<T> search(ISearchCardMethod<T> searchMethod, ArrayList<T> searchPlace) {
        ArrayList<T> result = new ArrayList<>();
        for (T element : searchPlace) {
            if (searchMethod.match(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     *
     * @return Returns the last discarded card.
     */
    public ICard getLastDiscardedCard() {
        return this.discardPile.get(this.discardPile.size() - 1);
    }

    /**
     * Draws i cards from the bottom of the deck.
     * @param i the number of cards to be drawn.
     */
    public void drawBottomCards(int i) {
        this.hand.addAll(this.deck.drawBottomCards(i));
    }

    /**
     *
     * @return Returns the selected ability.
     */
    public IAbility getSelectedAbility() {
        return getActivePokemon().getAbility(this.abilityIndex);
    }

    /**
     * Removes all pokemons from the bench.
     */
    public void clearBench() {
        this.bench = new ArrayList<>();
    }

}
