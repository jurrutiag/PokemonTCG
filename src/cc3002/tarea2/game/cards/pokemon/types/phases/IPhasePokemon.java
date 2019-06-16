package cc3002.tarea2.game.cards.pokemon.types.phases;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;

/**
 * Interface representing a phase 1 or 2 pokemon.
 *
 * @author Juan Urrutia
 */
public interface IPhasePokemon extends IPokemonCard {
    /**
     *
     * @return Returns the preevolution id.
     */
    public int getPreevolutionId();
}
