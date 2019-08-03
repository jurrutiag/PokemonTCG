package cc3002.tarea2.game.view;

import cc3002.tarea2.game.Trainer;
import cc3002.tarea2.game.controller.GameController;
import cc3002.tarea2.game.view.FXMLControllers.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {

    public static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public static void play() {

        EnterNameAlertBox enterNameAlertBox1 = new EnterNameAlertBox("Ingresar Nombre", "Ingresar nombre de Jugador 1:");
        enterNameAlertBox1.execute();

        EnterNameAlertBox enterNameAlertBox2 = new EnterNameAlertBox("Ingresar Nombre", "Ingresar nombre de Jugador 2:");
        enterNameAlertBox2.execute();

        Trainer trainer1 = new Trainer();
        trainer1.setName(enterNameAlertBox1.getName());
        Trainer trainer2 = new Trainer();
        trainer2.setName(enterNameAlertBox2.getName());

        GameController controller = new GameController(new Trainer[] {trainer1, trainer2});

        PlayingView playingView = new PlayingView();
        changeScene(playingView);
        PlayingGUI playingGui = new PlayingGUI(window, controller, playingView);
        playingGui.start();
    }

    public static void mainMenu() {
        changeScene(new MainMenu());
    }

    public static void settings() {
        changeScene(new Settings());
    }

    public static void changeScene(SceneView sceneView) {
        sceneView.execute(window);
    }

    public static void exit(String exitMessage) {
        //TODO: exit message show
        window.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        mainMenu();
        window.show();
    }


}
