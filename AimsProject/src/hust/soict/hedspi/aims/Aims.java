package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        //Create a new card
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);

        //Test Overloading by differing types of parameter
        DigitalVideoDisc[] dvds = {dvd1, dvd2, dvd3};
        anOrder.addDigitalVideoDisc(dvds);

        //Test Overloading by differing the number of parameters
//        anOrder.addDigitalVideoDisc(dvd1, dvd2);


        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("Total cost is: ");
        System.out.print(anOrder.totalCost());
        System.out.println("dvd3's id: " + dvd3.getID());

    }
}