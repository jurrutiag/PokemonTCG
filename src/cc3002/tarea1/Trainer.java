package cc3002.tarea1;

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {

    private ArrayList<Card> hand;
    private ArrayList<Pokemon> bench;

    private Trainer opponent;


    public Trainer() {

        hand = new ArrayList<Card>();
        bench = new ArrayList<Pokemon>();

    }

    public void setActivePokemon(int handIndex) {
        assert(bench.size() < 6);
        bench.add((Pokemon) hand.get(handIndex));
        hand.remove(handIndex);
    }

    public Trainer getOpponent() {
        return opponent;
    }

    public void swapActivePokemon(int benchIndex) {
        if (bench.get(benchIndex).isActivelySelectable()) {
            Collections.swap(bench, 0, benchIndex);
        }
    }

    public void swapNextNotDead() {
        for (int i = 1; i < bench.size(); i++) {
            if (bench.get(i).getHp() != 0) {
                swapActivePokemon(i);
            }
        }
    }

    public void setOpponent(Trainer opponent) {
        this.opponent = opponent;
    }

    public int benchSize() {
        return bench.size();
    }

    public int handSize() {
        return hand.size();
    }

    public Pokemon getActivePokemon() {
        return (Pokemon) bench.get(0);
    }

    public void activePokemonAttack(int attackNum) {
        getActivePokemon().attack(attackNum, opponent);
    }

    public Card getCardFromHand(int selectedCard) {
        return hand.get(selectedCard);
    }

    public Pokemon getCardFromBench(int selectedCard) {
        return bench.get(selectedCard);
    }

    public int maxNumAttacks() {
        return getActivePokemon().getAbilitiesAmount();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void addEnergy(Energy energy) {
        this.getActivePokemon().bindEnergy(energy);
    }

    public void addPokemonToBench(int handIndex) {
        assert(bench.size() < 6);
        bench.add((Pokemon) hand.get(handIndex));
        hand.remove(handIndex);
        if (bench.get(0).getHp() == 0) {
            swapNextNotDead();
        }
    }
}
