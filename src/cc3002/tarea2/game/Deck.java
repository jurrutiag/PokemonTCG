package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.energies.ElectricEnergyCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.FightingTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.phase1.ElectricPhase1PokemonCard;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<ICard> cards = new ArrayList<>();
    private Trainer trainer;

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

    public void addTopCard(ICard card) {
        cards.add(0, card);
    }

    public void addBottomCard(ICard card) {
        cards.add(card);
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }
}
