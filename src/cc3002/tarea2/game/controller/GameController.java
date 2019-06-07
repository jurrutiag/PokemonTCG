package cc3002.tarea2.game.controller;

import cc3002.tarea2.game.Card;
import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.cards.IEnergyCard;
import cc3002.tarea2.game.cards.IPokemonCard;
import cc3002.tarea2.game.cards.ITrainerCard;
import cc3002.tarea2.game.cards.trainer.object.ExpShareObject;
import cc3002.tarea2.game.events.ActivePokemonDiedEvent;
import cc3002.tarea2.game.events.AttackEvent;
import cc3002.tarea2.game.searching.methods.SearchObjectOwner;
import cc3002.tarea2.game.visitor.Visitable;
import cc3002.tarea2.game.visitor.card.CanUseVisitor;
import cc3002.tarea2.game.visitor.turn.EventVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer, EventVisitor {

    private Trainer[] trainers;
    private int turn;
    private StringBuilder str;

    private CanUseVisitor canUseVisitor;

    public GameController(Trainer[] trainers, int turn) {
        this.trainers = trainers;
        for (Trainer trainer : this.trainers) {
            trainer.addObserver(this);
        }
        this.turn = turn;
        this.str = new StringBuilder();

        canUseVisitor = new CanUseVisitor();
    }

    public CanUseVisitor getCanUseVisitor() {
        return canUseVisitor;
    }

    public void drawCard() {
        trainers[turn].drawCard();
    }

    public void resetStringBuilder() {
        this.str = new StringBuilder();
    }

    public void showString() {
        System.out.println(this.str.toString());
    }

    private void appendCards(List<? extends Card> cards) {
        String isUsable;
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).accept(canUseVisitor);
            isUsable = canUseVisitor.canUseCard() ? "" : "(Can't be used)";
            str.append(i);
            str.append(" - ");
            str.append(cards.get(i).toString());
            str.append(isUsable);
            str.append("\n");
        }
    }

    public void playCard(int cardIndex) {
        trainers[turn].getHand().get(cardIndex).accept(canUseVisitor);
        if (canUseVisitor.canUseCard()) {
            trainers[turn].playCard(cardIndex);
        }
    }

    public void viewHand() {
        str.append("Your Bench: \n");
        appendCards(trainers[turn].getHand());
        str.append("Your opponent's bench: \n");
        appendCards(trainers[turn == 0 ? 1 : 0].getHand());
    }

    public void useActivePokemonAbility(int abilityIndex) {
        trainers[turn].getActivePokemon().useAbility(abilityIndex);
    }


    public void endTurn() {
        this.turn = (turn == 0 ? 1 : 0);
    }

    public void viewBenchPokemons() {
        appendCards(trainers[turn].getBench());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Visitable) {
            ((Visitable) arg).accept(this);
        }
    }

    @Override
    public void visitPokemonCard(IPokemonCard pokemonCard) {

    }

    @Override
    public void visitEnergyCard(IEnergyCard energyCard) {
        getCanUseVisitor().energyCardUsed();
    }

    @Override
    public void visitTrainerCard(ITrainerCard trainerCard) {

    }

    @Override
    public void visitAttackEvent(AttackEvent attackEvent) {
        endTurn();
    }

    @Override
    public void visitActivePokemonDiedEvent(ActivePokemonDiedEvent activePokemonDiedEvent) {
        this.executeExpShareEffect();
    }

    //TODO: revisar expShare
    private void executeExpShareEffect() {
        ArrayList<IPokemonCard> expShareOwners = trainers[turn].search(new SearchObjectOwner(new ExpShareObject()), trainers[turn].getBench());
        for (IPokemonCard pokemon : expShareOwners) {
            if (pokemon.getEnergySet().getElectricEnergies() > 0) {
                pokemon.addElectricEnergy();
            }
        }
    }
}
