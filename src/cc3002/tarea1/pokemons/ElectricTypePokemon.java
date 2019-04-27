package cc3002.tarea1.pokemons;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.types.ElectricType;

public class ElectricTypePokemon extends ElectricType {

    public ElectricTypePokemon(Trainer trainer) {super(0, new Attack[] {}, trainer);}
    public ElectricTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, attack, trainer);
    }
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return "ElectricTypePokemon";
    }

}
