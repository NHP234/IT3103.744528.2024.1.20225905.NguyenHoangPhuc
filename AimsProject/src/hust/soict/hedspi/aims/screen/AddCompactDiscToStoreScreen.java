package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private TextField artistInput;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        // Add artist-specific field
        VBox root = (VBox) this.getScene().getRoot();
        Label artistLabel = new Label("Artist: ");
        artistInput = new TextField();
        root.getChildren().add(artistLabel);
        root.getChildren().add(artistInput);

        this.setTitle("Add CD to Store");
    }

    @Override
    protected void handleSubmit() {
        // Get values from text fields
        String title = titleInput.getText();
        String category = categoryInput.getText();
        float cost = Float.parseFloat(costInput.getText());
        String artist = artistInput.getText();

        // Create and add CompactDisc to the store
        CompactDisc cd = new CompactDisc(1, title, category, cost, 0, "Unknown", artist);
        store.addMedia(cd);

        System.out.println("CD added to the store: " + cd);
        this.close();
    }
}