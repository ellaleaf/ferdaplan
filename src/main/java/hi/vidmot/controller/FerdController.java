package hi.vidmot.controller;

import hi.vidmot.switcher.View;
import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.Date;

import static hi.vidmot.switcher.ViewSwitcher.switchTo;

public class FerdController implements GognInterface{
    private Ferd f;
    @FXML
    private TextField fxName;
    @FXML private TextField fxDestination;
    @FXML private DatePicker fxDateFrom;
    @FXML private DatePicker fxDateTo;
    @FXML private TextField fxBudget;
    @Override
    public void setGogn(Object data) {
        f = (Ferd) data;
        fxName.textProperty().bind(f.name);
        fxDestination.textProperty().bind(f.destination);
        fxDateFrom.promptTextProperty().bind(f.dateFrom);
        fxDateTo.promptTextProperty().bind(f.dateTo);
        fxBudget.textProperty().bind(f.budget);

    }

    /**
     * breytir senu frá FERD í ADAL
     */
    public void onILagi(){
        View view = View.ADAL;
        switchTo(view);
    }
}
