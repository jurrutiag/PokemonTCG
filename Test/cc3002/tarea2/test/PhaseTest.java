package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.phases.BasicPhase;
import cc3002.tarea2.game.cards.pokemon.phases.EvolvedPhase;
import cc3002.tarea2.game.cards.pokemon.pokemons.PhasePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhaseTest {

    private Trainer trainer1;
    private IPokemonCard basicPokemon;
    private IPokemonCard phaseOnePokemon;
    private IPokemonCard phaseTwoPokemon;

    @Before
    public void setUp() {
        trainer1 = new Trainer();

        basicPokemon = new PhasePokemonCard(trainer1, new BasicPhase(), 1);
        phaseOnePokemon = new PhasePokemonCard(trainer1, new EvolvedPhase(1), 2);
        phaseTwoPokemon = new PhasePokemonCard(trainer1, new EvolvedPhase(2), 3);
    }

    @Test
    public void testEvolution() {
        trainer1.addCard(phaseOnePokemon);
        trainer1.addCard(phaseTwoPokemon);
        trainer1.addCard(basicPokemon);

        trainer1.playCard(0);
        assertEquals(0, trainer1.getBench().size());

        trainer1.playCard(1);
        assertEquals(0, trainer1.getBench().size());

        trainer1.playCard(2);
        assertEquals(1, trainer1.getBench().size());

        trainer1.playCard(1);
        assertEquals(1, trainer1.getBench().size());
        assertEquals(basicPokemon, trainer1.getBench().get(0));

        trainer1.playCard(0);
        assertEquals(1, trainer1.getBench().size());
        assertEquals(phaseOnePokemon, trainer1.getBench().get(0));

        trainer1.playCard(0);
        assertEquals(1, trainer1.getBench().size());
        assertEquals(phaseTwoPokemon, trainer1.getBench().get(0));
    }

    @Test
    public void testEnergyPassing() {
        basicPokemon.addElectricEnergy();
        basicPokemon.addFightingEnergy();

        trainer1.addCard(basicPokemon);
        trainer1.playCard(0);

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(basicPokemon, trainer1.getActivePokemon());

        trainer1.addCard(phaseOnePokemon);
        trainer1.playCard(0);

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(phaseOnePokemon, trainer1.getActivePokemon());

        trainer1.addCard(phaseTwoPokemon);
        trainer1.playCard(0);

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(phaseTwoPokemon, trainer1.getActivePokemon());
    }
}
