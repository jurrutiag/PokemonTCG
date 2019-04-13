package tarea;

import java.io.PrintStream;

public class Charmeleon extends Fuego {

    public Charmeleon() {
        super(58, new Attack[]{new ScratchAttack()});
    }

    @Override
    public int getHp() {
        return super.getHp();
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
