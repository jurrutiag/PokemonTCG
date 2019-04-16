package cc3002.tarea1.pokemones;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.tipos.Planta;
import cc3002.tarea1.ScratchAttack;

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
