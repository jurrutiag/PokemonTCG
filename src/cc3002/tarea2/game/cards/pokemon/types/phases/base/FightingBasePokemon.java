package cc3002.tarea2.game.cards.pokemon.types.phases.base;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.AbstractFightingPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.visitor.ICardVisitor;

public abstract class FightingBasePokemon extends AbstractFightingPokemon implements IBasicPokemon {
    /**
     * Creates a fighting type AbstractPokemonCard.
     *
     * @param hp      The initial hp of the AbstractPokemonCard.
     * @param id
     * @param name
     * @param attacks An array with the attacks of the AbstractPokemonCard.
     * @param trainer The trainer owner of the AbstractPokemonCard.
     */
    public FightingBasePokemon(int hp, int id, String name, IAttack[] attacks, Trainer trainer) {
        super(hp, id, name, attacks, trainer);
    }

    public void accept(ICardVisitor visitor) {
        super.accept(visitor);
        visitor.visitBasicPokemon(this);
    }
}
