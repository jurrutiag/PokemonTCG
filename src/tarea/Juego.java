package tarea;

import java.io.PrintStream;
import java.util.Scanner;

public class Juego {

    private Scanner entradaJugador1;
    private Scanner entradaJugador2;
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    private int turno;

    public Juego() throws ReflectiveOperationException {
        turno = Math.random() < 0.5 ? 1 : 2;

        entradaJugador1 = new Scanner(System.in);
        entradaJugador2 = new Scanner(System.in);

        entrenador1 = new Entrenador(entradaJugador1, this);
        entrenador2 = new Entrenador(entradaJugador1, this);
    }

    public void start(PrintStream out) {
        out.println("Turno de Jugador 1...");
        entrenador1.setPokemonActivo(out);

        out.println("Turno de Jugador 2...");
        entrenador2.setPokemonActivo(out);
    }

}
