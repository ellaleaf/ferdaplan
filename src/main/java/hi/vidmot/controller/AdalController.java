package hi.vidmot.controller;

import hi.vidmot.switcher.View;

import hi.vinnsla.Ferd;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

import static hi.vidmot.controller.StadfestingEydingDialogController.setupDialog;
import static hi.vidmot.switcher.ViewSwitcher.switchTo;
import hi.vinnsla.Ferdaplan;
import javafx.stage.Window;

public class AdalController {

    @FXML private ListView<Ferd> fxListView;
    @FXML private Button fxEyda;
    @FXML private Button fxSkoda;
    public static SimpleStringProperty ferdNafn;

    public void initialize() {
        fxListView.setItems(Ferdaplan.ferdaplan);

        fxEyda.disableProperty().bind(fxListView.getSelectionModel().selectedItemProperty().isNull());
        fxSkoda.disableProperty().bind(fxListView.getSelectionModel().selectedItemProperty().isNull());
    }

    /**
     * breytir view frá ADAL í FERD
     */
    public void onSkoda() {
        View view = View.FERD;
        Ferd f = fxListView.getSelectionModel().getSelectedItem();
        switchTo(view,false, f);
    }

    public void onNyja(ActionEvent event) {
        Window owner = ((Node) event.getSource()).getScene().getWindow();
        FerdDialogWrapper ferdDialogWrapper = new FerdDialogWrapper();

        Optional<Ferd> ferd = ferdDialogWrapper.birtaDialog(owner);

        if(ferd.isPresent()) {
            Ferdaplan.ferdaplan.add(ferd.get());
        }
    }

    public void onEyda() throws IOException {
        Ferd f = fxListView.getSelectionModel().getSelectedItem();
        ferdNafn = f.name;
        setupDialog(f);
    }
}
