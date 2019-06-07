package cc3002.tarea2.game.searching.methods;

import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.searching.ISearchCardMethod;

public class SearchPokemonByID implements ISearchCardMethod<IPokemonCard> {

    private int id;

    public SearchPokemonByID(int id) {
        this.id = id;
    }

    @Override
    public boolean match(IPokemonCard pokemon) {
        return pokemon.getId() == this.id;
    }
}
