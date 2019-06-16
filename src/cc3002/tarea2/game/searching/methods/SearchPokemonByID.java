package cc3002.tarea2.game.searching.methods;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.searching.ISearchCardMethod;

/**
 * Search method. It searches pokemons by their id.
 *
 * @author Juan Urrutia
 */
public class SearchPokemonByID implements ISearchCardMethod<IPokemonCard> {

    /**
     * The id of the pokemon to search.
     */
    private int id;

    /**
     * Constructor of the search method.
     * @param id The if of the pokemon to search.
     */
    public SearchPokemonByID(int id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean match(IPokemonCard pokemon) {
        return pokemon.getId() == this.id;
    }
}
