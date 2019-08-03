package cc3002.tarea2.game.states;

import cc3002.tarea2.game.controller.GameController;
import cc3002.tarea2.game.exceptions.PlayCardException;

public class State {

    protected GameController gameController;

    public void nextTurn() {

    }

    public void startTurn() {

    }

    public void startGame() {

    }

    public void waitPlayer() {

    }

    public void stopWaiting() {

    }

    public void draw7Cards() throws PlayCardException {

    }

    public void singleButtonClick() throws PlayCardException {

    }

    public void playerPlayed() {

    }

    public void noMoreOptions() {

    }

    public GameController getController() {
        return this.gameController;
    }

    public void setController(GameController controller) {
        this.gameController = controller;
    }

    public int getTurn() {
        return -1;
    }

    public void initialize() {

    }

    public void endState() {

    }

    public void cancelButtonClick() {

    }
}
