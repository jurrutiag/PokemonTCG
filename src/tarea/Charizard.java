package tarea;

import java.io.PrintStream;

public class Charizard extends Pokemon {
    @Override
    public int getHp() {
        return 78;
    }

    @Override
    public int getId() {
        return 6;
    }

    @Override
    public String getName() {
        return "Charizard";
    }

    @Override
    public void printCardInfo(PrintStream out) {
        printPokemonInfo(getHp(), getId(), getName(), out);
    }
}
