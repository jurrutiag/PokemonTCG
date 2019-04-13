package tarea;

import java.io.PrintStream;

public class Ivysaur extends Planta {

    public Ivysaur(Entrenador entrenador){
        super(60, new Attack[]{new ScratchAttack()}, entrenador);
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
}
