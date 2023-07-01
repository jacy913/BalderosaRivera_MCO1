package VendingMachine.java;

public class Slot {
    private Item item;
    private int quantity;

    /**
     * Constructs an object for the class Slot.
     * @param item Accepts an object of the Item class to be placed in the slot.
     * @param q Accepts the quantity of which that item is plenty.
     */
    public Slot(Item item, int q) {
        this.item = item;
        quantity = q;
    }

    /**
     * Removes an items from the slot in the vending machine.
     * @param amt Accepts the amount of that item to be removed.
     */
    public void removeItem(int amt) {
        quantity -= amt;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // Sets the quantity when adding a new item to a slot in the Vending Machine.
    public void setQuantity(int q) {
        quantity = q;
    }
}

