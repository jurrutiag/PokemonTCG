package test;

import tarea.Entrenador;
import tarea.NullOutputStream;

import java.io.PrintStream;

public class EntrenadorTest {

    Entrenador entrenador1;
    Entrenador entrenador2;

    @Before
    public void setUp() {
        entrenador1 = new Entrenador();
        entrenador2 = new Entrenador(System.in);
    }

    @Test
    public void maxPokemonesEnBanca() {
        AssertTrue(entrenador1.bancaSize() <= 5);
    }

    @Test
    public void usarHabilidadDePokemon() {
        if (entrenador1.getPokemonActivo().hasAbility(1)) {
            entrenador1.pokemonActivoAtaca(1);
        }
        if (entrenador1.getPokemonActivo().hasAbility(2)) {
            entrenador1.pokemonActivoAtaca(2);
        }
        if (entrenador1.getPokemonActivo().hasAbility(3)) {
            entrenador1.pokemonActivoAtaca(3);
        }
        if (entrenador1.getPokemonActivo().hasAbility(4)) {
            entrenador1.pokemonActivoAtaca(4);
        }
    }

    @Test
    public void verCartas() {
        entrenador1.listarCartas(new PrintStream(new NullOutputStream()));
    }
}
