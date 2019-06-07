package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.pokemon.pokemons.ElectricTypePokemonCard;

public class Deck {
    private int size;
    private int cardsLeft;
    private Trainer trainer;

    public Deck(int size) {
        this.size = size;
        this.trainer = trainer;
        this.cardsLeft = size;
    }

    public Card drawCard() {
        this.cardsLeft--;
        //TODO Implement random card draw.
        return new ElectricTypePokemonCard(trainer);
    }

    public boolean isEmpty() {
        return this.cardsLeft == 0;
    }
}
