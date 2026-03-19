module ferdaPlan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens hi.vidmot to javafx.fxml;
    opens hi.vidmot.controller to javafx.fxml;
    exports hi.vidmot;
    exports hi.vinnsla;
}