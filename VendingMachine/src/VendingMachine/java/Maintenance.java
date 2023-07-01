package VendingMachine.java;

public class Maintenance {
    private VendingMachine vendingMachine;
    private double revenue;

    public Maintenance(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        revenue = vendingMachine.getVendorCash();
    }

    public void restockItem(Item item, int quantity) {
        vendingMachine.addItem(item, quantity);
    }

    public void changeItemPrice(Item item, double newPrice) {
        item.setPrice(newPrice);
    }

    public double collectRevenue() {
        vendingMachine.resetVendorCash();
        return revenue;
    }

    public void replenishBalance(Money money) {
        vendingMachine.insertMoney(money);
    }
    public double getRevenue() {
        return revenue;
    }

}
