package cc3002.tarea2.test;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.FightingTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.implemented_pokemons.basic.WaterTypePokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.PotionObject;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ObjectTest {

    private ExpShareObject expShareObject;
    private PotionObject potionObject;

    private Trainer trainer1;
    private Trainer trainer2;

    private ElectricTypePokemonCard electricPokemon;
    private FightingTypePokemonCard fightingPokemon;
    private WaterTypePokemonCard waterPokemon;

    @Before
    public void setUp() {
        expShareObject = new ExpShareObject();
        potionObject = new PotionObject();

        electricPokemon = new ElectricTypePokemonCard(100, new IAbility[] {}, trainer1);
        waterPokemon = new WaterTypePokemonCard(trainer1);
        fightingPokemon = new FightingTypePokemonCard(trainer2);

        trainer1 = new Trainer();
        trainer2 = new Trainer();

    }

    @Test
    public void testExpShare() {
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
    public void testPotion() {
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

}