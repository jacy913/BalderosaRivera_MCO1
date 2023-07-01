package VendingMachine.java;

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Slot> slots;
    private ArrayList<Transaction> transactions;

    private Inventory inventory;

    private ArrayList<Money> money;
    private double balance;
    private double vendorCash;

    public VendingMachine() {
        this.slots = new ArrayList<>();
        this.balance = 0;
        this.transactions = new ArrayList<Transaction>();
        this.inventory = new Inventory(this);
        this.money = new ArrayList<Money>();
    }

    public void addItem(Item item, int amt) {
        // Check if the item already exists in the slots
        for (Slot slot : slots) {
            if (slot.getItem().equals(item)) {
                slot.setQuantity(slot.getQuantity() + amt);
                return;
            }
        }

        // If the item does not exist, create a new slot
        slots.add(new Slot(item, amt));
    }


    public int removeItem(Item item, int quantity) {
        for (Slot slot : slots) {
            if (slot.getItem().equals(item)) {
                slot.removeItem(quantity);
                return slot.getQuantity();
            }
        }
        return -1;
    }

    public void insertMoney(Money money) {
        this.money.add(new Money(money.getDenomination(), money.getBills()));
        double inserted = money.getDenomination() * money.getBills();
        balance += inserted;

        System.out.println("You have inserted " + money.getBills() + " bills worth " + money.getDenomination() + " each.");
        System.out.println("You have " + inserted + " to spend");
    }

    public Transaction purchaseItem(Item item, int amt) {
        Transaction transactions = new Transaction(item, item.getPrice(), amt);
        this.transactions.add(transactions);

        boolean isConfirmed = transactions.promptConfirmation();

        if (transactions.checkSufficiency(balance) && isConfirmed) {
            balance -= transactions.getAmountPaid();
            vendorCash += transactions.getAmountPaid();
            removeItem(item, amt);
            return transactions;
        } else if (isConfirmed == false) {
            System.out.println("Cancelled purchase. " + transactions.calculateChange(balance) + " returned.");
            balance = 0;
            return null;
        } else {
            System.out.println("Insufficient funds. Please insert more money.");
            System.out.println("Cancelled purchase. " + transactions.calculateChange(balance) + " returned.");
            return null; // Return null to indicate the purchase couldn't be completed
        }
    }

    public void printTransactionReceipts() {
        for (Transaction transaction : transactions) {
            if (transactions != null) {
                transaction.printReceipt();
            } else {
                System.out.println("Purchase did not go through.");
            }
        }
    }


    public void displayStartingInventory() {
        inventory.displayInventory(slots);
    }

    public void resetVendorCash() {
        vendorCash = 0;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public double getBalance() {
        return balance;
    }

    public double getVendorCash() {
        return vendorCash;
    }
}

