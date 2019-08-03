package cc3002.tarea2.game.states;

public class PlayerOneSetUp extends TurnState {

    @Override
    public void nextTurn() {
        super.nextTurn();
        this.getController().setState(new PlayerTwoSetUp());
        this.getController().getState().waitPlayer();
    }

    @Override
    public void waitPlayer() {
        this.getController().getPlayingGui().waitingState();
        this.getController().setState(new WaitingForDraw7Cards(this));
    }

    @Override
    public int getTurn() {
        return 0;
    }



}
