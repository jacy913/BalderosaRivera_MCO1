package VendingMachine.java;

public class Money {
    private int denomination;
    private int bills;

    /**
     * Constructor of an object of the class Money.
     * @param denom Accepts the certain denomination of the bill.
     * @param bills Accepts the amount of bills in that denomination.
     */
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

