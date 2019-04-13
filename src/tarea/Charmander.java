package tarea;

import java.io.PrintStream;

public class Charmander extends Fuego {


    public Charmander(Entrenador entrenador) {
        super(39, new Attack[]{new ScratchAttack()}, entrenador);
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public String getName() {
        return "Charmander";
    }
}
