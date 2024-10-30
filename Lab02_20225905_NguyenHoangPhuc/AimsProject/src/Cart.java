// Nguyen Hoang Phuc 20225905
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if(qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
            return;
        }
        itemsOrdered[qtyOrdered] = dvd;
        qtyOrdered++;
        System.out.println("The disc has been added.");
    }
    void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] == dvd) {
                for(int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
            }
        }
        qtyOrdered--;
    }
    //Nguyen Hoang Phuc 20225905
    float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
