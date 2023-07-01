package VendingMachine.java;

public class Slot {
    private Item item;
    private int quantity;

    public Slot(Item item, int q) {
        this.item = item;
        quantity = q;
    }

    public void removeItem(int amt) {
        quantity -= amt;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        quantity = q;
    }
}

