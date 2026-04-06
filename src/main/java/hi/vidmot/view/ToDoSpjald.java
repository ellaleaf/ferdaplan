package hi.vidmot.view;

import hi.vidmot.switcher.View;
import hi.vinnsla.Ferd;
import hi.vinnsla.ToDo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import static hi.vidmot.switcher.ViewSwitcher.switchTo;
import static hi.vinnsla.Ferdaplan.ferdaplan;
import static hi.vinnsla.Ferdaplan.getFerd;

public class ToDoSpjald extends AnchorPane {

    @FXML private Label fxName;
    @FXML private Label fxDate;
    @FXML private Label fxTime;
    @FXML private Label fxBudget;
    public ToDo toDo;
    public Ferd ferd;

    public ToDoSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/hi/vidmot/ToDo-spjald.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setItems(ToDo toDo) {
        this.toDo = toDo;
        this.ferd = toDo.getFerd(toDo);

        fxName.textProperty().bind(toDo.nameProperty());
        fxTime.textProperty().bind(toDo.timeProperty());
        fxDate.textProperty().bind(toDo.dateProperty());
        fxBudget.textProperty().bind(toDo.budgetProperty());

    }

    @FXML
    private void onDelete() {
        ferd.toDoList.remove(toDo);

        ((FlowPane)this.getParent()).getChildren().remove(this);
    }
}
