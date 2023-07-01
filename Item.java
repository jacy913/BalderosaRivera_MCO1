package VendingMachine.java;

public class Item {
    private final String name;
    private double price;
    private double calories;

    /**
     * Constructs an object of the item class.
     * @param n name of item
     * @param p price of item
     * @param c caloric value of item
     **/
    public Item(String n, double p, double c) {
        name = n;
        price = p;
        calories = c;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getCalories() {
        return calories;
    }

        // Sets new price in case of maintenance.
    public void setPrice(double price) {
        this.price = price;
    }

        // This method overrides the equals() method.

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item otherItem = (Item) obj;
        return name.equals(otherItem.name);
    }
}

