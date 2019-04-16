package cc3002.tarea1.pokemones;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.tipos.Fuego;
import cc3002.tarea1.ScratchAttack;

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
