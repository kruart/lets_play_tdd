package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 12.12.2016.
 */
public class Dollars {

    private int amount;

    public Dollars(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;      //// TODO: delete me
    }

    public Dollars add(Dollars dollars) {
        return new Dollars(this.amount + dollars.amount);
    }

    public Dollars subtract(Dollars dollars) {
        return new Dollars(this.amount - dollars.amount);
    }

    public Dollars subtractToZero(Dollars dollars) {
        int result = this.amount - dollars.amount;
        return new Dollars(Math.max(0, result));
    }

    @Override
    public String toString() {
        return "$" + amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dollars dollars = (Dollars) o;

        return amount == dollars.amount;

    }
}
