package cc3002.tarea2.game.cards.trainer.object;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.ITrainerCard;

/**
 * Interface for objects in general.
 *
 * @author Juan Urrutia
 */
public interface IObjectCard extends ITrainerCard {
    /**
     * Method that executes the object's effect.
     */
    public void executeEffect();

    /**
     * Sets the object pokemon.
     * @param pokemonCard The pokemon that executes this card.
     */
    public void setPokemon(IPokemonCard pokemonCard);

    /**
     *
     * @return Returns the pokemon that executed this card.
     */
    public IPokemonCard getPokemon();
}
