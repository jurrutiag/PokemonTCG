package cc3002.tarea2.game.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons {
    public static HBox TurnButtons(PlayingGUI playingGui) {
        HBox turnButtons = new HBox();
        Button useAbilityBut = new Button("Select Ability");
        Button useCardBut = new Button("Select Card");
        Button infoBut = new Button("Info");
        Button passBut = new Button("Pass");

        useAbilityBut.setOnAction(event -> {
            playingGui.selectAbility();
        });

        useCardBut.setOnAction(event -> {
            playingGui.useCard();
        });

        infoBut.setOnAction(event -> {
            playingGui.showInfo();
        });

        passBut.setOnAction(event -> {
            playingGui.pass();
        });

        turnButtons.getChildren().addAll(useAbilityBut, useCardBut, infoBut, passBut);
        turnButtons.setSpacing(10);

        return turnButtons;
    }
}
