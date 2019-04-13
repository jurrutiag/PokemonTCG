package tarea;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Entrenador {

    private ArrayList<Carta> banca;
    private int pokemonActivo;
    private Scanner entrada;
    private Juego juego;


    public Entrenador(Scanner in, Juego juego) throws ReflectiveOperationException {
        entrada = in;
        this.juego = juego;

        banca = new ArrayList<Carta>();
        for (int i = 0; i <= 7; i++) {
            banca.add(Mazo.drawCard());
        }
    }

    public void setPokemonActivo(PrintStream out) {
        out.println("Seleccione su pokemon activo:\n");
        listarCartas(out);
        int cartaSeleccionada = entrada.nextInt();
        if (banca.get(cartaSeleccionada).esSeleccionableActiva()) {
            Collections.swap(banca, 0, cartaSeleccionada);
        } else {
            out.println("Esta carta no puede ser seleccionada como pokemon activo...");
            this.setPokemonActivo(out);
        }
    }

    public int bancaSize() {
        return banca.size();
    }

    public Pokemon getPokemonActivo() {
        return (Pokemon) banca.get(0);
    }

    public void pokemonActivoAtaca(int attackNum) {
        getPokemonActivo().attack(attackNum);
    }

    public void listarCartas(PrintStream out) {
        // new PrintStream(new NullOutputStream());
        for (int i = 0; i < banca.size(); i++) {
            banca.get(i).printCardInfo(out);
        }
    }
}
