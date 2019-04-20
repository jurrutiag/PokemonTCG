package cc3002.tarea1.pokemons;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.types.FireType;

public class FireTypePokemon extends FireType {


    public FireTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, attack, trainer);
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getName() {
        return "FireTypePokemon";
    }
}
