package tarea;

import java.io.PrintStream;

public class Charmander extends Pokemon {
    @Override
    public int getHp() {
        return 39;
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
