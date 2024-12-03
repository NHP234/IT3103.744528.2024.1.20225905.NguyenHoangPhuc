package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS = 2000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS];
    private int qtyAdded = 0;
    public void addDVD(DigitalVideoDisc dvd) {
        if(qtyAdded == MAX_NUMBERS) {
            System.out.println("The store is full!");
            return;
        }
        itemsInStore[qtyAdded] = dvd;
        qtyAdded++;
        System.out.println("The disc has been added.");
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        for(int i = 0; i < qtyAdded; i++) {
            if(itemsInStore[i] == dvd) {
                for(int j = i; j < qtyAdded - 1; j++) {
                    itemsInStore[j] = itemsInStore[j+1];
                }
            }
        }
        qtyAdded--;
    }
}
