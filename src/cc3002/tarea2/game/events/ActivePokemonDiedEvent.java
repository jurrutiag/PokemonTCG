package cc3002.tarea2.game.events;

import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.visitor.turn.EventVisitor;

public class ActivePokemonDiedEvent implements Event {

    private IPokemonCard activePokemon;

    public ActivePokemonDiedEvent(IPokemonCard activePokemon) {
        this.activePokemon = activePokemon;
    }

    @Override
    public void accept(EventVisitor visitor) {
        visitor.visitActivePokemonDiedEvent(this);
    }
}
