package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Phuc 20225905
public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private CartScreen cartScreen;

    public static void initializeJavaFX() {
        try {
            javafx.application.Platform.startup(() -> {}); // Initialize JavaFX platform
        } catch (IllegalStateException ex) {
            // JavaFX already initialized: Ignore exception
        }
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        smUpdateStore.add(createMenuItem("Add Book", e -> showAddBookScreen()));
        smUpdateStore.add(createMenuItem("Add CD", e -> showAddCDScreen()));
        smUpdateStore.add(createMenuItem("Add DVD", e -> showAddDVDScreen()));

        menu.add(smUpdateStore);
        menu.add(createMenuItem("View store", e -> this.setVisible(true)));
        menu.add(createMenuItem("View cart", e -> new CartScreen(cart)));     // Fix for view cart


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JMenuItem createMenuItem(String title, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(action);
        return menuItem;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Phuc-20225905 AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> new CartScreen(cart));  // Open CartScreen


        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (mediaInStore.isEmpty()) {
            // If the store is empty, display a placeholder message
            center.setLayout(new BorderLayout());
            JLabel emptyMessage = new JLabel("The store is currently empty.", SwingConstants.CENTER);
            emptyMessage.setFont(new Font("Arial", Font.ITALIC, 20));
            center.add(emptyMessage, BorderLayout.CENTER);
        } else {
            // Fill the grid with available media, up to 9 items
            for (int i = 0; i < Math.min(mediaInStore.size(), 9); i++) {
                Media media = mediaInStore.get(i);
                MediaStore cell = new MediaStore(media, cart);
                center.add(cell);
            }

            // Fill remaining grid slots with empty spaces
            int emptySlots = 9 - mediaInStore.size();
            for (int i = 0; i < emptySlots; i++) {
                JPanel emptyCell = new JPanel(); // Empty cell to maintain grid alignment
                center.add(emptyCell);
            }
        }

        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;
        this.cart = new Cart();

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
    }

    public void refreshStore() {
        // Get the content pane
        Container cp = getContentPane();

        // Remove the old center panel
        cp.remove(1); // 0 = North panel, 1 = Center panel (grid)

        // Add the updated center panel
        cp.add(createCenter(), BorderLayout.CENTER);

        // Revalidate and repaint to refresh the UI
        cp.revalidate();
        cp.repaint();
    }

    // Inside the StoreScreen class, add these new methods:

    private void showAddBookScreen() {
        javafx.application.Platform.runLater(() -> {
            AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store, this);
            addBookScreen.showAndWait(); // Show and wait for the stage to close
            refreshStore(); // Refresh after the stage is closed
        });
    }

    private void showAddCDScreen() {
        javafx.application.Platform.runLater(() -> {
            AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store, this);
            addCDScreen.showAndWait(); // Show and wait for the stage to close
            refreshStore(); // Refresh after the stage is closed
        });
    }

    private void showAddDVDScreen() {
        javafx.application.Platform.runLater(() -> {
            AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store, this);
            addDVDScreen.showAndWait(); // Show and wait for the stage to close
            refreshStore(); // Refresh after the stage is closed
        });
    }

}
