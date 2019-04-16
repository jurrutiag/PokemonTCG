package cc3002.tarea1;

import java.lang.reflect.InvocationTargetException;

public class Mazo {

    private static final String[] pokemones = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard"};

    private static final String[] energias = {"Planta", "Fuego", "Agua", "Rayo", "Lucha", "Psiquico"};

    public static Carta drawCard(Entrenador entrenador) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        if (true) { // CAMBIAR ESTE TRUE
            int pokemonDrawn = (int)(Math.random() * (pokemones.length));
            Class pokClass = Class.forName("cc3002.tarea1.pokemones." + pokemones[pokemonDrawn]);
            return (Carta) pokClass.getDeclaredConstructor(Entrenador.class).newInstance(entrenador);
        } else {
            int energiaDrawn = (int)(Math.random() * (energias.length + 1));
            return (Carta) Class.forName("cc3002.tarea1.pokemones." + energias[energiaDrawn]).newInstance();
        }
    }
}
