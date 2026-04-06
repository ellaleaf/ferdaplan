package hi.vidmot.controller;

import hi.vidmot.FerdaplanApp;
import hi.vinnsla.ToDo;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Window;

import java.util.Optional;

public class ToDoDialogWrapper {
    public Optional<ToDo> birtaDialog(Window owner) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FerdaplanApp.class.getResource("ny-toDo-dialog.fxml"));
            fxmlLoader.load();

            ToDoDialogController toDoDialogController = fxmlLoader.getController();

            Dialog dialog = new Dialog();
            dialog.initOwner(owner);
            dialog.getDialogPane().setContent(fxmlLoader.getRoot());

            String css = this.getClass().getResource("/hi/vidmot/css/buttons.css").toExternalForm();
            dialog.getDialogPane().getStylesheets().add(css);

            ButtonType okButton = new ButtonType("Í lagi", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Hætta við", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            dialog.getDialogPane().lookupButton(okButton).setStyle("-fx-font-size: 12;");
            dialog.getDialogPane().lookupButton(okButton).getStyleClass().add("blueButton");
            dialog.getDialogPane().lookupButton(cancelButton).setStyle("-fx-font-size: 12;");
            dialog.getDialogPane().lookupButton(cancelButton).getStyleClass().add("redButton");

            dialog.setResultConverter(button -> {
                if (button == okButton) {
                    return toDoDialogController.getResult();
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
