package cc3002.tarea1.pokemons;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.types.GrassType;

public class GrassTypePokemon extends GrassType {
    public GrassTypePokemon(Trainer trainer) {super(0, new Attack[] {}, trainer);}

    public GrassTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, attack, trainer);
    }
    @Override
    public int getId() {
        return 4;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return "GrassTypePokemon";
    }
}
