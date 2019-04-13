package tarea;

import java.io.PrintStream;

public class Ivysaur extends Planta {

    public Ivysaur(){
        super(60, new Attack[]{new ScratchAttack()});
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int getHp() {
        return super.getHp();
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
