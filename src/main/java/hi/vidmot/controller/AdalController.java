package hi.vidmot.controller;

import hi.vidmot.view.FerdSpjald;
import hi.vinnsla.Ferd;
import hi.vinnsla.Ferdaplan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.stage.Window;

import java.util.Optional;

import static hi.vinnsla.Ferdaplan.ferdaplan;

public class AdalController {

    @FXML private FlowPane fxCards;

    public void initialize(){
        // iterate ferdaplan
        for (Ferd ferd : ferdaplan) {
            //make cards
            FerdSpjald spjald = new FerdSpjald();

            // set items
            spjald.setItems(ferd);

            fxCards.getChildren().add(spjald);
        }
        System.out.println("Fjöldi ferða: " + ferdaplan.size());

    }

    @FXML
    private void onAdd(ActionEvent event) {
        Window owner = ((Node) event.getSource()).getScene().getWindow();
        FerdDialogWrapper ferdDialogWrapper = new FerdDialogWrapper();

        Optional<Ferd> ferd = ferdDialogWrapper.birtaDialog(owner);

        if(ferd.isPresent()) {
            Ferdaplan.ferdaplan.add(ferd.get());
        }

        FerdSpjald spjald = new FerdSpjald();

        // set items
        spjald.setItems(ferd.get());

        fxCards.getChildren().add(spjald);
    }
}
