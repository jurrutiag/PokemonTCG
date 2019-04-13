package tarea;

import java.io.PrintStream;

public class Bulbasaur extends Planta {

    public Bulbasaur() {
        super(45, new Attack[]{new ScratchAttack()});
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
        return "Bulbasaur";
    }

    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
