package tarea;

import java.io.PrintStream;

public class Charmander extends Fuego {


    public Charmander() {
        super(39, new Attack[]{new ScratchAttack()});
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public String getName() {
        return "Charmander";
    }
    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
