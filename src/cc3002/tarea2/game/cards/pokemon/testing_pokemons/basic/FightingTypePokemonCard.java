package cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.FightingBasePokemon;

/**
 * Fighting Type pokemon class created for testing, represents a fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingTypePokemonCard extends FightingBasePokemon {

    public FightingTypePokemonCard(Trainer trainer) {this(10, 200, new IAttack[] {}, trainer);}

    public FightingTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 200, abilities, trainer);
    }

    public FightingTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "FightingPhase2PokemonCard", abilities, trainer);
    }
}
