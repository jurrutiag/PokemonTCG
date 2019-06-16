package cc3002.tarea2.game.cards.pokemon.types.phases.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractFightingPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing fighting phase 1 Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class FightingPhase1Pokemon extends AbstractFightingPokemon implements IPhase1Pokemon {


    /**
     * Creates a fighting type phase 1 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id    The pokemon id
     * @param name  The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public FightingPhase1Pokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPhase1Pokemon(this);
    }
}
