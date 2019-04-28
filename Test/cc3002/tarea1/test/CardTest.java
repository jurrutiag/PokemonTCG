package cc3002.tarea1.test;

import cc3002.tarea1.game.Attack;
import cc3002.tarea1.game.Energy;
import cc3002.tarea1.game.Pokemon;
import cc3002.tarea1.game.Trainer;
import cc3002.tarea1.game.energies.*;
import cc3002.tarea1.game.Abilities.Attacks.ElectricAttack;
import cc3002.tarea1.game.pokemons.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private Energy electricEnergy;
    private Energy fightingEnergy;
    private Energy fireEnergy;
    private Energy grassEnergy;
    private Energy psychicEnergy;
    private Energy waterEnergy;

    private Pokemon electricPokemon;
    private Pokemon fightingPokemon;
    private Pokemon firePokemon;
    private Pokemon grassPokemon;
    private Pokemon psychicPokemon;
    private Pokemon waterPokemon;

    @Before
    public void setUp() {
        Trainer trainer1 = new Trainer();

        Attack[] attacks = new Attack[]{new ElectricAttack()};

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