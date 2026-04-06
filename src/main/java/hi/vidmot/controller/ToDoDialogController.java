package hi.vidmot.controller;

import hi.vinnsla.Ferd;
import hi.vinnsla.Ferdaplan;
import hi.vinnsla.ToDo;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import static hi.vinnsla.Ferdaplan.ferdaplan;

public class ToDoDialogController {

    @FXML
    private TextField fxName;
    @FXML private TextField fxTime;
    @FXML private DatePicker fxDateFrom;
    @FXML private TextField fxBudget;
    public Ferd ferd;

    public ToDo getResult() {
        String name = fxName.getText();
        String time = fxTime.getText();
        String date = fxDateFrom.getValue().toString();
        String budget = fxBudget.getText();
        return new ToDo(name, time, date, budget);
    }
}
