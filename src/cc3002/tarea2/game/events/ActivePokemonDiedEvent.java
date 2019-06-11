package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.visitor.ICardVisitor;
import cc3002.tarea2.game.visitor.IEventVisitor;

public class ActivePokemonDiedEvent implements IEvent {

    private IPokemonCard activePokemon;

    public ActivePokemonDiedEvent(IPokemonCard activePokemon) {
        this.activePokemon = activePokemon;
    }

    public IPokemonCard getActivePokemon() {
        return activePokemon;
    }

    @Override
    public void accept(IEventVisitor visitor) {
        visitor.visitActivePokemonDiedEvent(this);
    }
}
