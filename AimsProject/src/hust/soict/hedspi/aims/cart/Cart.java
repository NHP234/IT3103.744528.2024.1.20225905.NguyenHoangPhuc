package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the cart");
        }
        else {
            System.out.println("The cart is almost full!");
        }
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from the cart");
        }
        else {
            System.out.println("The media is not in the Cart!");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for(Media media : itemsOrdered) {
            totalCost += media.getCost();
        }

        return totalCost;
    }

//    public void print()
//    {
//        System.out.println("Nguyen Hoang Phuc 20225905\n***********************CART***********************\nOrdered Items:\n");
//        for(Media media : itemsOrdered) {
//            System.out.println(media.toString());
//        }
//        System.out.println("Total cost: " + this.totalCost() + "\n***************************************************");
//    }
    //Nguyen Hoang Phuc 20225905
//    public void searchByID(int id) {
//        for(int i = 0; i < qtyOrdered; i++) {
//            if(itemsOrdered[i].getID() == id) {
//                System.out.println("Found: " + itemsOrdered[i].toString());
//                return;
//            }
//        }
//        System.out.println("No such ID: " + id + "\n");
//    }
//
//    public void searchByTitle(String title) {
//        for(int i = 0; i < qtyOrdered; i++) {
//            if(itemsOrdered[i].isMatch(title)) {
//                System.out.println("Found: " + itemsOrdered[i].toString());
//                return;
//            }
//        }
//        System.out.println("No such title: " + title + "\n");
//    }
}