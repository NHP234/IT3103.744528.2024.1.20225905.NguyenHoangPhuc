package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();



    public static void main(String[] args) {
        // Add 4 books
        store.addMedia(new Book(1, "The Great Gatsby", "Novel", 10.99f));
        store.addMedia(new Book(2, "To Kill a Mockingbird", "Novel", 8.99f));
        store.addMedia(new Book(3, "1984", "Dystopian", 14.99f));
        store.addMedia(new Book(4, "Moby-Dick", "Adventure", 9.99f));

        // Add 4 DVDs
        store.addMedia(new DigitalVideoDisc(5, "Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan"));
        store.addMedia(new DigitalVideoDisc(6, "The Matrix", "Sci-Fi", 14.99f, 136, "The Wachowskis"));
        store.addMedia(new DigitalVideoDisc(7, "The Godfather", "Crime", 24.99f, 175, "Francis Ford Coppola"));
        store.addMedia(new DigitalVideoDisc(8, "Pulp Fiction", "Crime", 18.99f, 154, "Quentin Tarantino"));

        // Add 4 CDs
        store.addMedia(new CompactDisc(9, "Thriller", "Pop", 15.99f, 42, "Michael Jackson", "Michael Jackson"));
        store.addMedia(new CompactDisc(10, "Back in Black", "Rock", 12.99f, 41, "Robert John Lange", "AC/DC"));
        store.addMedia(new CompactDisc(11, "The Dark Side of the Moon", "Rock", 16.99f, 43, "Pink Floyd", "Pink Floyd"));
        store.addMedia(new CompactDisc(12, "The Wall", "Rock", 18.99f, 81, "Pink Floyd", "Pink Floyd"));

        store.addMedia(new DigitalVideoDisc(13, "葬送のフリーレン", "Fantasy", 99.99f, 154, "Keiichirō Saitō"));


        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("Nguyen Hoang Phuc 20225905\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore(Scanner scanner) {
        System.out.println("Items in store:");
        for(Media media : store.getItemsInStore()) {
            System.out.println(media);
        }

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails(Scanner scanner) {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if(media != null) {
            System.out.println(media);
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if(media instanceof Playable) {
                            ((Playable) media).play();
                        }
                        else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        }
        else {
            System.out.println("Media not found.");
        }
    }

    private static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if(media != null) {
            cart.addMedia(media);
        }
        else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if(media != null) {
            if(media instanceof Playable) {
                ((Playable) media).play();
            }
            else {
                System.out.println("This media cannot be played.");
            }
        }
        else {
            System.out.println("Media not found.");
        }
    }

    private static void updateStore(Scanner scanner) {
        System.out.println("Update store: ");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0.Back");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter the title of the media (CD/DVD/Book): ");
                String type = scanner.nextLine();

                System.out.println("Enter the ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the title: ");
                String title = scanner.nextLine();

                System.out.println("Enter the category: ");
                String category = scanner.nextLine();

                System.out.println("Enter the cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();

                Media media = null;
                switch(type.toUpperCase()) {
                    case "CD":
                        System.out.println("Enter the length:");
                        int cdLength = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Eneter the director:");
                        String cdDirector = scanner.nextLine();

                        System.out.println("Enter the artist: ");
                        String artist = scanner.nextLine();

                        media = new CompactDisc(id, title, category, cost, cdLength, cdDirector, artist);
                        break;
                    case "DVD":
                        System.out.println("Enter the length:");
                        int dvdLength = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter the director:");
                        String dvdDirector = scanner.nextLine();

                        media = new DigitalVideoDisc(id, title, category, cost, dvdLength, dvdDirector);
                        break;
                    case "Book":
                        media = new Book(id, title, category, cost);
                        break;
                    default:
                        System.out.println("Invalid media type.");
                        return;
                }
                store.addMedia(media);
                break;

            case 2:
                System.out.println("Enter the ID of the media to remove: ");
                int removeId = scanner.nextInt();
                scanner.nextLine();

                Media mediaToRemove = store.findMediaById(removeId);
                if(mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                    System.out.println("Removed media from store.");
                }
                else {
                    System.out.println("Media not found.");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void seeCurrentCart(Scanner scanner) {
        System.out.println("Current cart: ");
        for(Media media : cart.getItemsOrdered()) {
            System.out.println(media);
        }

        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMediasInCart(scanner);
                    break;
                case 2:
                    sortMediasInCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMediaInCart(scanner);
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void filterMediasInCart(Scanner scanner) {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                System.out.println("Enter the ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for(Media media : cart.getItemsOrdered()) {
                    if(media.getId() == id) {
                        System.out.println(media);
                    }
                }
                break;
            case 2:
                System.out.println("Enter the title: ");
                String title = scanner.nextLine();
                for(Media media : cart.getItemsOrdered()) {
                    if(media.getTitle().equalsIgnoreCase(title)) {
                        System.out.println(media);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void sortMediasInCart(Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        System.out.println("Sorted Cart:");
        for(Media media : cart.getItemsOrdered()) {
            System.out.println(media);
        }
    }

    private static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the ID of the media to remove from cart:");
        int id = scanner.nextInt();
        Media media = cart.findMediaById(id);

        if(media != null) {
            cart.removeMedia(media);
        }
        else {
            System.out.println("Media not found in cart.");
        }
    }

    private static void playMediaInCart(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);

        if (media != null) {
            if(media instanceof Playable) {
                ((Playable)media).play();
            }
            else {
                System.out.println("This media is not playable.");
            }
        }
        else {
            System.out.println("Media not found in cart.");
        }
    }

    private static void placeOrder() {
        System.out.println("An order has been created.");
        cart.clear();
    }
}