package cc3002.tarea2.game.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    private boolean option = false;

    public void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button okButton = new Button("Ok");
        Button closeButton = new Button("Close");

        closeButton.setOnAction(event -> {
            option = false;
            window.close();
        });

        okButton.setOnAction(event -> {
            option = true;
            window.close();
        });

        VBox topLayout = new VBox(20);
        HBox layout = new HBox(10);
        layout.getChildren().addAll(okButton, closeButton);
        topLayout.getChildren().addAll(label, layout);

        topLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(topLayout);

        window.setScene(scene);
        window.showAndWait();

    }

    public boolean getOption() {
        return this.option;
    }
}
