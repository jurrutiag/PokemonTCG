package cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.GrassBasePokemon;

/**
 * Grass Type pokemon class created for testing, represents a grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassTypePokemonCard extends GrassBasePokemon {
    public GrassTypePokemonCard(Trainer trainer) {this(10, 400, new IAttack[] {}, trainer);}

    public GrassTypePokemonCard(int hp, IAbility[] abilities, Trainer trainer) {
        this(hp, 400, abilities, trainer);
    }

    public GrassTypePokemonCard(int hp, int id, IAbility[] abilities, Trainer trainer) {
        super(hp, id, "GrassPhase2PokemonCard", abilities, trainer);
    }
}
