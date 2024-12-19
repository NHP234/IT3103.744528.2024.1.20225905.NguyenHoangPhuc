package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private TextField directorInput;
    private TextField lengthInput;
    private StoreScreen storeScreen; // Reference to the current StoreScreen

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        this.storeScreen = storeScreen; // Save the reference

        // Add DVD-specific fields
        VBox root = (VBox) this.getScene().getRoot();
        Label directorLabel = new Label("Director: ");
        directorInput = new TextField();

        Label lengthLabel = new Label("Length (minutes): ");
        lengthInput = new TextField();

        root.getChildren().addAll(directorLabel, directorInput, lengthLabel, lengthInput);

        this.setTitle("Add DVD to Store");
        this.setOnCloseRequest(e -> this.close());

    }

    @Override
    protected void handleSubmit() {
        // Get values from text fields
        String title = titleInput.getText();
        String category = categoryInput.getText();
        float cost = Float.parseFloat(costInput.getText());
        String director = directorInput.getText();
        int length = Integer.parseInt(lengthInput.getText());

        // Create and add DVD to the store
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, title, category, cost, length, director);
        store.addMedia(dvd);

        System.out.println("DVD added to the store: " + dvd);

        this.close();
    }
}