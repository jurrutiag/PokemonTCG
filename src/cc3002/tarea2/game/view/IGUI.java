package cc3002.tarea2.game.view;

import cc3002.tarea2.game.cards.pokemon.IPokemonCard;
import cc3002.tarea2.game.controller.GameController;
import cc3002.tarea2.game.states.TurnState;
import cc3002.tarea2.game.visitor.IEventVisitable;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public interface IGUI {
    public void start();

    public Pane getButtonPane();

    public GameController getController();

    public void notifyEvent(IEventVisitable event);

    public void addText(String str);

    public void addTitleText(String str);

    public boolean alertNoPokemon(String playerName);

    public void selectAbility();

    public void useCard();

    public void showBench(ArrayList<IPokemonCard> pokemonCards);

    public String pokemonInfo(IPokemonCard pokemonCard);

    public void showInfo();

    public void pass();

    public void startedPlaying(String playerName);

    public void hideBottomButtons();

    public void startTurnButtons();

    public void showDraw7CardsButton();

    public void waitingState();

    public void setShowDrawn(boolean toggle);

    public void selectPokemon(HashMap<Integer, IPokemonCard> playerHand);

    void commandDraw();

    void askBenchPokemons(int n, HashMap<Integer, IPokemonCard> pokemons);

    void showSelectActiveButton();

    void showSelectBenchPokemon(int i);

    void showSelectPrizeCardsButton();

    void noMoreBenchPokemons();

    void endTurn(TurnState turnState);
}
