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

    private PrintStream out;

    private int turno;
    private boolean finished;

    public Juego() throws ReflectiveOperationException {
        turno = Math.random() < 0.5 ? 1 : 2;

        out = System.out;

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

    public void jugar() {

        siguienteTurno();

        setUpEntrenadorActivo();

        siguienteTurno();

        setUpEntrenadorActivo();

        while (!finished) {
            siguienteTurno();
            jugadaEntrenadorActivo();
        }

    }

    public void siguienteTurno() {
        if (turno == 1) {
            this.entrenadorActivo = entrenador2;
            this.entradaActiva = entradaJugador2;
            turno = 2;
        } else {
            this.entrenadorActivo = entrenador1;
            this.entradaActiva = entradaJugador1;
            turno = 1;
        }
        out.printf("|| Turno de Jugador %s... ||\n", turno);
    }

    public void setUpEntrenadorActivo() {

        out.printf("\tSeleccione su pokemon activo:\n");

        entrenadorActivo.listarCartasMano(out, "\t\t%s");

        int cartaSeleccionada = entradaActiva.nextInt() - 1;
        if (entrenadorActivo.getCartaMano(cartaSeleccionada).esSeleccionableActiva()) {
            entrenadorActivo.setPokemonActivo(cartaSeleccionada);
            out.printf("\tHas seleccionado a: \n\t");
            entrenadorActivo.getPokemonActivo().printCardInfo(out);
            out.println("\n");
        } else {
            out.println("\tCarta no seleccionable como activa...");
            setUpEntrenadorActivo();
        }


    }

    private void jugadaEntrenadorActivo() {
        out.printf("\tPokemon Activo -- ");
        entrenadorActivo.getPokemonActivo().printCardInfo(out);
        out.printf("\tSeleccionar jugada: \n");
        out.printf("\t\t1 -- Atacar...\n");
        out.printf("\t\t2 -- Informacion de pokemon activo...\n");
        out.printf("\t\t3 -- Listar cartas en la mano...\n");
        out.printf("\t\t4 -- Listar cartas en la banca...\n");

        int opcion = entradaActiva.nextInt();

        switch  (opcion) {
            case 1:
                jugadorActivoAtaca(out);
                break;
            case 2:
                entrenadorActivo.getPokemonActivo().printCardInfo(out);
                jugadaEntrenadorActivo();
                break;
            case 3:
                entrenadorActivo.listarCartasMano(out, "\t\t %s");
                jugadaEntrenadorActivo();
                break;
            case 4:
                entrenadorActivo.listarCartasBanca(out, "\t\t %s");
                jugadaEntrenadorActivo();
                break;
        }
    }

    private void jugadorActivoAtaca(PrintStream out) {
        out.println("\tSeleccione ataque:");

        entrenadorActivo.listarAtaquesPosibles(out, "\t\t%s");

        int opcion = entradaActiva.nextInt() - 1;
        entrenadorActivo.pokemonActivoAtaca(opcion);

        out.printf(">> -- P%s: %s ataca a P%s: %s -- <<\n", turno, entrenadorActivo.getPokemonActivo().getName(), (turno % 2) + 1, entrenadorActivo.getContrincante().getPokemonActivo().getName());
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Juego juego = new Juego();
        juego.jugar();
    }

    public PrintStream getOutput() {
        return out;
    }

    public int getTurno() {
        return turno;
    }
}
