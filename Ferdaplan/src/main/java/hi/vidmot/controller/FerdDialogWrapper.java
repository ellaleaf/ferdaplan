package hi.vidmot.controller;

import hi.vidmot.ferdaPlanApp;
import hi.vinnsla.Ferd;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Window;

import java.util.Optional;

public class FerdDialogWrapper {

    public Optional<Ferd> birtaDialog(Window owner) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ferdaPlanApp.class.getResource("ny-ferd-dialog.fxml"));
            fxmlLoader.load();

            FerdDialogController ferdDialogController = fxmlLoader.getController();

            Dialog dialog = new Dialog();
            dialog.initOwner(owner);
            dialog.getDialogPane().setContent(fxmlLoader.getRoot());

            ButtonType okButton = new ButtonType("Í lagi", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Hætta við", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            dialog.getDialogPane().lookupButton(okButton).setStyle("-fx-font-size: 24;");
            dialog.getDialogPane().lookupButton(cancelButton).setStyle("-fx-font-size: 24;");

            dialog.setResultConverter(button -> {
                if (button == okButton) {
                    return ferdDialogController.getResult();
                }
                return null;
            });

            return dialog.showAndWait();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

}
