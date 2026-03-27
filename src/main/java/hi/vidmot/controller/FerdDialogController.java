package hi.vidmot.controller;

import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FerdDialogController {

    @FXML private TextField fxName;
    @FXML private TextField fxDestination;
    @FXML private DatePicker fxDateFrom;
    @FXML private DatePicker fxDateTo;
    @FXML private TextField fxBudget;

    public Ferd getResult() {
        String name = fxName.getText();
        String destination = fxDestination.getText();
        String dateFrom = fxDateFrom.getValue().toString();
        String dateTo = fxDateTo.getValue().toString();
        String budget = fxBudget.getText();
        return new Ferd(name, destination, dateFrom, dateTo, budget);
    }
}
