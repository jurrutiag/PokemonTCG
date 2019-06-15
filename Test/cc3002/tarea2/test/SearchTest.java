package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.*;
import cc3002.tarea2.game.searching.methods.SearchPokemonByID;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SearchTest {

    private Trainer trainer1;
    private Trainer trainer2;

    @Before
    public void setUp() {
        trainer1 = new Trainer();
        trainer2 = new Trainer();
    }

    @Test
    public void searchPokemonById() {
        trainer1.addCard(new ElectricTypePokemonCard(trainer1));
        trainer1.playCard();
        trainer1.addCard(new FightingTypePokemonCard(trainer1));
        trainer1.playCard();
        trainer1.addCard(new FireTypePokemonCard(trainer1));
        trainer1.playCard();
        trainer1.addCard(new GrassTypePokemonCard(trainer1));
        trainer1.playCard();
        trainer1.addCard(new PsychicTypePokemonCard(trainer1));
        trainer1.playCard();
        trainer1.addCard(new WaterTypePokemonCard(trainer1));
        trainer1.playCard();

        assertEquals(trainer1.getBench().get(0), trainer1.search(new SearchPokemonByID(100), trainer1.getBench()).get(0));
        assertEquals(trainer1.getBench().get(1), trainer1.search(new SearchPokemonByID(200), trainer1.getBench()).get(0));
        assertEquals(trainer1.getBench().get(2), trainer1.search(new SearchPokemonByID(300), trainer1.getBench()).get(0));
        assertEquals(trainer1.getBench().get(3), trainer1.search(new SearchPokemonByID(400), trainer1.getBench()).get(0));
        assertEquals(trainer1.getBench().get(4), trainer1.search(new SearchPokemonByID(500), trainer1.getBench()).get(0));
        assertEquals(trainer1.getBench().get(5), trainer1.search(new SearchPokemonByID(600), trainer1.getBench()).get(0));


        trainer2.addCard(new ElectricTypePokemonCard(trainer2));
        trainer2.playCard();
        trainer2.addCard(new ElectricTypePokemonCard(trainer2));
        trainer2.playCard();
        trainer2.addCard(new ElectricTypePokemonCard(trainer2));
        trainer2.playCard();

        assertEquals(3, trainer2.search(new SearchPokemonByID(100), trainer2.getBench()).size());
        assertEquals(0, trainer2.search(new SearchPokemonByID(200), trainer2.getBench()).size());
    }
}
