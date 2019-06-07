package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.IEnergyCard;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.EvolvedPhase;
import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.searching.ISearchCardMethod;
import cc3002.tarea2.game.searching.methods.SearchPokemonByID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * Class that represents a TrainerCard, the player of the game.
 *
 * @author Juan Urrutia
 */
public class Trainer extends Observable {

    /**
     * Array of cards that represents the hand of the trainer, it has no limits in size.
     */
    private ArrayList<Card> hand;

    /**
     * Array of Pokemons that represent the bench of the trainer, it has a limit of 6 Pokemons
     * including the active PokemonCard, which is represented as the first element of the array.
     */
    private ArrayList<IPokemonCard> bench;

    /**
     * Pile where all discarded cards go.
     */
    private ArrayList<Card> discardPile;

    /**
     * The opponent of the actual TrainerCard in the game.
     */
    private Trainer opponent;

    /**
     * Deck where the trainer gets the cards.
     */
    private Deck deck;

    /**
     * Index of the pokemon in the bench that will receive the effect of some played card.
     */
    private int pokemonSelectedForCardIndex;


    //TODO implement prize cards.
    /**
     * Creates a TrainerCard with an empty hand and an empty bench.
     */
    public Trainer() {

        hand = new ArrayList<>();
        bench = new ArrayList<>();
        deck = new Deck(60);
        discardPile = new ArrayList<>();
        pokemonSelectedForCardIndex = 0;

    }

    public void discard(Card card) {
        discardPile.add(card);
    }

    /**
     * Draws a card from the deck and inserts it in the hand.
     */
    public void drawCard() {
        if (!deck.isEmpty()) {
            hand.add(this.deck.drawCard());
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
    public void selectPokemonForCard(int index) {
        pokemonSelectedForCardIndex = index;
    }

    /**
     * Plays a card from the hand and removes it from the hand if it was played successfully
     * @param handIndex The hand index where the card to be played resides.
     */
    public void playCard(int handIndex) {
        if (hand.get(handIndex).bePlayedBy(this)) {
            hand.remove(handIndex);
            setChanged();
            notifyObservers(hand.get(handIndex));
        }
    }

    /**
     * Swaps the active PokemonCard for another one in the bench.
     * @param benchIndex The bench index where the PokemonCard that will be put as active is.
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
     * @return Returns the current active PokemonCard of the bench, that is the first PokemonCard in the bench
     */
    public IPokemonCard getActivePokemon() {
        return bench.get(0);
    }

    /**
     * Selects an ability for the active pokemon to use.
     * @param index The index of the ability to use, represents the position of the ability in the abilities array of the active pokemon.
     */
    public void useAbility(int index) {
        getActivePokemon().useAbility(index);
    }

    /**
     * @return Returns the hand.
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Returns a PokemonCard from the bench.
     * @return Returns the selected PokemonCard.
     */
    public ArrayList<IPokemonCard> getBench() {
        return bench;
    }

    /**
     *
     * @return Returns the amount of abilities that the active PokemonCard has.
     */
    public int maxNumAttacks() {
        return getActivePokemon().getAbilitiesAmount();
    }

    /**
     * Adds a card to the hand.
     * @param card The Card to be added.
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Binds an energy to the active PokemonCard.
     * @param energy The energy to be bind.
     */
    public void addEnergy(IEnergyCard energy) {
        if (pokemonSelectedForCardIndex < benchSize()) {
            energy.bePlayedBy(this);
        }
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
        return bench.get(pokemonSelectedForCardIndex);
    }

    public void pokemonDied(IPokemonCard pokemonCard) {
        if (pokemonCard == this.getActivePokemon()) {
            setChanged();
            notifyObservers(new ActivePokemonDiedEvent(pokemonCard));
        }
        discard(pokemonCard);
        bench.remove(pokemonCard);
    }

    public boolean playBasePokemon(BasicPhase basicPhase) {
        return this.addPokemonToBench(basicPhase.getPokemon());
    }

    public boolean playPhasePokemon(EvolvedPhase evolvedPhase) {
        ArrayList<IPokemonCard> preevolutions = search(new SearchPokemonByID(evolvedPhase.getPreevolutionId()), this.bench);
        if (!preevolutions.isEmpty()) {
            EnergySet preevolutionEnergySet = bench.get(bench.indexOf(preevolutions.get(0))).getEnergySet();
            bench.remove(preevolutions.get(0));
            evolvedPhase.getPokemon().setEnergies(preevolutionEnergySet);
            bench.add(evolvedPhase.getPokemon());
            return true;
        }
        return false;
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
//    public ArrayList<Card> searchHand(ISearchCardMethod searchMethod) {
//        ArrayList<Card> result = new ArrayList<>();
//        for (Card card : this.hand) {
//            if (searchMethod.match(card)) {
//                result.add(card);
//            }
//        }
//        return result;
//    }

}
