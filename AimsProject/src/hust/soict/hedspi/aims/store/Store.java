package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if(!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media has been added to the store");
        }
        else {
            System.out.println("The media is already in the store");
        }
    }
    public void removeMedia(Media media) {
        if(itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store");
        }
        else {
        System.out.println("The media is not in the store");}
    }
}
