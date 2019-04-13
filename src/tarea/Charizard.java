package tarea;

import java.io.PrintStream;

public class Charizard extends Fuego {

    public Charizard(Entrenador entrenador) {
        super(78, new Attack[]{new ScratchAttack()}, entrenador);
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

}
