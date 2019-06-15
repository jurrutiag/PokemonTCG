package cc3002.tarea2.game.controller;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.ability.IAbility;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.cards.trainer.stadium.IStadiumCard;
import cc3002.tarea2.game.cards.trainer.stadium.NullStadiumCard;
import cc3002.tarea2.game.events.*;
import cc3002.tarea2.game.searching.methods.SearchObjectOwner;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.IEventVisitor;
import cc3002.tarea2.game.visitor.card.CanUseVisitor;
import cc3002.tarea2.game.visitor.stadium.PlayOnceATurnVisitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer, IEventVisitor {

    private Trainer[] trainers;
    private int turn;
    private IStadiumCard stadiumCard;

    private int selectedCard;

    private CanUseVisitor canUseVisitor;
    private ArrayList<IAbility> onceATurnAbilitiesPlayed = new ArrayList<>();

    public GameController(Trainer[] trainers, int turn) {
        trainers[0].setOpponent(trainers[1]);
        trainers[1].setOpponent(trainers[0]);
        this.trainers = trainers;
        for (Trainer trainer : this.trainers) {
            trainer.addObserver(this);
        }
        this.turn = turn;
        this.selectedCard = 0;
        this.stadiumCard = new NullStadiumCard();

        canUseVisitor = new CanUseVisitor();
    }

    public Trainer getTrainerPlaying() {
        return trainers[turn];
    }

    public Trainer getOpponent() {
        return trainers[(turn == 0 ? 1 : 0)];
    }

    public CanUseVisitor getCanUseVisitor() {
        return canUseVisitor;
    }

    public void drawCard() {
        this.getTrainerPlaying().drawCard();
    }

    public void selectCard(int index) {
        this.selectedCard = index;
    }

    public void playCard() {
        this.getTrainerPlaying().getHand().get(selectedCard).accept(canUseVisitor);
        if (canUseVisitor.canUseCard()) {
            this.getTrainerPlaying().playCard();
        }
    }

    public ArrayList<ICard> getPlayerHand() {
        return this.getTrainerPlaying().getHand();
    }

    public ArrayList<IPokemonCard> viewPlayerBench() {
        return this.getTrainerPlaying().getBench();
    }

    public ArrayList<IPokemonCard> viewOpponentBench() {
        return this.getOpponent().getBench();
    }

    public void selectActivePokemonAbility(int abilityIndex) {
        this.getTrainerPlaying().selectAbility(abilityIndex);
    }

    public void useActivePokemonAbility() {
        if (!this.onceATurnAbilitiesPlayed.contains(this.getTrainerPlaying().getSelectedAbility())) {
            this.getTrainerPlaying().useAbility();
        }
    }

    public IStadiumCard getStadiumCard() {
        return this.stadiumCard;
    }


    public void nextTurn() {
        this.turn = (turn == 0 ? 1 : 0);
        this.canUseVisitor = new CanUseVisitor();
        this.startTurn();
    }

    public void startTurn() {
        this.stadiumCard.acceptStadiumVisitor(new PlayOnceATurnVisitor(this.getTrainerPlaying()));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof IEventVisitable) {
            ((IEventVisitable) arg).accept(this);
        }
    }


    @Override
    public void visitEnergyCardPlayedEvent(EnergyCardPlayedEvent energyCardPlayedEvent) {
        getCanUseVisitor().energyCardUsed();
    }


    @Override
    public void visitOnceATurnAbilityEffect(OnceATurnAbilityEffect onceATurnAbilityEffect) {
        if (!onceATurnAbilitiesPlayed.contains(onceATurnAbilityEffect.getAbility())) {
            onceATurnAbilitiesPlayed.add(onceATurnAbilityEffect.getAbility());
        }
    }

    @Override
    public void visitInstantAbilityPlayedEvent(InstantAbilityPlayedEvent instantAbilityPlayedEvent) {

    }

    @Override
    public void visitStadiumCardPlayed(StadiumCardPlayedEvent stadiumCardPlayed) {
        this.stadiumCard = stadiumCardPlayed.getStadiumCard();
    }

    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {
        nextTurn();
    }

    @Override
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {
        ArrayList<IPokemonCard> pokemons = this.getTrainerPlaying().search(new SearchObjectOwner(new ExpShareObject()), this.getTrainerPlaying().getBench());
        executeObjects(pokemons);
    }

    public void executeObjects(ArrayList<IPokemonCard> owners) {
        for (IPokemonCard pokemon : owners) {
            pokemon.executeObjectEffect();
        }
    }

    public void selectBenchPokemon(int i) {
        this.getTrainerPlaying().selectBenchPokemon(i);
    }

    public void changeActivePokemon() {
        this.getTrainerPlaying().swapActivePokemon();
    }
}
