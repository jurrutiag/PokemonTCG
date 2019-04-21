package cc3002.tarea1;

import cc3002.tarea1.Abilities.Attacks.ElectricAttack;
import cc3002.tarea1.energies.*;
import cc3002.tarea1.pokemons.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Trainer trainer1;

    Attack[] attacks;

    Energy electricEnergy;
    Energy fightingEnergy;
    Energy fireEnergy;
    Energy grassEnergy;
    Energy psychicEnergy;
    Energy waterEnergy;

    Pokemon electricPokemon;
    Pokemon fightingPokemon;
    Pokemon firePokemon;
    Pokemon grassPokemon;
    Pokemon psychicPokemon;
    Pokemon waterPokemon;

    @Before
    public void setUp() {
        trainer1 = new Trainer();

        attacks = new Attack[] {new ElectricAttack()};

        electricEnergy = new ElectricEnergy();
        fightingEnergy = new FightingEnergy();
        fireEnergy = new FireEnergy();
        grassEnergy = new GrassEnergy();
        psychicEnergy = new PsychicEnergy();
        waterEnergy = new WaterEnergy();

        electricPokemon = new ElectricTypePokemon(50, attacks, trainer1);
        fightingPokemon = new FightingTypePokemon(50, attacks, trainer1);
        firePokemon = new FireTypePokemon(50, attacks, trainer1);
        grassPokemon = new GrassTypePokemon(50, attacks, trainer1);
        psychicPokemon = new PsychicTypePokemon(50, attacks, trainer1);
        waterPokemon = new WaterTypePokemon(50, attacks, trainer1);
    }

    @Test
    public void isActivelySelectable() {
        assertFalse(electricEnergy.isActivelySelectable());
        assertFalse(fightingEnergy.isActivelySelectable());
        assertFalse(fireEnergy.isActivelySelectable());
        assertFalse(grassEnergy.isActivelySelectable());
        assertFalse(psychicEnergy.isActivelySelectable());
        assertFalse(waterEnergy.isActivelySelectable());

        assertTrue(electricPokemon.isActivelySelectable());
        assertTrue(fightingPokemon.isActivelySelectable());
        assertTrue(firePokemon.isActivelySelectable());
        assertTrue(grassPokemon.isActivelySelectable());
        assertTrue(psychicPokemon.isActivelySelectable());
        assertTrue(waterPokemon.isActivelySelectable());
    }

}