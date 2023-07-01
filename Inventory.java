package VendingMachine.java;

import java.util.ArrayList;

public class Inventory {

    private VendingMachine vendingMachine;
    private ArrayList<Slot> inventory;

    /**
    * Constructs an object of the Inventory class
     * @param vendingMachine accepts the vending machine as parameter.
    **/
    public Inventory(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        inventory = new ArrayList<>(vendingMachine.getSlots());
    }

    /**
     * Displays the inventory for the vending machine contents
     * @param slots Accepts an ArrayList of the slots in the vending machine.
     **/
    public void displayInventory(ArrayList<Slot> slots) {
        System.out.println("Starting Inventory:");
        for (Slot slot : slots) {
            System.out.println(slot.getItem().getName());
            System.out.println("Price: " + slot.getItem().getPrice());
            System.out.println("Caloric yield per item: " + slot.getItem().getCalories());
            System.out.println("Available in slot: " + slot.getQuantity());
            System.out.println("-----------------");
            inventory.add(slot);
        }
    }
}
