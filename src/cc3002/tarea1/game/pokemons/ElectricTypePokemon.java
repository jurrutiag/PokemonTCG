package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.types.ElectricType;

/**
 * Electric Type pokemon class created for testing, represents an electric pokemon.
 *
 * @author Juan Urrutia
 */
public class ElectricTypePokemon extends ElectricType {

    public ElectricTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}
    public ElectricTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 1, "ElectricTypePokemon", attack, trainer);
    }

}
