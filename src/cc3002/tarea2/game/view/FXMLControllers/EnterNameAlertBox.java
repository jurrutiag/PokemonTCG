package cc3002.tarea2.game.view.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class EnterNameAlertBox extends SceneAlert implements Initializable {

    private String name;
    @FXML private TextField text;
    @FXML private Label label;

    public EnterNameAlertBox(String title, String label) {
        super(title, label);
    }

    @Override
    protected String getFXMLName() {
        return "EnterNameAlertBox.fxml";
    }

    @Override
    public void okAction(ActionEvent actionEvent) {
        name = text.getText();
        this.getWindow().close();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(this.getLabel());
    }

}
