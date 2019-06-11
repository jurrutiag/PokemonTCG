package cc3002.tarea2.game.cards.pokemon.implemented_pokemons;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.pokemon.types.phases.base.GrassBasePokemon;

/**
 * Grass Type pokemon class created for testing, represents a grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassTypePokemonCard extends GrassBasePokemon {
    public GrassTypePokemonCard(Trainer trainer) {this(10, 4, new IAttack[] {}, trainer);}

    public GrassTypePokemonCard(int hp, IAttack[] attack, Trainer trainer) {
        this(hp, 4, attack, trainer);
    }

    public GrassTypePokemonCard(int hp, int id, IAttack[] attack, Trainer trainer) {
        super(hp, id, "GrassTypePokemonCard", attack, trainer);
    }
}
