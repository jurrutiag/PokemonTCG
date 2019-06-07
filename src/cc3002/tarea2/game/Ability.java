package cc3002.tarea2.game;

import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.visitor.turn.EventVisitable;

/**
 * Ability interface gives common methods to all abilities that a PokemonCard can have.
 *
 * @author Juan Urrutia
 */
public interface Ability extends EventVisitable {
    /**
     *
     * @return Returns the name of the ability.
     */
    public String getName();

    public void executeEffect(IPokemonCard pokemon);

    void isUsedBy(IPokemonCard pokemon);
}
