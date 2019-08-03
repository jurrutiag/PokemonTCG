package cc3002.tarea2.game.view.FXMLControllers;

import cc3002.tarea2.game.exceptions.PlayCardException;
import cc3002.tarea2.game.view.PlayingGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;


public class PlayingView extends SceneView {


    @FXML private Pane buttonPane;
    @FXML private ListView<String> mainView;
    @FXML private Button selectAbilityButton;
    @FXML private Button selectCardButton;
    @FXML private Button infoButton;
    @FXML private Button passButton;
    @FXML private Button singleButton;
    @FXML private CheckBox showDrawCheckBox;
    @FXML private Button cancelButton;
    private PlayingGUI gui;

    @Override
    public String getTitle() {
        return "Pokemon TCG";
    }

    @Override
    public String getFXMLName() {
        return "PlayingView.fxml";
    }

    public void setGUI(PlayingGUI gui) {
        this.gui = gui;
    }

    public Pane getButtonPane() {
        return buttonPane;
    }

    public ListView<String> getMainView() {
        return mainView;
    }


    public void selectAbilityButton(ActionEvent actionEvent) {
        gui.selectAbility();
    }

    public void selectCardButton(ActionEvent actionEvent) {
        gui.useCard();
    }


    public void infoButton(ActionEvent actionEvent) {
        gui.showInfo();
    }

    public void passButton(ActionEvent actionEvent) {
        gui.pass();
    }

    public void toggleShowDraw(ActionEvent actionEvent) {
        gui.setShowDrawn(showDrawCheckBox.isSelected());
    }

    public void singleButtonClick(ActionEvent actionEvent) throws PlayCardException {
        gui.getController().getState().singleButtonClick();
    }

    public void cancelButtonClick(ActionEvent actionEvent) {
        gui.getController().getState().cancelButtonClick();
    }

    public void hideAllButtons() {
        selectAbilityButton.setVisible(false);
        selectCardButton.setVisible(false);
        infoButton.setVisible(false);
        passButton.setVisible(false);
        singleButton.setVisible(false);
        cancelButton.setVisible(false);
    }

    public void showTurnButtons() {
        hideAllButtons();
        selectAbilityButton.setVisible(true);
        selectCardButton.setVisible(true);
        infoButton.setVisible(true);
        passButton.setVisible(true);
    }

    public void showDraw7CardsButton() {
        hideAllButtons();
        singleButton.setVisible(true);
    }

    public void setSingleButton(String s) {
        hideAllButtons();
        singleButton.setText(s);
        singleButton.setVisible(true);
    }

    public void showCancelButton() {
        cancelButton.setVisible(true);
    }

    public void hideCancelButton() {
        cancelButton.setVisible(false);
    }
}
