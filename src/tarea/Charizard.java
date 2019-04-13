package tarea;

import java.io.PrintStream;

public class Charizard extends Fuego {

    public Charizard() {
        super(78, new Attack[]{new ScratchAttack()});
    }

    @Override
    public int getHp() {
        return super.getHp();
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
