package cc3002.tarea2.game.view.FXMLControllers;

import javafx.event.ActionEvent;

public class YesNoAlert extends SceneAlert {

    private boolean option;

    public YesNoAlert(String title, String label) {
        super(title, label);
    }

    @Override
    protected String getFXMLName() {
        return "YesNoAlert.fxml";
    }

    @Override
    public void okAction(ActionEvent actionEvent) {
        this.option = true;
        this.getWindow().close();
    }

    public void noAction(ActionEvent actionEvent) {
        this.option = false;
        this.getWindow().close();
    }

    public boolean getOption() {
        return this.option;
    }
}
