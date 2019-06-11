package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.ElectricTypePokemonCard;

public class Deck {
    private int size;
    private int cardsLeft;
    private Trainer trainer;

    public Deck(int size, Trainer trainer) {
        this.size = size;
        this.trainer = trainer;
        this.cardsLeft = size;
    }

    public ICard drawCard() {
        this.cardsLeft--;
        //TODO Implement random card draw.
        return new ElectricTypePokemonCard(trainer);
    }

    public boolean isEmpty() {
        return this.cardsLeft == 0;
    }
}
