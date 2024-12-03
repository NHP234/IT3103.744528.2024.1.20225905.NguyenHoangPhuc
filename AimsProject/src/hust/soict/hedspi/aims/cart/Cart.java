package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc '" + disc.getTitle() + "' has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    //Overloading by differing types of parameter
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for(DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    //Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int check = MAX_NUMBERS_ORDERED + 1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle()))
                check = i;
        }

        if (check != MAX_NUMBERS_ORDERED + 1) {
            for (int i = check; i < qtyOrdered; i++)
                itemsOrdered[i] = itemsOrdered[i + 1];

            System.out.println("The disc '" + disc.getTitle() + "' has been removed.");
            qtyOrdered--;
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }

        return totalCost;
    }

    public void print()
    {
        System.out.println("Nguyen Hoang Phuc 20225905\n***********************CART***********************\nOrdered Items:\n");
        for(int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + this.totalCost() + "\n***************************************************");
    }
    //Nguyen Hoang Phuc 20225905
    public void searchByID(int id) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getID() == id) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("No such ID: " + id + "\n");
    }

    public void searchByTitle(String title) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                return;
            }
        }
        System.out.println("No such title: " + title + "\n");
    }
}