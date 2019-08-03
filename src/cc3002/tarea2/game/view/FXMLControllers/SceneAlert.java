package cc3002.tarea2.game.view.FXMLControllers;

import cc3002.tarea2.game.view.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneAlert implements Initializable {

    @FXML Label label;
    private String labelText;
    private String titleText;
    private Stage window;
    private boolean closed = false;

    public SceneAlert() {

    }

    public SceneAlert(String title, String label) {
        this.labelText = label;
        this.titleText = title;
    }

    public void execute() {

        try {
            this.window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(this.getTitle());
            window.setMinWidth(this.getWidth());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLfiles/" + this.getFXMLName()));

            loader.setController(this);

            Parent root = loader.load();
            window.setTitle(this.getTitle());
            window.setScene(new Scene(root, this.getWidth(), this.getHeight()));
            window.setOnCloseRequest(event -> closedWindow());
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Driver.exit("Failed to load " + this.getFXMLName());
        }

    }

    public void closedWindow() {
        closed = true;
    }

    public boolean wasClosed() {
        return this.closed;
    }

    public double getHeight() {
        return 164;
    }

    public double getWidth() {
        return 377;
    }

    public String getTitle() {
        return titleText;
    }

    public String getLabel() {
        return labelText;
    }

    public Stage getWindow() {
        return window;
    }

    protected String getFXMLName() {
        return "SceneAlert.fxml";
    }

    public void okAction(ActionEvent actionEvent) {
        getWindow().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.label.setText(this.getLabel());
    }
}
