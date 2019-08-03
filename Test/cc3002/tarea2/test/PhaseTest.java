package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.*;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase1.*;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.phase2.*;
import cc3002.tarea2.game.cards.pokemon.types.phases.IBasicPokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase1Pokemon;
import cc3002.tarea2.game.cards.pokemon.types.phases.IPhase2Pokemon;
import cc3002.tarea2.game.exceptions.PokemonWithoutPreevolutionPlayedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhaseTest {

    private Trainer trainer1;
    private IBasicPokemon basicPokemon;
    private IPhase1Pokemon phaseOnePokemon;
    private IPhase2Pokemon phaseTwoPokemon;

    private ElectricTypePokemonCard electricBasicPokemon;
    private FightingTypePokemonCard fightingBasicPokemon;
    private FireTypePokemonCard fireBasicPokemon;
    private GrassTypePokemonCard grassBasicPokemon;
    private PsychicTypePokemonCard psychicBasicPokemon;
    private WaterTypePokemonCard waterBasicPokemon;

    private ElectricPhase1PokemonCard electricPhase1Pokemon;
    private FightingPhase1PokemonCard fightingPhase1Pokemon;
    private FirePhase1PokemonCard firePhase1Pokemon;
    private GrassPhase1PokemonCard grassPhase1Pokemon;
    private PsychicPhase1PokemonCard psychicPhase1Pokemon;
    private WaterPhase1PokemonCard waterPhase1Pokemon;

    private ElectricPhase2PokemonCard electricPhase2PokemonCard;
    private FightingPhase2PokemonCard fightingPhase2PokemonCard;
    private FirePhase2PokemonCard firePhase2PokemonCard;
    private GrassPhase2PokemonCard grassPhase2PokemonCard;
    private PsychicPhase2PokemonCard psychicPhase2PokemonCard;
    private WaterPhase2PokemonCard waterPhase2PokemonCard;


    @Before
    public void setUp() {
        trainer1 = new Trainer();

        basicPokemon = new ElectricTypePokemonCard(trainer1);
        phaseOnePokemon = new ElectricPhase1PokemonCard(trainer1);
        phaseTwoPokemon = new ElectricPhase2PokemonCard(trainer1);

        electricBasicPokemon = new ElectricTypePokemonCard(trainer1);
        fightingBasicPokemon = new FightingTypePokemonCard(trainer1);
        fireBasicPokemon = new FireTypePokemonCard(trainer1);
        grassBasicPokemon = new GrassTypePokemonCard(trainer1);
        psychicBasicPokemon = new PsychicTypePokemonCard(trainer1);
        waterBasicPokemon = new WaterTypePokemonCard(trainer1);
        electricPhase1Pokemon = new ElectricPhase1PokemonCard(trainer1);
        fightingPhase1Pokemon = new FightingPhase1PokemonCard(trainer1);
        firePhase1Pokemon = new FirePhase1PokemonCard(trainer1);
        grassPhase1Pokemon = new GrassPhase1PokemonCard(trainer1);
        psychicPhase1Pokemon = new PsychicPhase1PokemonCard(trainer1);
        waterPhase1Pokemon = new WaterPhase1PokemonCard(trainer1);
        electricPhase2PokemonCard = new ElectricPhase2PokemonCard(trainer1);
        fightingPhase2PokemonCard = new FightingPhase2PokemonCard(trainer1);
        firePhase2PokemonCard = new FirePhase2PokemonCard(trainer1);
        grassPhase2PokemonCard = new GrassPhase2PokemonCard(trainer1);
        psychicPhase2PokemonCard = new PsychicPhase2PokemonCard(trainer1);
        waterPhase2PokemonCard = new WaterPhase2PokemonCard(trainer1);

    }

    @Test
    public void testEvolution() throws Exception {
        trainer1.addCard(electricPhase1Pokemon);
        trainer1.addCard(electricPhase2PokemonCard);
        trainer1.addCard(electricBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(electricBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(electricPhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(electricPhase2PokemonCard, trainer1.getBench().get(0));

        trainer1.clearBench();

        trainer1.addCard(fightingPhase1Pokemon);
        trainer1.addCard(fightingPhase2PokemonCard);
        trainer1.addCard(fightingBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(fightingBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(fightingPhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(fightingPhase2PokemonCard, trainer1.getBench().get(0));

        trainer1.clearBench();

        trainer1.addCard(firePhase1Pokemon);
        trainer1.addCard(firePhase2PokemonCard);
        trainer1.addCard(fireBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(fireBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(firePhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(firePhase2PokemonCard, trainer1.getBench().get(0));

        trainer1.clearBench();

        trainer1.addCard(grassPhase1Pokemon);
        trainer1.addCard(grassPhase2PokemonCard);
        trainer1.addCard(grassBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(grassBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(grassPhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(grassPhase2PokemonCard, trainer1.getBench().get(0));

        trainer1.clearBench();

        trainer1.addCard(psychicPhase1Pokemon);
        trainer1.addCard(psychicPhase2PokemonCard);
        trainer1.addCard(psychicBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(psychicBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(psychicPhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(psychicPhase2PokemonCard, trainer1.getBench().get(0));

        trainer1.clearBench();

        trainer1.addCard(waterPhase1Pokemon);
        trainer1.addCard(waterPhase2PokemonCard);
        trainer1.addCard(waterBasicPokemon);

        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(0, trainer1.getBench().size());
        trainer1.selectHandCard(2);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        trainer1.selectHandCard(1);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(waterBasicPokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(waterPhase1Pokemon, trainer1.getBench().get(0));
        trainer1.selectHandCard(0);
        try {trainer1.playCard();} catch (PokemonWithoutPreevolutionPlayedException e) {}
        assertEquals(1, trainer1.getBench().size());
        assertEquals(waterPhase2PokemonCard, trainer1.getBench().get(0));

    }

    @Test
    public void testEnergyPassing() throws Exception {
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
