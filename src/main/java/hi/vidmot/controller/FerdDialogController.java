package hi.vidmot.controller;

import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FerdDialogController {
    @FXML private TextField fxName;
    @FXML private TextField fxDestination;
    @FXML private TextField fxDate;

    public Ferd getResult() {
        String name = fxName.getText();
        String destination = fxDestination.getText();
        String date = fxDate.getText();
        return new Ferd(name, destination, date);
    }
}
