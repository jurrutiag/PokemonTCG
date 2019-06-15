package cc3002.tarea2.game.cards.pokemon.types.phases.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.types.AbstractElectricPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class ElectricPhase2Pokemon extends AbstractElectricPokemon implements IPhase2Pokemon {

    /**
     * Creates an electric type AbstractPokemonCard.
     *
     * @param hp        The initial hp of the AbstractPokemonCard.
     * @param id
     * @param name
     * @param abilities An array with the attacks of the AbstractPokemonCard.
     * @param trainer   The trainer owner of the AbstractPokemonCard.
     */
    public ElectricPhase2Pokemon(int hp, int id, String name, IAbility[] abilities, Trainer trainer) {
        super(hp, id, name, abilities, trainer);
    }

    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPhase2Pokemon(this);
    }
}
