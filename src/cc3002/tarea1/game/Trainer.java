package cc3002.tarea1.game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represents a Trainer, the player of the game.
 *
 * @author Juan Urrutia
 */
public class Trainer {

    /**
     * Array of cards that represents the hand of the trainer, it has no limits in size.
     */
    private ArrayList<Card> hand;

    /**
     * Array of Pokemons that represent the bench of the trainer, it has a limit of 6 Pokemons
     * including the active Pokemon, which is represented as the first element of the array.
     */
    private ArrayList<Pokemon> bench;

    /**
     * The opponent of the actual Trainer in the game.
     */
    private Trainer opponent;

    /**
     * Creates a Trainer with an empty hand and an empty bench.
     */
    public Trainer() {

        hand = new ArrayList<>();
        bench = new ArrayList<>();

    }

    /**
     *
     * @return Returns the opponent of the current trainer.
     */
    public Trainer getOpponent() {
        return opponent;
    }

    /**
     * Plays a card from the hand
     * @param handIndex The hand index where the card to be played resides.
     */
    public void playCard(int handIndex) {
        hand.get(handIndex).bePlayedBy(this);
        hand.remove(handIndex);
    }

    /**
     * Swaps the active Pokemon for another one in the bench.
     * @param benchIndex The bench index where the Pokemon that will be put as active is.
     */
    public void swapActivePokemon(int benchIndex) {
        if (bench.get(benchIndex).isActivelySelectable()) {
            Collections.swap(bench, 0, benchIndex);
        }
    }

    /**
     * Swaps the active Pokemon for the next Pokemon in the bench that is not dead
     * according to the bench index order.
     */
    public void swapNextNotDead() {
        for (int i = 1; i < bench.size(); i++) {
            if (bench.get(i).getHp() != 0) {
                swapActivePokemon(i);
            }
        }
        this.clearDead();
    }

    /**
     * Removes the dead Pokemons from the bench.
     */
    public void clearDead() {
        for (int i = 0; i < bench.size(); i++) {
            if (bench.get(i).getHp() == 0) {
                bench.remove(i);
            }
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
     * @return Returns the current active Pokemon of the bench, that is the first Pokemon in the bench
     */
    public Pokemon getActivePokemon() {
        return bench.get(0);
    }

    /**
     * Triggers an attack from the current active pokemon to the opponent active Pokemon.
     * @param attackNum The index of the attack to be used, from 0 to 3.
     */
    public void activePokemonAttack(int attackNum) {
        if (opponent.benchSize() > 0) {
            getActivePokemon().attack(attackNum, opponent);
        }
    }

    /**
     * Returns a card from the hand.
     * @param selectedCard The hand index of the card to be selected.
     * @return Returns the Card from the hand.
     */
    public Card getCardFromHand(int selectedCard) {
        return hand.get(selectedCard);
    }

    /**
     * Returns a Pokemon from the bench.
     * @param selectedCard The bench index of the card to be asked for.
     * @return Returns the selected Pokemon.
     */
    public Pokemon getCardFromBench(int selectedCard) {
        return bench.get(selectedCard);
    }

    /**
     *
     * @return Returns the amount of abilities that the active Pokemon has.
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
     * Binds an energy to the active Pokemon.
     * @param energy The energy to be bind.
     */
    public void addEnergy(IEnergy energy) {
        this.getActivePokemon().bindEnergy(energy);
    }

    /**
     *
     * @return Returns true if the bench is full.
     */
    public boolean checkBenchFull() {
        return !(bench.size() < 6);
    }

    /**
     * Moves a pokemon from the hand to the bench if the bench is not full, if it's full nothing is done.
     * @param pokemon The the pokemon to be moved.
     */
    public void addPokemonToBench(Pokemon pokemon) {
        if(!checkBenchFull()) {
            bench.add(pokemon);
            if (bench.get(0).getHp() == 0) {
                swapNextNotDead();
            }
        }
    }
}
