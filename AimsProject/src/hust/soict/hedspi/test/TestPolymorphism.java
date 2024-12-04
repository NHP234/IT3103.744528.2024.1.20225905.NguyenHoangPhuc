//package hust.soict.hedspi.test;
//
//import hust.soict.hedspi.aims.media.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestPolymorphism {
//    public static void main(String[] args) {
//        List<Media> mediae = new ArrayList<Media>();
//        Track track1 = new Track("track1", 10);
//        Track track2 = new Track("track2", 20);
//
//
//        CompactDisc cd1 = new CompactDisc(100,"cd1", "cd1 category",100,50,
//                "cd1 director", "cd1 artist");
//        cd1.addTrack(track1); cd1.addTrack(track2);
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("dvd1", "dvd1 category",
//                100, 40, "dvd1 director");
//
//        Book book1 = new Book(1000, "book1", "category book1", 40);
//        book1.addAuthor("Author 1"); book1.addAuthor("Author 2"); book1.addAuthor("Author 3");
//
//        mediae.add(cd1);
//        mediae.add(dvd1);
//        mediae.add(book1);
//        for(Media media : mediae){
//            System.out.println(media.toString());
//        }
//    }
//}
