package cc3002.tarea1.pokemones;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.tipos.Fuego;
import cc3002.tarea1.ScratchAttack;

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
