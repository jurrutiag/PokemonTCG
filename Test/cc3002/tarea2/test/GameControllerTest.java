package cc3002.tarea2.test;

import cc3002.tarea2.game.EnergySet;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.ability.attack.implemented_attacks.ElectricShock;
import cc3002.tarea2.game.ability.implemented_abilities.InstantAbility;
import cc3002.tarea2.game.ability.implemented_abilities.WingBuzz;
import cc3002.tarea2.game.cards.energies.ElectricEnergyCard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.ElectricTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.FightingTypePokemonCard;
import cc3002.tarea2.game.cards.pokemon.testing_pokemons.basic.WaterTypePokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.implemented_stadium.LuckyStadium;
import cc3002.tarea2.game.cards.trainer.support.implemented_support.ProfessorJuniper;
import cc3002.tarea2.game.controller.GameController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameControllerTest {

    private GameController controller;

    private Trainer trainer1;
    private Trainer trainer2;

    private IPokemonCard electricPokemon;
    private IPokemonCard fightingPokemon;

    @Before
    public void setUp() {
        trainer1 = new Trainer();
        trainer2 = new Trainer();

        electricPokemon = new ElectricTypePokemonCard(100, new IAbility[] {new ElectricShock(), new WingBuzz()}, trainer1);
        fightingPokemon = new FightingTypePokemonCard(trainer2);

        trainer1.addCard(electricPokemon);
        trainer2.addCard(fightingPokemon);
        trainer1.playCard();
        trainer2.playCard();

        controller = new GameController(new Trainer[] {trainer1, trainer2}, 0);
    }

    @Test
    public void getTrainerPlaying() {
        assertEquals(trainer1, controller.getTrainerPlaying());
        controller.nextTurn();
        assertEquals(trainer2, controller.getTrainerPlaying());
        controller.nextTurn();
        assertEquals(trainer1, controller.getTrainerPlaying());
    }

    @Test
    public void getOpponent() {
        assertEquals(trainer2, controller.getOpponent());
        controller.nextTurn();
        assertEquals(trainer1, controller.getOpponent());
        controller.nextTurn();
        assertEquals(trainer2, controller.getOpponent());
    }

    @Test
    public void drawCard() {
        assertEquals(0, controller.getTrainerPlaying().handSize());
        assertEquals(0, controller.getOpponent().handSize());
        controller.drawCard();
        assertEquals(1, controller.getTrainerPlaying().handSize());
        assertEquals(0, controller.getOpponent().handSize());
        controller.nextTurn();
        controller.drawCard();
        assertEquals(1, controller.getTrainerPlaying().handSize());
        assertEquals(1, controller.getOpponent().handSize());
    }

    @Test
    public void playCard() {
        IPokemonCard waterPokemon = new WaterTypePokemonCard(controller.getTrainerPlaying());
        controller.getTrainerPlaying().addCard(waterPokemon);
        controller.selectCard(0);
        controller.playCard();
        controller.selectBenchPokemon(1);
        controller.changeActivePokemon();
        assertEquals(waterPokemon, controller.getTrainerPlaying().getActivePokemon());
    }

    @Test
    public void getPlayerHand() {
        assertEquals(0, controller.getTrainerPlaying().handSize());
        controller.drawCard();
        assertEquals(1, controller.getTrainerPlaying().handSize());

        IPokemonCard waterPokemon = new WaterTypePokemonCard(controller.getTrainerPlaying());
        controller.getTrainerPlaying().addCard(waterPokemon);
        assertEquals(2, controller.getTrainerPlaying().handSize());
        assertEquals(waterPokemon, controller.getTrainerPlaying().getHand().get(1));
    }

    @Test
    public void viewPlayerBench() {
        assertEquals(electricPokemon, controller.viewPlayerBench().get(0));
        IPokemonCard waterPokemon = new WaterTypePokemonCard(controller.getTrainerPlaying());
        controller.getTrainerPlaying().addCard(waterPokemon);
        controller.selectCard(0);
        controller.playCard();
        assertEquals(waterPokemon, controller.viewPlayerBench().get(1));
    }

    @Test
    public void viewOpponentBench() {
        assertEquals(fightingPokemon, controller.viewOpponentBench().get(0));
        IPokemonCard waterPokemon = new WaterTypePokemonCard(controller.getOpponent());
        controller.getOpponent().addCard(waterPokemon);
        controller.getOpponent().selectHandCard(0);
        controller.getOpponent().playCard();
        assertEquals(waterPokemon, controller.viewOpponentBench().get(1));
    }


    @Test
    public void useActivePokemonAbility() {
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        assertEquals(1, controller.getPlayerHand().size());
        controller.selectActivePokemonAbility(1);
        controller.useActivePokemonAbility();
        assertEquals(0, controller.getPlayerHand().size());
    }

    @Test
    public void visitEnergyCardPlayedEvent() {
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        controller.selectCard(0);
        controller.playCard();

        new ElectricEnergyCard().accept(controller.getCanUseVisitor());
        assertFalse(controller.getCanUseVisitor().canUseCard());
    }

    @Test(expected = AssertionError.class)
    public void visitAbilityEffect() {
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        assertEquals(2, controller.getPlayerHand().size());
        controller.selectActivePokemonAbility(1);
        controller.useActivePokemonAbility();
        assertEquals(1, controller.getPlayerHand().size());
        controller.selectActivePokemonAbility(1);
        controller.useActivePokemonAbility();
        assertEquals(1, controller.getPlayerHand().size());

        controller.nextTurn();

        controller.getTrainerPlaying().addCard(new WaterTypePokemonCard(100, new IAbility[] {new InstantAbility()}, controller.getTrainerPlaying()));
        controller.selectCard(0);
        controller.playCard();
        controller.selectBenchPokemon(1);
        controller.changeActivePokemon();
        controller.selectActivePokemonAbility(0);
        controller.useActivePokemonAbility();
    }

    @Test
    public void visitStadiumCardPlayed() {
        IStadiumCard stadiumCard = new LuckyStadium();
        controller.getTrainerPlaying().addCard(stadiumCard);
        controller.selectCard(0);
        controller.playCard();

        controller.nextTurn();
        controller.nextTurn();

        assertEquals(stadiumCard, controller.getStadiumCard());
    }

    @Test
    public void visitAttackEvent() {
        controller.getTrainerPlaying().addCard(electricPokemon);
        controller.selectCard(0);
        controller.playCard();
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        controller.selectCard(0);
        controller.playCard();
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        controller.getTrainerPlaying().playCard();

        controller.getOpponent().addCard(electricPokemon);
        controller.getOpponent().selectHandCard(0);
        controller.getOpponent().playCard();

        assertEquals(trainer1, controller.getTrainerPlaying());

        controller.selectActivePokemonAbility(0);
        controller.useActivePokemonAbility();

        assertEquals(trainer2, controller.getTrainerPlaying());
    }

    @Test
    public void visitActivePokemonDiedEvent() {
        WaterTypePokemonCard waterPokemon = new WaterTypePokemonCard(controller.getTrainerPlaying());
        controller.getTrainerPlaying().addCard(waterPokemon);
        controller.selectCard(0);
        controller.playCard();

        controller.selectBenchPokemon(1);
        controller.getTrainerPlaying().addCard(new ExpShareObject());
        controller.selectCard(0);
        controller.playCard();

        assertEquals(new EnergySet(), controller.getTrainerPlaying().getActivePokemon().getEnergySet());
        assertEquals(new EnergySet(), controller.getTrainerPlaying().getBench().get(1).getEnergySet());

        EnergySet otroSet = new EnergySet();
        otroSet.addElectricEnergy();
        controller.selectBenchPokemon(0);
        controller.getTrainerPlaying().addCard(new ElectricEnergyCard());
        controller.selectCard(0);
        controller.playCard();

        assertEquals(otroSet, controller.getTrainerPlaying().getActivePokemon().getEnergySet());

        controller.getTrainerPlaying().getActivePokemon().receiveDamage(100);

        assertEquals(waterPokemon, controller.getTrainerPlaying().getActivePokemon());
        assertEquals(otroSet, controller.getTrainerPlaying().getActivePokemon().getEnergySet());
    }

    @Test
    public void testSupportPlayedOnce() {
        controller.getTrainerPlaying().addCard(new ProfessorJuniper());
        controller.selectCard(0);
        controller.playCard();
        assertEquals(7, controller.getTrainerPlaying().handSize());
        controller.selectCard(0);
        controller.discardSelected();
        controller.selectCard(0);
        controller.discardSelected();
        assertEquals(5, controller.getTrainerPlaying().handSize());
        controller.getTrainerPlaying().addCard(new ProfessorJuniper());
        assertEquals(6, controller.getTrainerPlaying().handSize());
        controller.selectCard(5);
        controller.playCard();
        assertEquals(6, controller.getTrainerPlaying().handSize());
    }

}