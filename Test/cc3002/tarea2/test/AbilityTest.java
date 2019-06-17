package cc3002.tarea2.test;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.implemented_abilities.Heal;
import cc3002.tarea2.game.ability.implemented_abilities.InstantAbility;
import cc3002.tarea2.game.ability.implemented_abilities.WingBuzz;
import cc3002.tarea2.game.cards.energies.ElectricEnergyCard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AbilityTest {

    private Trainer trainer1;
    private IPokemonCard electricPokemon;
    private IPokemonCard fightingPokemon;

    private IAbility[] abilitiesSet;
    private Trainer trainer2;


    @Before
    public void setUp() throws Exception {
        trainer1 = new Trainer();
        trainer2 = new Trainer();
        trainer1.setOpponent(trainer2);
        trainer2.setOpponent(trainer1);
        abilitiesSet = new IAbility[] {new WingBuzz()};
        electricPokemon = new ElectricTypePokemonCard(100, abilitiesSet, trainer1);
        fightingPokemon = new FightingTypePokemonCard(trainer2);
    }

    @Test
    public void testWingBuzz() {
        assertEquals("Once per turn, if this pokemon is active, you can discard one card from your hand, if you do, discard the top card of your opponent's deck", new WingBuzz().getDescription());
        assertEquals("Wing Buzz", new WingBuzz().getName());

        trainer1.addCard(new ElectricEnergyCard());
        trainer1.addCard(electricPokemon);
        trainer1.selectHandCard(1);
        trainer1.playCard();

        trainer2.addCard(fightingPokemon);
        trainer2.selectHandCard(0);
        trainer2.playCard();

        assertEquals(60, trainer2.getDeck().getSize());
        assertEquals(1, trainer1.getHand().size());

        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals(59, trainer2.getDeck().getSize());
        assertEquals(0, trainer1.getHand().size());
    }

    @Test(expected = AssertionError.class)
    public void testInstant() {
        IAbility instantAbility = new InstantAbility();
        instantAbility.getEvent();
        trainer1.addCard(new ElectricTypePokemonCard(100, new IAbility[] {instantAbility}, trainer1));
        trainer2.addCard(fightingPokemon);
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer2.selectHandCard(0);
        trainer2.playCard();

        trainer1.selectAbility(0);
        trainer1.useAbility();

        assertEquals("An instant ability", new InstantAbility().getDescription());
        assertEquals("Instant Ability", new InstantAbility().getName());
    }

    @Test
    public void testHeal() {
        trainer1.addCard(new ElectricTypePokemonCard(100, new IAbility[] {new Heal()}, trainer1));
        trainer1.selectHandCard(0);
        trainer1.playCard();
        trainer1.getActivePokemon().receiveDamage(50);
        assertEquals(50, trainer1.getActivePokemon().getHp());
        trainer1.selectAbility(0);
        trainer1.useAbility();
        assertTrue(trainer1.getActivePokemon().getHp() == 60 || trainer1.getActivePokemon().getHp() == 50);

        assertEquals("Once per turn, you can throw a coin, if it lands heads you can remove one damage counter from one of your pokemons.", new Heal().getDescription());
        assertEquals("Heal", new Heal().getName());
    }
}