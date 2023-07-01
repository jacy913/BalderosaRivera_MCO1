package VendingMachine.java;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Create a vending machine
        VendingMachine vendingMachine = new VendingMachine();

        // Add items to the vending machine
        Item chips = new Item("Chips", 1.50, 150);
        Item soda = new Item("Soda", 1.00, 100);
        Item candy = new Item("Candy", 0.75, 80);
        Item cookies = new Item("Cookies", 2.00, 180);
        Item water = new Item("Water", 1.25, 0);
        Item sandwich = new Item("Sandwich", 3.50, 350);
        Item gum = new Item("Gum", 0.50, 40);
        Item popcorn = new Item("Popcorn", 2.50, 200);

        vendingMachine.addItem(chips, 10);
        vendingMachine.addItem(soda, 20);
        vendingMachine.addItem(candy, 15);
        vendingMachine.addItem(cookies, 12);
        vendingMachine.addItem(water, 8);
        vendingMachine.addItem(sandwich, 5);
        vendingMachine.addItem(gum, 25);
        vendingMachine.addItem(popcorn, 10);

        vendingMachine.displayStartingInventory();

        // Insert money before purchasing
        Money moneyToInsert = new Money(1, 2);
        vendingMachine.insertMoney(moneyToInsert);

        Transaction transaction1 = vendingMachine.purchaseItem(chips, 2);

        vendingMachine.printTransactionReceipts();

        // Create a maintenance object for the vending machine
        Maintenance maintenance = new Maintenance(vendingMachine);

        // Perform maintenance tasks
        maintenance.restockItem(chips, 5);
        maintenance.restockItem(soda, 10);
        maintenance.changeItemPrice(candy, 0.90);
        maintenance.changeItemPrice(cookies, 1.75);

        // Collect revenue and replenish balance
        maintenance.collectRevenue();
        System.out.println("Total income: " + maintenance.getRevenue());

        maintenance.replenishBalance(new Money(10, 50));

    }
}




