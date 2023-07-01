package VendingMachine.java;

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Slot> slots;
    private ArrayList<Transaction> transactions;

    private Inventory inventory;

    private ArrayList<Money> money;
    private double balance;
    private double vendorCash;

    /**
     * Constructor of a new vending machine object of the VendingMachine class.
     */
    public VendingMachine() {
        this.slots = new ArrayList<>();
        this.balance = 0;
        this.transactions = new ArrayList<Transaction>();
        this.inventory = new Inventory(this);
        this.money = new ArrayList<Money>();
    }

    /**
     * This method adds a brand new item to the vending machine.
     * @param item Accepts the new item to be added to the vending machine.
     * @param amt Accepts the initial amount of which that item is supplied.
     */
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


    /**
     * This method removes items from the vending machine, by calling another method from Slot.
     * @param item Accepts the certain item of which needs to be removed.
     * @param quantity Accepts the amount of those items to be removed.
     * @return Returns the new quantity if successful, or returns -1 if otherwise.
     */
    public int removeItem(Item item, int quantity) {
        for (Slot slot : slots) {
            if (slot.getItem().equals(item)) {
                slot.removeItem(quantity);
                return slot.getQuantity();
            }
        }
        return -1;
    }

    /**
     * This method accepts a money object that converts it into the new balance of which the user is free to spend.
     * The vending machine only accepts a Money object which means it is only in denominations and bills.
     * @param money The money object to be accepted in denominations and bills.
     */
    public void insertMoney(Money money) {
        this.money.add(new Money(money.getDenomination(), money.getBills()));
        double inserted = money.getDenomination() * money.getBills();
        balance += inserted;

        System.out.println("You have inserted " + money.getBills() + " bills worth " + money.getDenomination() + " each.");
        System.out.println("You have " + inserted + " to spend");
    }

    /**
     * This method initiates purchases that the user will make. This also creates a new Transaction object
     * since those are where the functionalities are located.
     * This method is merely a facilitator and gatekeeper of those functionalities for a driver class.
     * @param item Accepts the certain item that will be purchased.
     * @param amt Accepts the quantity of that item that will be purchased.
     * @return Returns the transaction if the purchase is successful, or returns null if otherwise.
     */
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

    /**
     * This method prints receipts of the history of all transactions made in this vending machine.
     * This is possible since everytime a purchase happens, a new transaction object is added as an ArrayList.
     * However, if the transaction returned is null, it will not print its receipt (and were no details anyway).
     */
    public void printTransactionReceipts() {
        for (Transaction transaction : transactions) {
            if (transactions != null) {
                transaction.printReceipt();
            } else {
                System.out.println("Purchase did not go through.");
            }
        }
    }


    /**
     * This method displays a menu of the available items in teh vending machine by calling a method in the Inventory class.
     */
    public void displayStartingInventory() {
        inventory.displayInventory(slots);
    }

    /**
     * This method resets the revenue earned to 0 when maintenance is performed.
     */
    public void resetVendorCash() {
        vendorCash = 0;
    }

    // This method returns slots in the vending machine.
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public double getVendorCash() {
        return vendorCash;
    }
}

