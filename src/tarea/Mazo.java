package tarea;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mazo {

    private static final String[] pokemones = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard"};

    private static final String[] energias = {"Planta", "Fuego", "Agua", "Rayo", "Lucha", "Psiquico"};

    public static Carta drawCard() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        if (true) { // CAMBIAR ESTE TRUE
            int pokemonDrawn = (int)(Math.random() * (pokemones.length));
            return (Carta) Class.forName("tarea." + pokemones[pokemonDrawn]).newInstance();
        } else {
            int energiaDrawn = (int)(Math.random() * (energias.length + 1));
            return (Carta) Class.forName("tarea." + energias[energiaDrawn]).newInstance();
        }
    }
}
