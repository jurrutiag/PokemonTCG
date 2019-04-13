package tarea;

import java.io.PrintStream;

public class Venusaur extends Planta {

    public Venusaur() {
        super(80, new Attack[]{new ScratchAttack()});
    }

    @Override
    public int getHp() {
        return super.getHp();
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
