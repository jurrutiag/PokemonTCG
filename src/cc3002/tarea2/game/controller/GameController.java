package cc3002.tarea2.game.controller;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.ICard;
import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.cards.trainer.object.implemented_objects.ExpShareObject;
import cc3002.tarea2.game.events.*;
import cc3002.tarea2.game.searching.methods.SearchObjectOwner;
import cc3002.tarea2.game.visitor.IEventVisitable;
import cc3002.tarea2.game.visitor.IEventVisitor;
import cc3002.tarea2.game.visitor.card.CanUseVisitor;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer, IEventVisitor {

    private Trainer[] trainers;
    private int turn;

    private CanUseVisitor canUseVisitor;

    public GameController(Trainer[] trainers, int turn) {
        this.trainers = trainers;
        for (Trainer trainer : this.trainers) {
            trainer.addObserver(this);
        }
        this.turn = turn;

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

    public void playCard(int cardIndex) {
        this.getTrainerPlaying().getHand().get(cardIndex).accept(canUseVisitor);
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
        this.getTrainerPlaying().useAbility();
    }


    private void endTurn() {
        this.turn = (turn == 0 ? 1 : 0);
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
    public void visitPokemonCardPlayedEvent(PokemonCardPlayedEvent pokemonCardPlayedEvent) {

    }

    @Override
    public void visitTrainerCardPlayedEvent(TrainerCardPlayedEvent trainerCardPlayedEvent) {

    }

    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {
        endTurn();
    }

    @Override
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {
        this.executeExpShareEffect(activePokemonDiedEvent.getActivePokemon());
    }

    //TODO: revisar expShare
    private void executeExpShareEffect(IPokemonCard activePokemon) {
        ArrayList<IPokemonCard> expShareOwners = this.getTrainerPlaying().search(new SearchObjectOwner(new ExpShareObject()), trainers[turn].getBench());
        for (IPokemonCard pokemon : expShareOwners) {
            if (activePokemon.getEnergySet().getElectricEnergies() > 0) {
                pokemon.addElectricEnergy();
            }
        }
    }
}
