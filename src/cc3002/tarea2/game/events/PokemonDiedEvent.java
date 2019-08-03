package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class PokemonDiedEvent extends AbstractEvent {

    IPokemonCard pokemonCard;

    public PokemonDiedEvent(IPokemonCard pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitPokemonDiedEvent(this);
    }

    public IPokemonCard getPokemon() {
        return this.pokemonCard;
    }
}
