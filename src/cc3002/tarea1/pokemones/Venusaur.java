package cc3002.tarea1.pokemones;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.tipos.Planta;
import cc3002.tarea1.ScratchAttack;

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
