package hi.vidmot.view;

import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


public class FerdSpjald extends AnchorPane {

    @FXML public Label fxName;
    @FXML private Label fxDestination;
    @FXML private Label fxDate;
    @FXML private Label fxBudget;

    public FerdSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/hi/vidmot/ferd-spjald.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setItems(Ferd ferd) {
        fxName.textProperty().bind(ferd.name);
        fxDestination.textProperty().bind(ferd.destination);
        fxDate.textProperty().setValue(ferd.getDate());
        fxBudget.textProperty().bind(ferd.budget);

    }

}
