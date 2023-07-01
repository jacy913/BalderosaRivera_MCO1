package VendingMachine.java;

public class Money {
    private int denomination;
    private int bills;

    public Money(int denom, int bills) {
       denomination = denom;
       this.bills = bills;

    }

    public int getDenomination() {
        return denomination;
    }

    public int getBills() {
        return bills;
    }

}

