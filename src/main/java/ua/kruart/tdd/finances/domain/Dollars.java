package ua.kruart.tdd.finances.domain;

/**
 * Created by Arthur on 12.12.2016.
 */
public class Dollars {

    private double amount;

    public Dollars(int amount) {
        this.amount = amount;
    }

    public Dollars(double amount) {
        this.amount = amount;
    }


    public Dollars plus(Dollars dollars) {
        return new Dollars(this.amount + dollars.amount);
    }

    public Dollars minus(Dollars dollars) {
        return new Dollars(this.amount - dollars.amount);
    }

    public Dollars subtractToZero(Dollars dollars) {
        double result = this.amount - dollars.amount;
        return new Dollars(Math.max(0, result));
    }

    public Dollars percentage(double percent) {
        return new Dollars(amount * percent / 100);
    }

    public static Dollars min(Dollars value1, Dollars value2) {
        return new Dollars(Math.min(value1.amount, value2.amount));
    }

    private long roundOffPennies() {
        return Math.round(this.amount);
    }

    @Override
    public String toString() {
        return "$" + this.roundOffPennies();
    }

    @Override
    public int hashCode() {
        return (int)roundOffPennies();
    }

    @Override
    public boolean equals(Object o) {
        Dollars that = (Dollars)o;
        return this.roundOffPennies() == that.roundOffPennies();
    }
}
