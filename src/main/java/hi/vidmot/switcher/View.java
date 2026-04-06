package hi.vidmot.switcher;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 *
 * viðbætur fyrir Ferdaplan verkefni
 */
public enum View {
    ADAL("/hi/vidmot/adal-view.fxml"),
    FERD("/hi/vidmot/ferd-view.fxml"),
    TODO("hi/vidmot/ny-toDo-dialog.fxml");


    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
