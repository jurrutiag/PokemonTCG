package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.events.IEvent;
import cc3002.tarea2.game.searching.ISearchCardMethod;
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

    private int handCardSelected;

    private int abilityIndex;


    //TODO implement prize cards.
    /**
     * Creates a AbstractTrainerCard with an empty hand and an empty bench.
     */
    public Trainer() {

        hand = new ArrayList<>();
        bench = new ArrayList<>();
        deck = new Deck(60, this);
        discardPile = new ArrayList<>();
        benchPokemonSelected = 0;
        handCardSelected = 0;
        abilityIndex = 0;
    }

    public void notifyEvent(IEvent event) {
        setChanged();
        notifyObservers(event);
    }

    public void discard(ICard card) {
        discardPile.add(card);
    }

    /**
     * Draws a card from the deck and inserts it in the hand.
     */
    public void drawCard() {
        if (!deck.isEmpty()) {
            this.addCard(this.deck.drawCard());
        }
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

    public void selectHandCard(int index) {
        if (index < handSize()) {
            handCardSelected = index;
        }
    }

    /**
     * Plays a card from the hand and removes it from the hand if it was played successfully
     */
    public void playCard() {
        PlayVisitor playVisitor = new PlayVisitor(this);
        hand.get(handCardSelected).accept(playVisitor);

        if (playVisitor.wasPlayedCorrectly()) {
            hand.remove(handCardSelected);
        }
    }

    /**
     * Swaps the active AbstractPokemonCard for another one in the bench.
     * @param benchIndex The bench index where the AbstractPokemonCard that will be put as active is.
     */
    public void swapActivePokemon(int benchIndex) {
        if (bench.size() > benchIndex) {
            Collections.swap(bench, 0, benchIndex);
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
     * @return Returns the current active AbstractPokemonCard of the bench, that is the first AbstractPokemonCard in the bench
     */
    public IPokemonCard getActivePokemon() {
        return bench.get(0);
    }

    public void selectAbility(int index) {
        if (index < 4) {
            abilityIndex = index;
        }
    }

    /**
     * Uses an active pokemon ability.
     */
    public void useAbility() {
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

    public IPokemonCard getSelectedPokemon() {
        return bench.get(benchPokemonSelected);
    }

    public ICard getSelectedCard() {
        return hand.get(handCardSelected);
    }

    public void pokemonDied(IPokemonCard pokemonCard) {
        if (pokemonCard == this.getActivePokemon()) {
            this.notifyEvent(new ActivePokemonDiedEvent(pokemonCard));
        }
        discard(pokemonCard);
        bench.remove(pokemonCard);
    }


    public <T> ArrayList<T> search(ISearchCardMethod<T> searchMethod, ArrayList<T> searchPlace) {
        ArrayList<T> result = new ArrayList<>();
        for (T element : searchPlace) {
            if (searchMethod.match(element)) {
                result.add(element);
            }
        }
        return result;
    }

//    public ArrayList<IPokemonCard> searchBench(ISearchCardMethod searchMethod) {
//        ArrayList<IPokemonCard> result = new ArrayList<>();
//        for (IPokemonCard pokemon : this.bench) {
//            if (searchMethod.match(pokemon)) {
//                result.add(pokemon);
//            }
//        }
//        return result;
//    }
//
//    //TODO: remove code duplication of search on trainer
//
//    public ArrayList<ICard> searchHand(ISearchCardMethod searchMethod) {
//        ArrayList<ICard> result = new ArrayList<>();
//        for (ICard card : this.hand) {
//            if (searchMethod.match(card)) {
//                result.add(card);
//            }
//        }
//        return result;
//    }

}
