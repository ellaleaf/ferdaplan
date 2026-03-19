package hi.vidmot.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class FerdSpjald extends GridPane {

    public FerdSpjald() {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("ferd-spjald.fxml")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
