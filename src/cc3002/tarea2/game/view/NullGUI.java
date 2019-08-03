package cc3002.tarea2.game.view;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.controller.GameController;
import cc3002.tarea2.game.states.TurnState;
import cc3002.tarea2.game.visitor.IEventVisitable;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class NullGUI implements IGUI {
    @Override
    public void start() {

    }

    @Override
    public Pane getButtonPane() {
        return null;
    }

    @Override
    public GameController getController() {
        return null;
    }

    @Override
    public void notifyEvent(IEventVisitable event) {

    }

    @Override
    public void addText(String str) {

    }

    @Override
    public void addTitleText(String str) {

    }

    @Override
    public boolean alertNoPokemon(String playerName) {
        return false;
    }

    @Override
    public void selectAbility() {

    }

    @Override
    public void useCard() {

    }

    @Override
    public void showBench(ArrayList<IPokemonCard> pokemonCards) {

    }

    @Override
    public String pokemonInfo(IPokemonCard pokemonCard) {
        return null;
    }

    @Override
    public void showInfo() {

    }

    @Override
    public void pass() {

    }

    @Override
    public void startedPlaying(String playerName) {

    }

    @Override
    public void hideBottomButtons() {

    }

    @Override
    public void startTurnButtons() {

    }

    @Override
    public void showDraw7CardsButton() {

    }

    @Override
    public void waitingState() {

    }

    @Override
    public void setShowDrawn(boolean toggle) {

    }

    @Override
    public void selectPokemon(HashMap<Integer, IPokemonCard> playerHand) {

    }


    @Override
    public void commandDraw() {

    }

    @Override
    public void askBenchPokemons(int n, HashMap<Integer, IPokemonCard> pokemons) {

    }

    @Override
    public void showSelectActiveButton() {

    }

    @Override
    public void showSelectBenchPokemon(int i) {

    }

    @Override
    public void showSelectPrizeCardsButton() {

    }

    @Override
    public void noMoreBenchPokemons() {

    }

    @Override
    public void endTurn(TurnState turnState) {

    }
}
