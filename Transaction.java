package VendingMachine.java;
import java.util.Scanner;

public class Transaction {
    private Item item;
    private double price;

    private int quantity;
    private double amountPaid;

    /**
     * Constructs a transaction object of this class when a purchase is made.
     * @param item Accepts an item object to specify which item the purchase will be made on.
     * @param p Accepts the price of that item.
     * @param quantity Accepts the amount of which that item is plenty.
     */
    public Transaction(Item item, double p, int quantity) {
        this.item = item;
        price = p;
        this.quantity = quantity;
        amountPaid = 0;
    }

    /**
     * A series of strings detailing the transaction.
     * Is called when the transaction details are to be cordially printed.
     */
    public void printReceipt() {

        System.out.println("------ Receipt: All Transactions ------");

            System.out.println("Item: " + item.getName());
            System.out.println("Price: " + getPrice());
            System.out.println("Quantity: " + getQuantity());
            System.out.println("Amount Paid: " + getAmountPaid());
            System.out.println("--------------------------------------");

    }

    /**
     * Calculates the amount of change to be returned when a purchase is cancelled or finished.
     * @param insertedAmount Accepts the original inserted amount through the vending machine
     * @return change Is the outstanding amount to be supplied back to the user proceeding a purchase.
     */
    public double calculateChange(double insertedAmount) {
        double change = insertedAmount - amountPaid;
        amountPaid = 0;
        return change;
    }

    /**
     * Checks if the purchase is valid. Specifically in the case where the inserted amount is enough to purchase the user's chosen items.
     * This method returns a boolean value if the purchase is valid.
     * @param insertedAmount Accepts the current balance for the user in the vending machine.
     * @return insertedAmount >= amountPaid This returns a boolean value based on the comparison.
     */
    public boolean checkSufficiency(double insertedAmount) {
        return insertedAmount >= amountPaid;
    }


    /**
     * This method prompts the user if they want to go through with the purchase.
     * @return Returns true if the user agrees to proceed with the purchase, false if otherwise.
     */
    public boolean promptConfirmation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirm purchase of " + quantity + " " + item.getName() + " for " + (item.getPrice()*quantity) + "? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    public double getPrice() {
        return price;
    }

    public double getAmountPaid() {

        amountPaid = price * quantity;
        return amountPaid;
    }

    public double getQuantity() {
        return quantity;
    }
}

