package hi.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Ferd {

    public SimpleStringProperty name;
    public SimpleStringProperty destination;
    public SimpleStringProperty dateFrom;
    public SimpleStringProperty dateTo;
    public SimpleStringProperty budget;
    public int ID = 0;

    public Ferd(String name, String destination, String dateFrom, String dateTo, String budget) {
        this.name = new SimpleStringProperty(name);
        this.destination = new SimpleStringProperty(destination);
        this.dateFrom = new SimpleStringProperty(dateFrom);
        this.dateTo = new SimpleStringProperty(dateTo);
        this.budget = new SimpleStringProperty(budget);
        this.ID += 1;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return dateFrom.get() + " - " + dateTo.get();
    }

    @Override
    public String toString() {
        return name.get();
    }
}
