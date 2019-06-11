package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.BasicPokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.Phase1PokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.Phase2PokemonCard;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhaseTest {

    private Trainer trainer1;
    private IBasicPokemon basicPokemon;
    private IPhase1Pokemon phaseOnePokemon;
    private IPhase2Pokemon phaseTwoPokemon;

    @Before
    public void setUp() {
        trainer1 = new Trainer();

        basicPokemon = new BasicPokemonCard(trainer1);
        phaseOnePokemon = new Phase1PokemonCard(trainer1);
        phaseTwoPokemon = new Phase2PokemonCard(trainer1);
    }

    @Test
    public void testEvolution() {
        trainer1.addCard(phaseOnePokemon);
        trainer1.addCard(phaseTwoPokemon);
        trainer1.addCard(basicPokemon);

        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertEquals(0, trainer1.getBench().size());

        trainer1.selectHandCard(1);
        trainer1.playCard();
        assertEquals(0, trainer1.getBench().size());

        trainer1.selectHandCard(2);
        trainer1.playCard();
        assertEquals(1, trainer1.getBench().size());


        trainer1.selectHandCard(1);
        trainer1.playCard();
        assertEquals(1, trainer1.getBench().size());
        assertEquals(basicPokemon, trainer1.getBench().get(0));

        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertEquals(1, trainer1.getBench().size());
        assertEquals(phaseOnePokemon, trainer1.getBench().get(0));

        trainer1.selectHandCard(0);
        trainer1.playCard();
        assertEquals(1, trainer1.getBench().size());
        assertEquals(phaseTwoPokemon, trainer1.getBench().get(0));
    }

    @Test
    public void testEnergyPassing() {
        basicPokemon.addElectricEnergy();
        basicPokemon.addFightingEnergy();

        trainer1.addCard(basicPokemon);
        trainer1.playCard();

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(basicPokemon, trainer1.getActivePokemon());

        trainer1.addCard(phaseOnePokemon);
        trainer1.playCard();

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(phaseOnePokemon, trainer1.getActivePokemon());

        trainer1.addCard(phaseTwoPokemon);
        trainer1.playCard();

        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getElectricEnergies());
        assertEquals(1, trainer1.getActivePokemon().getEnergySet().getFightingEnergies());
        assertEquals(phaseTwoPokemon, trainer1.getActivePokemon());
    }
}
