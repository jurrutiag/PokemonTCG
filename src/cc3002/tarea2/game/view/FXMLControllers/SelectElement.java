package cc3002.tarea2.game.view.FXMLControllers;

import cc3002.tarea2.game.ISelectableWithInfo;
import cc3002.tarea2.game.exceptions.PlayCardException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectElement extends SceneAlert {

    @FXML private Button moreInfoButton;
    @FXML private ListView<String> selectionView;
    @FXML private Label errorLabel;
    @FXML private ListView<String> moreInfoView;

    private ISelectableWithInfo finalElementSelected;
    private ArrayList<? extends ISelectableWithInfo> elementsToSelect;

    public SelectElement(ArrayList<? extends ISelectableWithInfo> elementsToSelect, String title, String label) {
        super(title, label);
        this.elementsToSelect = elementsToSelect;
    }


    @Override
    protected String getFXMLName() {
        return "SelectElement.fxml";
    }

    @Override
    public void okAction(ActionEvent actionEvent) {
        if (selectionView.getSelectionModel().getSelectedItems().size() > 1) {
            errorLabel.setText("Please select only one.");
        } else if (selectionView.getSelectionModel().getSelectedItems().size() == 0) {
            errorLabel.setText("Please select at least one.");
        } else {
            errorLabel.setText("");
            finalElementSelected = elementsToSelect.get(selectionView.getSelectionModel().getSelectedIndex());
            getWindow().close();
        }
    }


    @Override
    public double getWidth() {
        return 385;
    }

    @Override
    public double getHeight() {
        return 389;
    }

    public void selectedListElement(MouseEvent actionEvent) {
        moreInfoButton.setDisable(false);
    }

    public ISelectableWithInfo getElementSelected() {
        return this.finalElementSelected;
    }

    public void moreElementInfo(ActionEvent actionEvent) throws PlayCardException {

        if (!moreInfoView.isDisabled() && moreInfoView.isVisible()) {
            moreInfoView.setDisable(true);
            moreInfoView.setVisible(false);
            selectionView.setDisable(false);
            selectionView.setVisible(true);

            moreInfoView.getItems().clear();
        } else {

            if (selectionView.getSelectionModel().getSelectedItems().size() > 1) {
                errorLabel.setText("Please select only one.");
            } else {
                errorLabel.setText("");
                ISelectableWithInfo selectedElement = elementsToSelect.get(selectionView.getSelectionModel().getSelectedIndex());
                selectionView.setDisable(true);
                selectionView.setVisible(false);


                for (String info : selectedElement.getInfo()) {
                    moreInfoView.getItems().add(info);
                }

                moreInfoView.setDisable(false);
                moreInfoView.setVisible(true);
            }
        }
    }

    public void clickedMouse(MouseEvent actionEvent) {
        if (selectionView.getSelectionModel().getSelectedItems().size() == 0) {
            moreInfoButton.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        for (ISelectableWithInfo element : elementsToSelect) {
            selectionView.getItems().add(element.getName());
        }
    }

}
