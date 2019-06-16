package cc3002.tarea2.game.searching.methods;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.searching.ISearchCardMethod;

/**
 * Search method. It searches pokemons that have certain object.
 *
 * @author Juan Urrutia
 */
public class SearchObjectOwner implements ISearchCardMethod<IPokemonCard> {

    /**
     * The object to be searched for.
     */
    private IObjectCard object;

    /**
     * Constructor of the search method.
     * @param object The object to be searched for.
     */
    public SearchObjectOwner(IObjectCard object) {
        this.object = object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean match(IPokemonCard element) {
        return element.getAssociatedObjects().contains(this.object);
    }
}
