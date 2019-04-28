package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.types.GrassType;

/**
 * Grass Type pokemon class created for testing, represents a grass pokemon.
 *
 * @author Juan Urrutia
 */
public class GrassTypePokemon extends GrassType {
    public GrassTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}

    public GrassTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 4, "GrassTypePokemon", attack, trainer);
    }
}
