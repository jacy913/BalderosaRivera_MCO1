package VendingMachine.java;

public class Item {
    private final String name;
    private double price;
    private double calories;

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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCalories(float c) {
        calories = c;
    }

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

