package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AddItemToStoreScreen extends Stage {
    protected Store store;
    protected StoreScreen storeScreen; // Add a reference to the StoreScreen

    // Shared fields
    protected TextField titleInput;
    protected TextField categoryInput;
    protected TextField costInput;

    public AddItemToStoreScreen(Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen; // Store the StoreScreen reference

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        MenuBar menuBar = createMenuBar();

        // Shared input fields
        Label titleLabel = new Label("Title: ");
        titleInput = new TextField();

        Label categoryLabel = new Label("Category: ");
        categoryInput = new TextField();

        Label costLabel = new Label("Cost: ");
        costInput = new TextField();

        Button submitButton = new Button("Add");
        submitButton.setOnAction(e -> handleSubmit());

        root.getChildren().addAll(menuBar, titleLabel, titleInput, categoryLabel, categoryInput, costLabel, costInput, submitButton);

        this.setOnCloseRequest(e -> this.close());

        Scene scene = new Scene(root, 400, 300);
        this.setScene(scene);
    }

    // Shared menu bar
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Options");
        MenuItem viewStore = new MenuItem("View Store");

        viewStore.setOnAction(e -> {
            // Trigger a refresh on the existing StoreScreen
            storeScreen.refreshStore();
        });

        menu.getItems().addAll(viewStore);
        menuBar.getMenus().add(menu);

        return menuBar;
    }

    // Abstract method to be implemented by subclasses for processing input
    abstract protected void handleSubmit();
}