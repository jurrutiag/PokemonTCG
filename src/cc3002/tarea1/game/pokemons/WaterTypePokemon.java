package cc3002.tarea1.game.pokemons;

import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.types.WaterType;

public class WaterTypePokemon extends WaterType {

    public WaterTypePokemon(Trainer trainer) {this(0, new Attack[] {}, trainer);}

    public WaterTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, 6, "WaterTypePokemon", attack, trainer);
    }
}
