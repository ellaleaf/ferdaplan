package hi.vidmot.controller;

import hi.vidmot.switcher.View;
import hi.vidmot.view.ToDoSpjald;
import hi.vinnsla.Ferd;
import hi.vinnsla.ToDo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Window;

import java.util.Optional;

import static hi.vidmot.switcher.ViewSwitcher.switchTo;

public class FerdController implements GognInterface{
    @FXML
    private TextField fxName;
    @FXML private TextField fxDestination;
    @FXML private DatePicker fxDateFrom;
    @FXML private DatePicker fxDateTo;
    @FXML private TextField fxBudget;
    @FXML private FlowPane fxCards;
    private Ferd ferd;
    @Override
    public void setGogn(Object data) {
        Ferd f = (Ferd) data;
        ferd = f;
        fxName.textProperty().bind(f.name);
        fxDestination.textProperty().bind(f.destination);
        fxDateFrom.promptTextProperty().bind(f.dateFrom);
        fxDateTo.promptTextProperty().bind(f.dateTo);
        fxBudget.textProperty().bind(f.budget);

        runToDoList();
    }

    private void runToDoList(){
        if (!ferd.toDoList.isEmpty()){
            for (ToDo toDo : ferd.toDoList) {
                //make cards
                ToDoSpjald spjald = new ToDoSpjald();

                // set items
                spjald.setItems(toDo);

                fxCards.getChildren().add(spjald);
            }
        }

        System.out.println("Fjöldi ToDo: " + ferd.toDoList.size());
    }

    /**
     * breytir senu frá FERD í ADAL
     */
    public void onILagi(){
        View view = View.ADAL;
        switchTo(view);
    }

    public void onAdd(ActionEvent event) {
        System.out.println("add pressed for: " + fxName.getText());
        // TODO: implement edit logic

        Window owner = ((Node) event.getSource()).getScene().getWindow();
        ToDoDialogWrapper toDoDialogWrapper = new ToDoDialogWrapper();

        Optional<ToDo> toDo = toDoDialogWrapper.birtaDialog(owner);

        if(toDo.isPresent()) {
            ferd.toDoList.add(toDo.get());
        }

        ToDoSpjald spjald = new ToDoSpjald();

        // set items
        spjald.setItems(toDo.get());

        fxCards.getChildren().add(spjald);
    }
}
