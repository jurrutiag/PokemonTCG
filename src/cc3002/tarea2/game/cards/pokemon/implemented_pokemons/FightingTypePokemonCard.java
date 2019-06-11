package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.FightingBasePokemon;

/**
 * Fighting Type pokemon class created for testing, represents a fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingTypePokemonCard extends FightingBasePokemon {

    public FightingTypePokemonCard(Trainer trainer) {this(10, 2, new IAttack[] {}, trainer);}

    public FightingTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 2, attack, trainer);
    }

    public FightingTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "FightingTypePokemonCard", attack, trainer);
    }
}
