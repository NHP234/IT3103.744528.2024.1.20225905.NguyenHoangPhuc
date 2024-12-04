//package hust.soict.hedspi.aims;
//
//import hust.soict.hedspi.aims.cart.Cart;
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//
//public class Aims {
//    public static void main(String[] args) {
//        //Create a new card
//        Cart anOrder = new Cart();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
//                "Animation",19.95f,87,"Roger Allers");
////        anOrder.addDigitalVideoDisc(dvd1);
//
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
//                "Science Fiction", 24.95f, 87, "George Lucas");
////        anOrder.addDigitalVideoDisc(dvd2);
//
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
//                "Animation", 18.99f, 69, "DaodienAladin");
////        anOrder.addDigitalVideoDisc(dvd3);
//
//        //Test Overloading by differing types of parameter
//        DigitalVideoDisc[] dvds = {dvd1, dvd2, dvd3};
//        anOrder.addDigitalVideoDisc(dvds);
//
//        //Test Overloading by differing the number of parameters
////        anOrder.addDigitalVideoDisc(dvd1, dvd2);
//
//
//        anOrder.removeDigitalVideoDisc(dvd2);
//
//        System.out.println("Total cost is: ");
//        System.out.print(anOrder.totalCost());
//        System.out.println("dvd3's id: " + dvd3.getId());
//
//    }
//}