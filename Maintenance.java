package VendingMachine.java;

public class Maintenance {
    private VendingMachine vendingMachine;
    private double revenue;

    /**
     * Constructor of an object of the Maintenance class.
     * @param vendingMachine accepts the vending machine object to perform maintenance on.
     */
    public Maintenance(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        revenue = vendingMachine.getVendorCash();
    }

    /**
     * Restocks an item with the supplied amount.
     * @param item Accepts the item object.
     * @param quantity Accepts a quantity of that item in integer format.
     */
    public void restockItem(Item item, int quantity) {
        vendingMachine.addItem(item, quantity);
    }

    /**
     * Sets a new price for a certain item for maintenance.
     * @param item Specifies the item for price change.
     * @param newPrice Accepts the new price of which the specified item takes.
     */
    public void changeItemPrice(Item item, double newPrice) {
        item.setPrice(newPrice);
    }

    /**
     * Collects the revenue earned from the vending machine.
     * @return Returns the revenue.
     */
    public double collectRevenue() {
        vendingMachine.resetVendorCash();
        return revenue;
    }

    /**
     * Replenishes the balance of the vending machine, for change purposes.
     * @param money Accepts an object of class money for replenishment.
     */
    public void replenishBalance(Money money) {
        vendingMachine.insertMoney(money);
    }
    public double getRevenue() {
        return revenue;
    }

}
