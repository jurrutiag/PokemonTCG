package tarea;

import java.io.PrintStream;

public class Charmeleon extends Pokemon {
    @Override
    public int getHp() {
        return 58;
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public String getName() {
        return "Charmeleon";
    }
    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
