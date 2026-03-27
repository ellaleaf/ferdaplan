package hi.vidmot.view;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class FerdSpjald extends AnchorPane {

    @FXML private Label fxName;
    @FXML private Label fxDestination;
    @FXML private Label fxDate;
    @FXML private Label fxBudget;

    public FerdSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("ferd-spjald.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public StringProperty nameProperty() {
        return fxName.textProperty();
    }
}
