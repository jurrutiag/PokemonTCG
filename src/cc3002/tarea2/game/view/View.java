package cc3002.tarea2.game.view;

import javafx.scene.Scene;

public abstract class View implements IView {

    private Scene scene;

    public Scene getScene() {
        return this.scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
