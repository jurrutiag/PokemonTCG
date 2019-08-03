package cc3002.tarea2.game.states;

public class WaitingForDrawPrizeCard extends WaitingState {

    public WaitingForDrawPrizeCard(State prevState) {
        super(prevState);
    }

    @Override
    public void singleButtonClick() {
        this.getController().drawPrizeCards();
        this.getController().getState().stopWaiting();
        this.getController().getState().nextTurn();
    }

    @Override
    public void initialize() {
        this.getController().getPlayingGui().showSelectPrizeCardsButton();
    }

}
