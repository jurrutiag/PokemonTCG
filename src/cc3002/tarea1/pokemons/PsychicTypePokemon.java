package cc3002.tarea1.pokemons;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.types.PsychicType;

public class PsychicTypePokemon extends PsychicType {

    public PsychicTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, attack, trainer);
    }
    @Override
    public int getId() {
        return 5;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return "PsychicTypePokemon";
    }
}
