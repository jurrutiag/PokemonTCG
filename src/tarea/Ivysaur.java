package tarea;

import java.io.PrintStream;

public class Ivysaur extends Pokemon {

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int getHp() {
        return 60;
    }

    @Override
    public String getName() {
        return "Ivysaur";
    }
    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
