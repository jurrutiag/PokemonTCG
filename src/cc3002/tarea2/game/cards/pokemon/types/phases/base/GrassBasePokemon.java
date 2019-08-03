package cc3002.tarea2.game.cards.pokemon.types.phases.base;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractGrassPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing grass basic Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class GrassBasePokemon extends AbstractGrassPokemon implements IBasicPokemon {
    /**
     * Creates a grass type base pokemon.
     *  @param hp      The initial hp of the AbstractPokemonCard.
     * @param id    The pokemon id
     * @param name  The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer The trainer owner of the AbstractPokemonCard.
     */
    public GrassBasePokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitBasicPokemon(this);
    }
}
