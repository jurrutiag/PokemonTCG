package cc3002.tarea1.pokemons;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Trainer;
import cc3002.tarea1.types.FightingType;

public class FightingTypePokemon extends FightingType {

    public FightingTypePokemon(int hp, Attack[] attack, Trainer trainer) {
        super(hp, attack, trainer);
    }
    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return "FightingTypePokemon";
    }
}