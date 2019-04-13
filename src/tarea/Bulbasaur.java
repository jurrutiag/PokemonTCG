package tarea;

import java.io.PrintStream;

public class Bulbasaur extends Pokemon {

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public int getHp() {
        return 45;
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
