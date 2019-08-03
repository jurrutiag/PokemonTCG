package cc3002.tarea2.game.states;

public abstract class WaitingState extends State {

    private State prevState;

    public WaitingState(State prevState) {
        this.prevState = prevState;
    }

    @Override
    public int getTurn() {
        return prevState.getTurn();
    }

    @Override
    public void stopWaiting() {
        this.getController().setState(prevState);
    }

    @Override
    public void nextTurn() {
        this.prevState.nextTurn();
    }

    public State getPrevState() {
        return this.prevState;
    }
}
