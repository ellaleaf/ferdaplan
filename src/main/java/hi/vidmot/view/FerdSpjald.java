package hi.vidmot.view;

import hi.vidmot.switcher.View;
import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import static hi.vidmot.switcher.ViewSwitcher.switchTo;
import static hi.vinnsla.Ferdaplan.ferdaplan;


public class FerdSpjald extends AnchorPane {

    @FXML public Label fxName;
    @FXML private Label fxDestination;
    @FXML private Label fxDate;
    @FXML private Label fxBudget;
    public Ferd ferd;

    public FerdSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/hi/vidmot/ferd-spjald.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setItems(Ferd ferd) {
        this.ferd = ferd;

        fxName.textProperty().bind(ferd.name);
        fxDestination.textProperty().bind(ferd.destination);
        fxDate.textProperty().setValue(ferd.getDate());
        fxBudget.textProperty().bind(ferd.budget);

    }

    @FXML
    private void onDelete() {
        ferdaplan.remove(ferd);

        ((FlowPane)this.getParent()).getChildren().remove(this);
    }

    @FXML
    private void onEdit() {
        View view = View.FERD;
        switchTo(view,false, ferd);
    }


}
