package cc3002.tarea2.game.cards.pokemon.types.phases.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractWaterPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.visitor.card.ICardVisitor;

/**
 * Class representing water phase 2 Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class WaterPhase2Pokemon extends AbstractWaterPokemon implements IPhase2Pokemon {


    /**
     * Creates a water type phase 2 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id    The pokemon id
     * @param name  The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public WaterPhase2Pokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPhase2Pokemon(this);
    }
}
