package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.StoreScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a new store object
        Store store = new Store();

        // Add sample media to the store
//        store.addMedia(new Book(1, "Book Title 1", "Fiction", 20.99f));
//        store.addMedia(new CompactDisc(2, "CD Title 1", "Music", 15.50f, 45, "Artist 1", "Producer 1"));
//        store.addMedia(new DigitalVideoDisc(3, "DVD Title 1", "Action", 30.00f, 120, "Director 1"));
//
//        store.addMedia(new Book(4, "Book Title 2", "Science", 25.99f));
//        store.addMedia(new CompactDisc(5, "CD Title 2", "Classical", 10.00f, 60, "Artist 2", "Producer 2"));
//        store.addMedia(new DigitalVideoDisc(6, "DVD Title 2", "Drama", 35.00f, 150, "Director 2"));
//
//        store.addMedia(new Book(7, "Book Title 3", "History", 12.99f));
//        store.addMedia(new CompactDisc(8, "CD Title 3", "Pop", 18.00f, 50, "Artist 3", "Producer 3"));
//        store.addMedia(new DigitalVideoDisc(9, "DVD Title 3", "Comedy", 28.00f, 95, "Director 3"));

        // Launch the StoreScreen
        SwingUtilities.invokeLater(() -> {
            StoreScreen storeScreen = new StoreScreen(store);
            storeScreen.setSize(1024, 768);
            storeScreen.setVisible(true);
        });
        //new StoreScreen(store);
    }
}