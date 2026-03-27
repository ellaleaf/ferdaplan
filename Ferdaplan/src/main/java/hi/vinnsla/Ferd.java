package hi.vinnsla;

import javafx.beans.property.SimpleStringProperty;

public class Ferd {

    public SimpleStringProperty name;
    public SimpleStringProperty destination;
    public SimpleStringProperty date;

    public Ferd(String name, String destination, String date) {
        this.name = new SimpleStringProperty(name);
        this.destination = new SimpleStringProperty(destination);
        this.date = new SimpleStringProperty(date);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
