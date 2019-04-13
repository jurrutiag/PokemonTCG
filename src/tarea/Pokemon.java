package tarea;

import java.io.PrintStream;

public abstract class Pokemon implements Carta {

    public abstract int getHp();

    public abstract int getId();

    @Override
    public boolean esSeleccionableActiva() {
        return true;
    }

    public void printPokemonInfo(int hp, int id, String name, PrintStream out) {
        out.printf("Nombre: %s, id: %d, Vida: %d\n", name, id, hp);
    }

    public abstract void attack(int attackNum);
}
