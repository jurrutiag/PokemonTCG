package tarea;

import java.io.PrintStream;

public class Venusaur extends Pokemon {

    @Override
    public int getHp() {
        return 80;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getName() {
        return "Venusaur";
    }
    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
