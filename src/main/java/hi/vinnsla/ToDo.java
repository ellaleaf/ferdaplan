package hi.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static hi.vinnsla.Ferdaplan.ferdaplan;

public class ToDo {

    private SimpleStringProperty name;
    private SimpleStringProperty date;
    private SimpleStringProperty time;
    private SimpleStringProperty budget;


    public ToDo (String name, String time, String date, String budget) {
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.budget = new SimpleStringProperty(budget);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty dateProperty() { return date; }
    public StringProperty timeProperty() { return time; }
    public StringProperty budgetProperty() { return budget; }


    public String toString() {
        return name.get();
    }

    public Ferd getFerd(ToDo todo) {
        for (Ferd ferd: ferdaplan) {
            if (ferd.toDoList.contains(todo)) {
                return ferd;
            }
        }
        return null;
    }
}
