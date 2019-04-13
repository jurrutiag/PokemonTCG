package tarea;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class Entrenador {

    private ArrayList<Carta> mano;
    private ArrayList<Carta> banca;
    private int pokemonActivo;

    private Juego juego;
    private Entrenador contrincante;


    public Entrenador(Juego juego) throws ReflectiveOperationException {
        this.juego = juego;

        mano = new ArrayList<Carta>();
        banca = new ArrayList<Carta>();

        for (int i = 0; i < 7; i++) {
            mano.add(Mazo.drawCard(this));
        }
    }

    public Juego getJuego() {
        return juego;
    }

    public void setPokemonActivo(int indiceMano) {
        banca.add(mano.get(indiceMano));
    }

    public Entrenador getContrincante() {
        return contrincante;
    }

    public void swapPokemonActivo(int indiceBanca) {
        Collections.swap(banca, 0, indiceBanca);
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

    public void listarCartas(PrintStream out, ArrayList<Carta> cartas, String format) {
        // new PrintStream(new NullOutputStream());
        for (int i = 0; i < cartas.size(); i++) {
            out.printf(format, String.format("%d -- ", i + 1));
            cartas.get(i).printCardInfo(out);
        }
    }

    public void listarCartasMano(PrintStream out, String format) {
        listarCartas(out, mano, format);
    }

    public void listarCartasBanca(PrintStream out, String format) {
        listarCartas(out, banca, format);
    }

    public Carta getCartaMano(int cartaSeleccionada) {
        return mano.get(cartaSeleccionada);
    }

    public Carta getCartaBanca(int cartaSeleccionada) {
        return banca.get(cartaSeleccionada);
    }

    public void listarAtaquesPosibles(PrintStream out, String format) {
        getPokemonActivo().listarAtaques(out, format);
    }

}
