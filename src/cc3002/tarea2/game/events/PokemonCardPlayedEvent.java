package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class PokemonCardPlayedEvent implements IEvent {

    private IPokemonCard pokemonCard;

    public PokemonCardPlayedEvent(IPokemonCard pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    @Override
    public void accept(IEventVisitor eventVisitor) {
        eventVisitor.visitPokemonCardPlayedEvent(this);
    }

    public IPokemonCard getPokemonCard() {
        return this.pokemonCard;
    }
}
