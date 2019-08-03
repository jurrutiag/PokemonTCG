package cc3002.tarea2.game.cards.pokemon.types.phases.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractElectricPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.visitor.card.ICardVisitor;


/**
 * Class representing electric phase 1 Pokemons.
 *
 * @author Juan Urrutia
 */
public abstract class ElectricPhase1Pokemon extends AbstractElectricPokemon implements IPhase1Pokemon {


    /**
     * Creates an electric type phase 1 pokemon.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id    The pokemon id
     * @param name  The pokemon name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public ElectricPhase1Pokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ICardVisitor visitor) throws PlayCardException {
        super.accept(visitor);
        visitor.visitPhase1Pokemon(this);
    }
}
