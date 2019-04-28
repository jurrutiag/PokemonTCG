package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.types.FireType;


/**
 * Fire Type pokemon class created for testing, represents a fire pokemon.
 *
 * @author Juan Urrutia
 */
public class FireTypePokemon extends FireType {

    public FireTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}

    public FireTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 3, "FireTypePokemon", attack, trainer);
    }
}
