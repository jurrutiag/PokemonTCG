package cc3002.tarea2.test;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.WaterTypePokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.PotionObject;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.implemented_stadium.LuckyStadium;
import cc3002.tarea2.game.cards.trainer.support.implemented_support.ProfessorCozmoDiscovery;
import cc3002.tarea2.game.cards.trainer.support.implemented_support.ProfessorJuniper;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TrainerCardTest {

    private ExpShareObject expShareObject;
    private PotionObject potionObject;
    private LuckyStadium luckyStadium;

    private Trainer trainer1;
    private Trainer trainer2;

    private ElectricTypePokemonCard electricPokemon;
    private FightingTypePokemonCard fightingPokemon;
    private WaterTypePokemonCard waterPokemon;

    @Before
    public void setUp() {
        expShareObject = new ExpShareObject();
        potionObject = new PotionObject();
        luckyStadium = new LuckyStadium();

        electricPokemon = new ElectricTypePokemonCard(100, new IAbility[] {}, trainer1);
        waterPokemon = new WaterTypePokemonCard(trainer1);
        fightingPokemon = new FightingTypePokemonCard(trainer2);

        trainer1 = new Trainer();
        trainer2 = new Trainer();

    }

    @Test
    public void testExpShare() throws Exception {
        trainer1.addCard(electricPokemon);
        trainer1.playCard();
        trainer1.addCard(waterPokemon);
        trainer1.playCard();
        trainer2.addCard(fightingPokemon);
        trainer2.playCard();

        trainer1.getActivePokemon().addElectricEnergy();
        trainer1.selectBenchPokemon(1);
        trainer1.addCard(new ExpShareObject());
        trainer1.playCard();
        trainer1.getSelectedPokemon().getAssociatedObjects().get(0).executeEffect();
        EnergySet energySet = new EnergySet();
        energySet.addElectricEnergy();
        assertEquals(energySet, trainer1.getSelectedPokemon().getEnergySet());
    }

    @Test
    public void testPotion() throws Exception {
        trainer1.addCard(electricPokemon);
        trainer1.playCard();
        trainer1.getActivePokemon().receiveDamage(20);

        assertEquals(80, trainer1.getActivePokemon().getHp());

        trainer1.addCard(new PotionObject());
        assertTrue(trainer1.getDiscardPile().isEmpty());
        trainer1.playCard();
        assertEquals(1, trainer1.getDiscardPile().size());

        assertEquals(100, trainer1.getActivePokemon().getHp());

        trainer1.getActivePokemon().receiveDamage(30);

        assertEquals(70, trainer1.getActivePokemon().getHp());

        trainer1.addCard(new PotionObject());
        trainer1.playCard();
        assertEquals(2, trainer1.getDiscardPile().size());

        assertEquals(90, trainer1.getActivePokemon().getHp());
    }

    @Test
    public void nullStadium() throws Exception {
        assertEquals("", new NullStadiumCard().getDescription());
        assertEquals("", new NullStadiumCard().getName());
    }

    @Test
    public void testLuckyStadium() throws Exception {
        luckyStadium.executeEffect(trainer1);
        // Better test on controller test.
        assertTrue(trainer1.handSize() == 1 || trainer1.handSize() == 0);

        assertEquals("Once a turn, the player can throw a coin, if heads, the player draws one card.", new LuckyStadium().getDescription());
        assertEquals("Lucky Stadium", new LuckyStadium().getName());
    }

    @Test
    public void testProfCozmoDiscovery() throws Exception {
        trainer1.addCard(new ProfessorCozmoDiscovery(trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();

        assertTrue(trainer1.handSize() == 3 || trainer1.handSize() == 2);

        assertEquals("Throw a coin, if it lands heads, draw the 3 bottom cards of your deck, if it lands tails, draw the 2 first.", new ProfessorCozmoDiscovery(trainer1).getDescription());
        assertEquals("Professor Cozmo's Discovery", new ProfessorCozmoDiscovery(trainer1).getName());
    }

    @Test
    public void testProfJuniper() throws Exception {
        trainer1.addCard(new ProfessorJuniper(trainer1));
        assertEquals(1, trainer1.handSize());
        trainer1.playCard();
        assertEquals(7, trainer1.handSize());

        assertEquals("Discard your hand and draw 7 cards.", new ProfessorJuniper(trainer1).getDescription());
        assertEquals("Professor Juniper", new ProfessorJuniper(trainer1).getName());
    }

}