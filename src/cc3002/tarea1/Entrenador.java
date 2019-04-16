package cc3002.tarea1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class Entrenador {

    private ArrayList<Carta> mano;
    private ArrayList<Pokemon> banca;
    private int pokemonActivo;

    private Juego juego;
    private Entrenador contrincante;


    public Entrenador(Juego juego) throws ReflectiveOperationException {
        this.juego = juego;

        mano = new ArrayList<Carta>();
        banca = new ArrayList<Pokemon>();

        for (int i = 0; i < 7; i++) {
            mano.add(Mazo.drawCard(this));
        }
    }

    public Juego getJuego() {
        return juego;
    }

    public void setPokemonActivo(int indiceMano, PrintStream out, String format) {
        if (banca.size() == 6) {
            out.printf(format, "Banca llena...");
            return;
        }
        banca.add((Pokemon) mano.get(indiceMano));
        mano.remove(indiceMano);
        out.printf("\tHas seleccionado a: \n\t");
        getPokemonActivo().printCardInfo(out);
        out.println("\n");
    }

    public Entrenador getContrincante() {
        return contrincante;
    }

    public void swapPokemonActivo(int indiceBanca) {
        Collections.swap(banca, 0, indiceBanca);
    }

    public void swapNextNotDead() {
        for (int i = 1; i < banca.size(); i++) {
            if (banca.get(i).getHp() != 0) {
                swapPokemonActivo(i);
            }
        }
    }

    public void setContrincante(Entrenador contrincante) {
        this.contrincante = contrincante;
    }

    public int bancaSize() {
        return banca.size();
    }

    public Pokemon getPokemonActivo() {
        return (Pokemon) banca.get(0);
    }

    public void pokemonActivoAtaca(int attackNum) {
        getPokemonActivo().attack(attackNum, contrincante);
    }

    public void listarCartasMano(PrintStream out, String format) {
        // new PrintStream(new NullOutputStream());
        for (int i = 0; i < mano.size(); i++) {
            out.printf(format, String.format("%d -- ", i + 1));
            mano.get(i).printCardInfo(out);
        }
    }

    public void listarCartasBanca(PrintStream out, String format) {
        for (int i = 1; i < banca.size(); i++) {
            out.printf(format, String.format("%d -- ", i));
            banca.get(i).printCardInfo(out);
        }
    }

    public Carta getCartaMano(int cartaSeleccionada) {
        return mano.get(cartaSeleccionada);
    }

    public Pokemon getCartaBanca(int cartaSeleccionada) {
        return banca.get(cartaSeleccionada);
    }

    public void listarAtaquesPosibles(PrintStream out, String format) {
        getPokemonActivo().listarAtaques(out, format);
    }

    public int maxNumAtaques() {
        return getPokemonActivo().getCantidadAtaques();
    }
}
