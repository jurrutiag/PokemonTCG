package cc3002.tarea2.test;

import cc3002.tarea2.game.Abilities.Attack;
import cc3002.tarea2.game.cards.EnergyCard;
import cc3002.tarea2.game.cards.PokemonCard;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.Abilities.Attacks.ElectricAttack;
import cc3002.tarea2.game.cards.energies.*;
import cc3002.tarea2.game.cards.pokemon.pokemons.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private EnergyCard electricEnergyCard;
    private EnergyCard fightingEnergyCard;
    private EnergyCard fireEnergyCard;
    private EnergyCard grassEnergyCard;
    private EnergyCard psychicEnergyCard;
    private EnergyCard waterEnergyCard;

    private PokemonCard electricPokemonCard;
    private PokemonCard fightingPokemonCard;
    private PokemonCard firePokemonCard;
    private PokemonCard grassPokemonCard;
    private PokemonCard psychicPokemonCard;
    private PokemonCard waterPokemonCard;

    @Before
    public void setUp() {
        Trainer trainer1 = new Trainer();

        Attack[] attacks = new Attack[]{new ElectricAttack()};

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
    public void isActivelySelectable() {
        assertFalse(electricEnergyCard.isActivelySelectable());
        assertFalse(fightingEnergyCard.isActivelySelectable());
        assertFalse(fireEnergyCard.isActivelySelectable());
        assertFalse(grassEnergyCard.isActivelySelectable());
        assertFalse(psychicEnergyCard.isActivelySelectable());
        assertFalse(waterEnergyCard.isActivelySelectable());

        assertTrue(electricPokemonCard.isActivelySelectable());
        assertTrue(fightingPokemonCard.isActivelySelectable());
        assertTrue(firePokemonCard.isActivelySelectable());
        assertTrue(grassPokemonCard.isActivelySelectable());
        assertTrue(psychicPokemonCard.isActivelySelectable());
        assertTrue(waterPokemonCard.isActivelySelectable());
    }

}