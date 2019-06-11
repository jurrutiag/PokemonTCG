package cc3002.tarea2.game.searching.methods;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.IObjectCard;
import cc3002.tarea2.game.searching.ISearchCardMethod;

public class SearchObjectOwner implements ISearchCardMethod<IPokemonCard> {

    private IObjectCard object;

    public SearchObjectOwner(IObjectCard object) {
        this.object = object;
    }

    @Override
    public boolean match(IPokemonCard element) {
        return element.getAssociatedObjects().contains(this.object);
    }
}
