package cc3002.tarea2.game.cards.pokemon.types.phases.phase2;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.AbstractWaterPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class WaterPhase2Pokemon extends AbstractWaterPokemon implements IPhase2Pokemon {
    /**
     * Creates a water type AbstractPokemonCard.
     *
     * @param hp      The initial hp of the AbstractPokemonCard.
     * @param id
     * @param name
     * @param attacks An array with the attacks of the AbstractPokemonCard.
     * @param trainer The trainer owner of the AbstractPokemonCard.
     */
    public WaterPhase2Pokemon(int hp, int id, String name, IAttack[] attacks, Trainer trainer) {
        super(hp, id, name, attacks, trainer);
    }

    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPhase2Pokemon(this);
    }
}
