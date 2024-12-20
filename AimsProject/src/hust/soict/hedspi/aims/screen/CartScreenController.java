package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//Phuc 20225905
public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());


        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            Platform.runLater(() -> updateButtonBar(newValue));
                        }
                    }
                }
        );
        updateTotalCost();

    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        if (media != null) {
            cart.removeMedia(media);
            Platform.runLater(() -> updateTotalCost());
        }
    }

    @FXML
    private Label lblTotalCost; // Add this from FXML

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream old = System.out;
                System.setOut(ps);

                ((Playable) media).play(); // Call the play() method

                // Restore console output
                System.out.flush();
                System.setOut(old);

                // Show captured output in an alert
                String playOutput = baos.toString();
                Platform.runLater(() -> showInfo(playOutput));
            } catch (Exception e) {
                Platform.runLater(() -> showError("Error playing media: " + e.getMessage()));
            }

        } else {
            Platform.runLater(() -> showError("This item is not playable."));
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().size() > 0) {
            String orderMessage = "Order placed successfully with " + cart.getItemsOrdered().size() + " items.";
            cart.clear(); // Clear the cart immediately

            Platform.runLater(() -> {
                showInfo(orderMessage); // Show message on FX thread
                updateTotalCost(); // Update cost on FX thread (now that cart is cleared)
            });
        } else {
            Platform.runLater(() -> showError("Your cart is empty!"));
        }
    }

    // Update the total cost label dynamically
    public void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void showError(String message) {
        showAlert(message, Alert.AlertType.ERROR);
    }

    private void showInfo(String message) {
        showAlert(message, Alert.AlertType.INFORMATION);
    }

    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
