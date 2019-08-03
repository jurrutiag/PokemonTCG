package cc3002.tarea2.test;

import cc3002.tarea2.game.ability.attack.IAttack;
import cc3002.tarea2.game.cards.NullCard;
import cc3002.tarea2.game.cards.energies.AbstractEnergyCard;
import cc3002.tarea2.game.cards.pokemon.AbstractPokemonCard;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.attack.implemented_attacks.testing_attacks.ElectricAttack;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private AbstractEnergyCard electricEnergyCard;
    private AbstractEnergyCard fightingEnergyCard;
    private AbstractEnergyCard fireEnergyCard;
    private AbstractEnergyCard grassEnergyCard;
    private AbstractEnergyCard psychicEnergyCard;
    private AbstractEnergyCard waterEnergyCard;

    private AbstractPokemonCard electricPokemonCard;
    private AbstractPokemonCard fightingPokemonCard;
    private AbstractPokemonCard firePokemonCard;
    private AbstractPokemonCard grassPokemonCard;
    private AbstractPokemonCard psychicPokemonCard;
    private AbstractPokemonCard waterPokemonCard;

    private Trainer trainer1;

    @Before
    public void setUp() {
        trainer1 = new Trainer();

        IAttack[] attacks = new IAttack[]{new ElectricAttack()};

        electricEnergyCard = new ElectricEnergyCard();
        fightingEnergyCard = new FightingEnergyCard();
        fireEnergyCard = new FireEnergyCard();
        grassEnergyCard = new GrassEnergyCard();
        psychicEnergyCard = new PsychicEnergyCard();
        waterEnergyCard = new WaterEnergyCard();

        electricPokemonCard = new ElectricTypePokemonCard(50, attacks, trainer1);
        fightingPokemonCard = new FightingTypePokemonCard(50, attacks, trainer1);
        firePokemonCard = new FireTypePokemonCard(50, attacks, trainer1);
        grassPokemonCard = new GrassTypePokemonCard(50, attacks, trainer1);
        psychicPokemonCard = new PsychicTypePokemonCard(50, attacks, trainer1);
        waterPokemonCard = new WaterTypePokemonCard(50, attacks, trainer1);
    }

    @Test
    public void discarded() throws Exception {
        trainer1.addCard(electricEnergyCard);
        trainer1.addCard(fightingEnergyCard);
        trainer1.addCard(electricPokemonCard);
        trainer1.addCard(new NullCard());

        assertTrue(trainer1.getDiscardPile().isEmpty());
        assertEquals(4, trainer1.getHand().size());

        trainer1.selectHandCard(0);
        trainer1.discardSelectedFromHand();

        assertEquals(1, trainer1.getDiscardPile().size());
        assertEquals(3, trainer1.getHand().size());

        trainer1.selectHandCard(0);
        trainer1.discardSelectedFromHand();

        assertEquals(2, trainer1.getDiscardPile().size());
        assertEquals(2, trainer1.getHand().size());

        trainer1.selectHandCard(0);
        trainer1.discardSelectedFromHand();

        assertEquals(3, trainer1.getDiscardPile().size());
        assertEquals(1, trainer1.getHand().size());

        trainer1.selectHandCard(0);
        trainer1.discardSelectedFromHand();

        assertEquals(3, trainer1.getDiscardPile().size());
        assertEquals(0, trainer1.getHand().size());
    }

}