package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

//Nguyen Hoang Phuc 20225905
public class CartTest {
    public static void main(String[] args) {
        //Create a new AimsProject.hust.soict.hedspi.aims.cart.hust.soict.dsai.aims.cart.Cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();
        cart.searchByTitle("Star Wars");
        cart.searchByID(4);
    }
}