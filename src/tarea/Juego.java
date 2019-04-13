package tarea;

import java.io.PrintStream;
import java.util.Scanner;

public class Juego {

    private Scanner entradaJugador1;
    private Scanner entradaJugador2;
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    private Entrenador entrenadorActivo;
    private Scanner entradaActiva;

    private int turno;
    private boolean finished;

    public Juego() throws ReflectiveOperationException {
        turno = Math.random() < 0.5 ? 1 : 2;

        finished = false;

        entradaJugador1 = new Scanner(System.in);
        entradaJugador2 = new Scanner(System.in);

        entrenador1 = new Entrenador(this);
        entrenador2 = new Entrenador(this);

        entrenador1.setContrincante(entrenador2);
        entrenador2.setContrincante(entrenador1);

        turno = 0;

        this.entrenadorActivo = entrenador1;
        this.entradaActiva = entradaJugador1;
    }

    public void jugar(PrintStream out) {

        siguienteTurno(out);

        setUpEntrenadorActivo(out);

        siguienteTurno(out);

        setUpEntrenadorActivo(out);

        while (!finished) {
            jugadaEntrenadorActivo(out);
        }

    }

    public void siguienteTurno(PrintStream out) {
        if (turno == 1) {
            this.entrenadorActivo = entrenador2;
            this.entradaActiva = entradaJugador2;
            turno = 2;
        } else {
            this.entrenadorActivo = entrenador1;
            this.entradaActiva = entradaJugador1;
            turno = 1;
        }
        out.printf("Turno de Jugador %s...\n", turno);
    }

    public void setUpEntrenadorActivo(PrintStream out) {

        out.println("Seleccione su pokemon activo:\n");

        entrenadorActivo.listarCartasMano(out);

        int cartaSeleccionada = entradaActiva.nextInt() - 1;
        if (entrenadorActivo.getCartaMano(cartaSeleccionada).esSeleccionableActiva()) {
            entrenadorActivo.setPokemonActivo(cartaSeleccionada);
            out.println("Haz seleccionado a: ");
            entrenadorActivo.getPokemonActivo().printCardInfo(out);
            out.println("\n");
        } else {
            out.println("Carta no seleccionable como activa...");
            setUpEntrenadorActivo(out);
        }


    }

    private void jugadaEntrenadorActivo(PrintStream out) {
        out.println("Seleccionar jugada: ");
        out.println("1 -- Atacar...");
        out.println("2 -- Listar cartas...");

        int opcion = entradaActiva.nextInt();

        switch  (opcion) {
            case 1:
               jugadorActivoAtaca(out);
               break;
        }
    }

    private void jugadorActivoAtaca(PrintStream out) {
        out.println("Seleccione ataque:");

        entrenadorActivo.listarAtaquesPosibles(out);

        int opcion = entradaActiva.nextInt();
        entrenadorActivo.pokemonActivoAtaca(opcion);
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Juego juego = new Juego();
        juego.jugar(System.out);
    }

}
