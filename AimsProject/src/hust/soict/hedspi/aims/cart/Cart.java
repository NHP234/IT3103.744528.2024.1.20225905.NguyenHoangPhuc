package hust.soict.hedspi.aims.cart;
//Nguyen Hoang Phuc 20225905
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
    //Nguyen Hoang Phuc 20225905
    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from the cart");
        }
        else {
            System.out.println("The media is not in the Cart!");
        }
    }
    //Nguyen Hoang Phuc 20225905
    public float totalCost() {
        float totalCost = 0;
        for(Media media : itemsOrdered) {
            totalCost += media.getCost();
        }

        return totalCost;
    }

    public void print()
    {
        System.out.println("Nguyen Hoang Phuc 20225905\n***********************CART***********************\nOrdered Items:\n");
        for(Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "\n***************************************************");
    }
    //Nguyen Hoang Phuc 20225905

    public Media findMediaByTitle(String title) {
        for(Media media : itemsOrdered) {
            if(media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public Media findMediaById(int id) {
        for(Media media : itemsOrdered) {
            if(media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

}