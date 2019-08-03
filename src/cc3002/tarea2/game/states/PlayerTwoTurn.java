package cc3002.tarea2.game.states;

public class PlayerTwoTurn extends TurnState {

    @Override
    public void startTurn() {
        this.getController().startTurn();
    }

    @Override
    public void nextTurn() {
        super.nextTurn();
        this.getController().setState(new PlayerOneTurn());
    }

    @Override
    public int getTurn() {
        return 1;
    }

}
