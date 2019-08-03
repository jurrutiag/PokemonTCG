package cc3002.tarea2.game.states;

public class PlayerTwoSetUp extends TurnState {

    @Override
    public void nextTurn() {
        super.nextTurn();
        this.getController().setState(new PlayerOneTurn());
        this.getController().getState().startTurn();
    }

    //TODO: remove duplicated code here, waitPlayer

    @Override
    public void waitPlayer() {
        this.getController().getPlayingGui().waitingState();
        this.getController().setState(new WaitingForDraw7Cards(this));
    }

    @Override
    public int getTurn() {
        return 1;
    }

}
