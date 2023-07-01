package VendingMachine.java;
import java.util.Scanner;

public class Transaction {
    private Item item;
    private double price;

    private int quantity;
    private double amountPaid;

    public Transaction(Item item, double p, int quantity) {
        this.item = item;
        price = p;
        this.quantity = quantity;
        amountPaid = 0;
    }

    public void printReceipt() {

        System.out.println("------ Receipt: All Transactions ------");

            System.out.println("Item: " + item.getName());
            System.out.println("Price: " + getPrice());
            System.out.println("Quantity: " + getQuantity());
            System.out.println("Amount Paid: " + getAmountPaid());
            System.out.println("--------------------------------------");

    }
    public double calculateChange(double insertedAmount) {
        double change = insertedAmount - amountPaid;
        amountPaid = 0;
        return change;
    }

    public boolean checkSufficiency(double insertedAmount) {
        return insertedAmount >= amountPaid;
    }


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

