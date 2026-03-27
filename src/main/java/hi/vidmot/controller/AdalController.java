package hi.vidmot.controller;

import hi.vidmot.view.FerdSpjald;
import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

import static hi.vinnsla.Ferdaplan.ferdaplan;

public class AdalController {

    @FXML private HBox fxCards;

    public void initialize(){
        // iterate ferdaplan
        for (Ferd ferd : ferdaplan) {
            //make cards
            FerdSpjald spjald = new FerdSpjald();

            // set items
            spjald.setItems(ferd);

            fxCards.getChildren().add(spjald);
        }
    }
}
