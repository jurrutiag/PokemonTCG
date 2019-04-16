package cc3002.tarea1;

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

        while (cartaSeleccionada != -1) {

            if (entrenadorActivo.getCartaMano(cartaSeleccionada).esSeleccionableActiva()) {
                entrenadorActivo.setPokemonActivo(cartaSeleccionada, out, "\t\t\t%s\n");
            } else {
                out.println("\tLa carta no es un pokemon...");
                setUpEntrenadorActivo();
            }

            out.printf("\tSeleccione pokemon para ingresar a su banca\n");
            out.printf("\t\t0 -- Atras\n");

            entrenadorActivo.listarCartasMano(out, "\t\t%s");

            cartaSeleccionada = entradaActiva.nextInt() - 1;
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
        out.printf("\t\t5 -- Cambiar pokemon activo...\n");
        out.printf("\t\t6 -- Pasar...\n");

        int opcion = entradaActiva.nextInt();

        switch (opcion) {
            case 1:
                opcionJugadorActivoAtaca();
                break;
            case 2:
                opcionPokemonActivoInfo();
                break;
            case 3:
                opcionListarMano();
                break;
            case 4:
                opcionListarBanca();
                break;
            case 5:
                swapPokemonEntrenador();
                break;
            case 6:
                opcionPasar();
                break;
            default:
                out.printf("\t\tSeleccione opcion valida...\n");
                jugadaEntrenadorActivo();
                break;
        }

    }

    private void swapPokemonEntrenador() {
        out.printf("\t\tSeleccionar pokemon:\n");
        entrenadorActivo.listarCartasBanca(out, "\t\t\t%s");

        int opcion = entradaActiva.nextInt();

        if (entrenadorActivo.getCartaBanca(opcion).getHp() == 0) {
            out.printf("\tNo puede seleccionar un Pokemon con 0 HP...\n");
            swapPokemonEntrenador();
            return;
        }

        entrenadorActivo.swapPokemonActivo(opcion);

        out.printf("\t\tSeleccionar Jugada\n");
        out.printf("\t\t\t0 -- Pasar\n");
        out.printf("\t\t\t1 -- Atacar\n");

        opcion  = entradaActiva.nextInt() - 1;

        if (opcion == 0) {
            opcionJugadorActivoAtaca();
        } else {
            opcionPasar();
        }

    }

    private void opcionJugadorActivoAtaca() {
        out.println("\tSeleccione ataque:");

        entrenadorActivo.listarAtaquesPosibles(out, "\t\t%s");

        int opcion = entradaActiva.nextInt() - 1;
        if (opcion > entrenadorActivo.maxNumAtaques()) {
            out.printf("\tPor favor ingrese un ataque valido...\n");
            opcionJugadorActivoAtaca();
        }

        out.printf(">> -- P%s: %s ataca a P%s: %s -- <<\n", turno, entrenadorActivo.getPokemonActivo().getName(), (turno % 2) + 1, entrenadorActivo.getContrincante().getPokemonActivo().getName());
        entrenadorActivo.pokemonActivoAtaca(opcion);

    }

    private void opcionPokemonActivoInfo() {
        entrenadorActivo.getPokemonActivo().printCardInfo(out);
        jugadaEntrenadorActivo();
    }

    private void opcionListarMano() {
        out.printf("\t\tCartas en la mano:\n");
        entrenadorActivo.listarCartasMano(out, "\t\t%s");
        jugadaEntrenadorActivo();
    }

    private void opcionListarBanca() {
        out.printf("\t\tPokemones en la banca:\n");
        entrenadorActivo.listarCartasBanca(out, "\t\t%s");
        jugadaEntrenadorActivo();
    }

    private void opcionPasar() {
        out.printf("Has pasado...");
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
