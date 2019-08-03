package cc3002.tarea2.game.cards.pokemon.types.phases.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractFightingPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing fighting phase 2 Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class FightingPhase2Pokemon extends AbstractFightingPokemon implements IPhase2Pokemon {

    /**
     * Creates a fighting type phase 2 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id    The pokemon id
     * @param name  The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public FightingPhase2Pokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitPhase2Pokemon(this);
    }
}
