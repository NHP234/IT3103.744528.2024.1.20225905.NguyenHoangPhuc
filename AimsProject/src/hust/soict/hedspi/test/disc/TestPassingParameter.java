//package hust.soict.hedspi.test.disc;
//
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//
////Nguyen Hoang Phuc 20225905
//public class TestPassingParameter {
//    public static void main(String[] args) {
//        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//
//        swap(jungleDVD, cinderellaDVD);
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//    }
//    public static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
//
//    public static void changeTitle(DigitalVideoDisc dvd, String tilte) {
//        String oldTitle = dvd.getTitle();
//        dvd.setTitle(tilte);
//        dvd = new DigitalVideoDisc(oldTitle);
//    }
//
//    public static void swap2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//        String tmpTitle = dvd1.getTitle();
//        dvd1.setTitle(dvd2.getTitle());
//        dvd2.setTitle(tmpTitle);
//    }
//}