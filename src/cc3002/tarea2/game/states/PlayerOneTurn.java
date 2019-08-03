package cc3002.tarea2.game.states;

public class PlayerOneTurn extends TurnState {

    @Override
    public void startTurn() {
        this.getController().startTurn();
    }

    @Override
    public void nextTurn() {
        super.nextTurn();
        this.getController().setState(new PlayerTwoTurn());
    }

    @Override
    public int getTurn() {
        return 0;
    }

}
