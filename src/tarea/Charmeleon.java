package tarea;

import java.io.PrintStream;

public class Charmeleon extends Fuego {

    public Charmeleon(Entrenador entrenador) {
        super(58, new Attack[]{new ScratchAttack()}, entrenador);
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
}
