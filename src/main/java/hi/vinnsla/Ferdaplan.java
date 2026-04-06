package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ferdaplan {
    public static ObservableList<Ferd> ferdaplan = FXCollections.observableArrayList(new Ferd("Shrines", "Japan", "12.08.2026", "12.08.2026", "300000"), new Ferd("great wall", "China", "10.04.2026", "10.04.2026", "300000"));

    public static Ferd getFerd(String name) {
        for  (Ferd f : ferdaplan) {
            if (f.name.equals(name)) {
                return f;
            }
        }
        return null;
    }
}

