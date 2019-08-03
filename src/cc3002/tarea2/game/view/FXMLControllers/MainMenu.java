package cc3002.tarea2.game.view.FXMLControllers;

import cc3002.tarea2.game.view.Driver;
import javafx.event.ActionEvent;

public class MainMenu extends SceneView {

    @Override
    public String getTitle() {
        return "Menu";
    }

    @Override
    public String getFXMLName() {
        return "MainMenu.fxml";
    }

    public void startGame(ActionEvent actionEvent) {
        Driver.play();
    }

    public void toSettings(ActionEvent actionEvent) {
        Driver.settings();
    }

    public void exitGame(ActionEvent actionEvent) {
        Driver.exit("Player exited the game.");
    }
}
