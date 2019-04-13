package tarea;

import java.io.PrintStream;

public class Venusaur extends Planta {

    public Venusaur(Entrenador entrenador) {
        super(80, new Attack[]{new ScratchAttack()}, entrenador);
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
}
