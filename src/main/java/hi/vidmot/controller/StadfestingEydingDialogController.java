package hi.vidmot.controller;

import hi.vidmot.ferdaPlanApp;
import hi.vinnsla.Ferd;
import hi.vinnsla.Ferdaplan;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class StadfestingEydingDialogController {

    @FXML public static Label fxFerdNafn;

    private void initData() {
        fxFerdNafn.textProperty().bind(AdalController.ferdNafn);
    }
    public static void setupDialog(Ferd ferd) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ferdaPlanApp.class.getResource("stadfestingEyda-dialog.fxml"));
            fxmlLoader.load();

            Dialog dialog = new Dialog();
            dialog.getDialogPane().setContent(fxmlLoader.getRoot());

            ButtonType okButton = new ButtonType("Í lagi", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Hætta við", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            dialog.getDialogPane().lookupButton(okButton).setStyle("-fx-font-size: 24;");
            dialog.getDialogPane().lookupButton(cancelButton).setStyle("-fx-font-size: 24;");

            Optional result = dialog.showAndWait();

            if (result.isPresent() && result.get() == okButton) {
                Ferdaplan.ferdaplan.remove(ferd);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
