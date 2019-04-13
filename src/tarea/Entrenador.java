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
        for (int i = 0; i < 7; i++) {
            mano.add(Mazo.drawCard());
        }
    }

    public void setPokemonActivo(int indiceMano) {
        banca.add(0, mano.get(indiceMano));
    }

    public void swapPokemonActivo(int indiceBanca) {
        Collections.swap(banca, 0, indiceBanca);
    }

    public void setContrincante(Entrenador contrincante) {
        this.contrincante = contrincante;
    }

    public int bancaSize() {
        return mano.size();
    }

    public Pokemon getPokemonActivo() {
        return (Pokemon) mano.get(0);
    }

    public void pokemonActivoAtaca(int attackNum) {
        getPokemonActivo().attack(attackNum, contrincante.getPokemonActivo());
    }

    public void listarCartas(PrintStream out, ArrayList<Carta> cartas) {
        // new PrintStream(new NullOutputStream());
        for (int i = 0; i < mano.size(); i++) {
            out.printf("%d -- ", i + 1);
            mano.get(i).printCardInfo(out);
        }
    }

    public void listarCartasMano(PrintStream out) {
        listarCartas(out, mano);
    }

    public void listarCartasBanca(PrintStream out) {
        listarCartas(out, banca);
    }

    public Carta getCartaMano(int cartaSeleccionada) {
        return mano.get(cartaSeleccionada);
    }

    public Carta getCartaBanca(int cartaSeleccionada) {
        return banca.get(cartaSeleccionada);
    }

    public void listarAtaquesPosibles(PrintStream out) {
        getPokemonActivo().listarAtaques(out);
    }

}
