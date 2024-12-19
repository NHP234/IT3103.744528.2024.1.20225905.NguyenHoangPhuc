package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private TextField authorInput;

    public AddBookToStoreScreen(Store store) {
        super(store);

        // Add author-specific field
        VBox root = (VBox) this.getScene().getRoot();
        Label authorLabel = new Label("Authors (comma-separated): ");
        authorInput = new TextField();
        root.getChildren().add(authorLabel);
        root.getChildren().add(authorInput);

        this.setTitle("Add Book to Store");
    }

    @Override
    protected void handleSubmit() {
        // Get values from text fields
        String title = titleInput.getText();
        String category = categoryInput.getText();
        float cost = Float.parseFloat(costInput.getText());
        String[] authors = authorInput.getText().split(",");

        // Create and add Book to the store
        Book book = new Book(1, title, category, cost);
        for (String author : authors) {
            book.addAuthor(author.trim());
        }
        store.addMedia(book);

        System.out.println("Book added to the store: " + book);
        this.close();
    }
}