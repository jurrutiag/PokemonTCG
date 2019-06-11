package cc3002.tarea2.game.cards.pokemon.types.phases.phase1;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.AbstractFightingPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class FightingPhase1Pokemon extends AbstractFightingPokemon implements IPhase1Pokemon {
    /**
     * Creates a fighting type AbstractPokemonCard.
     *
     * @param hp      The initial hp of the AbstractPokemonCard.
     * @param id
     * @param name
     * @param attacks An array with the attacks of the AbstractPokemonCard.
     * @param trainer The trainer owner of the AbstractPokemonCard.
     */
    public FightingPhase1Pokemon(int hp, int id, String name, IAttack[] attacks, Trainer trainer) {
        super(hp, id, name, attacks, trainer);
    }

    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitPhase1Pokemon(this);
    }
}
