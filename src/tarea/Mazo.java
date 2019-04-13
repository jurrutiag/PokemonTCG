package tarea;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mazo {

    private static final String[] pokemones = {"Pikachu"};
    private static final String[] energias = {"Planta"};

    public static Carta drawCard() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (Math.random() < 0.5) {
            int pokemonDrawn = (int)(Math.random() * (pokemones.length + 1));
            return (Carta) Class.forName(pokemones[pokemonDrawn]).newInstance();
        } else {
            int energiaDrawn = (int)(Math.random() * (energias.length + 1));
            return (Carta) Class.forName(energias[energiaDrawn]).newInstance();
        }
    }
}
