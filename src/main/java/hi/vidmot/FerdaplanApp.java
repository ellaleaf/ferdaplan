package hi.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static hi.vidmot.switcher.ViewSwitcher.setScene;

public class FerdaplanApp extends javafx.application.Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FerdaplanApp.class.getResource("adal-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("Ferdaplan");

        stage.setScene(scene);
        setScene(scene);

        stage.show();
    }
}
