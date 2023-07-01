package VendingMachine.java;

import java.util.ArrayList;

public class Inventory {

    private VendingMachine vendingMachine;
    private ArrayList<Slot> inventory;

    public Inventory(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        inventory = new ArrayList<>(vendingMachine.getSlots());
    }

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
