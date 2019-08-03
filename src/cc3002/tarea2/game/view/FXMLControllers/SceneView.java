package cc3002.tarea2.game.view.FXMLControllers;

import cc3002.tarea2.game.view.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneView {

    public int getWidth() {
        return 600;
    }
    public int getHeight() {
        return 400;
    }
    public abstract String getTitle();
    public abstract String getFXMLName();

    public void execute(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLfiles/" + this.getFXMLName()));
            loader.setController(this);
            Parent root = loader.load();
            primaryStage.setTitle(this.getTitle());
            primaryStage.setScene(new Scene(root, this.getWidth(), this.getHeight()));

        } catch (IOException e) {
            Driver.exit("Failed to load " + this.getFXMLName());
        }
    }

    public void toMenu(ActionEvent actionEvent) {
        Driver.mainMenu();
    }
}
