package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.types.PsychicType;

/**
 * Psychic Type pokemon class created for testing, represents a psychic pokemon.
 *
 * @author Juan Urrutia
 */
public class PsychicTypePokemon extends PsychicType {
    public PsychicTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}

    public PsychicTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 5, "PsychicTypePokemon", attack, trainer);
    }
}
