package tarea;

import java.io.PrintStream;

public class Bulbasaur extends Planta {

    public Bulbasaur(Entrenador entrenador) {
        super(45, new Attack[]{new ScratchAttack()}, entrenador);
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public String getName() {
        return "Bulbasaur";
    }
}
