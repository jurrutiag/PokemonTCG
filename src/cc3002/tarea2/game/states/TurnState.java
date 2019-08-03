package cc3002.tarea2.game.states;

public abstract class TurnState extends State {

    public void endTurn() {
        this.getController().getPlayingGui().endTurn(this);
    }

    @Override
    public void nextTurn() {
        this.endTurn();
    }
}
