//package hust.soict.hedspi.test;
//
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//import hust.soict.hedspi.aims.media.Media;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class sortTest {
//    public static void main(String[] args) {
//        List<Media> mediaList = new ArrayList<Media>();
//
//        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
//        mediaList.add(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 124, "George Lucas"));
//        mediaList.add(new DigitalVideoDisc("Aladdin", "Animation", 18.99f, 90, "John Musker"));
//
//        //sort by title then by cost
//        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
//        System.out.println("Sorted by title then cost:");
//        for (Media media : mediaList) {
//            System.out.println(media);
//        }
//        // Sort by cost then title
//        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
//        System.out.println("\nSorted by cost then title:");
//        for (Media media : mediaList) {
//            System.out.println(media);
//        }
//    }
//
//}
