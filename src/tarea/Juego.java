package tarea;

import java.util.Scanner;

public class Juego {

    private Scanner entradaJugador1;
    private Scanner entradaJugador2;
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Juego() {
        entradaJugador1 = new Scanner(System.in);
        entradaJugador2 = new Scanner(System.in);

        entrenador1 = new Entrenador(entradaJugador1);
        entrenador2 = new Entrenador(entradaJugador1);
    }

}
