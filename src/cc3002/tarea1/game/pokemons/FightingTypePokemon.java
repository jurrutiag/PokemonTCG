package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.types.FightingType;

/**
 * Fighting Type pokemon class created for testing, represents a fighting pokemon.
 *
 * @author Juan Urrutia
 */
public class FightingTypePokemon extends FightingType {

    public FightingTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}

    public FightingTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 2, "FightingTypePokemon", attack, trainer);
    }
}
