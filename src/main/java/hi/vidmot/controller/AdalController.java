package hi.vidmot.controller;

import hi.vidmot.view.FerdSpjald;
import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

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
    private void onAdd() {

    }
}
