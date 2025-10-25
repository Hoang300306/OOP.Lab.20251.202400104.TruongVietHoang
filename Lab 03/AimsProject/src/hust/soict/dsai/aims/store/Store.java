package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyInStore = 0; 

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_ORDERED) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD \"" + disc.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD \"" + disc.getTitle() + "\" was not found in the store.");
        }
    }
    public void printStore() {
        System.out.println("\n*** DVDs available in store ***");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].getTitle());
        }
    }
}
