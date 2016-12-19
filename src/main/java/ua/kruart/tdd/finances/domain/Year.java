package ua.kruart.tdd.finances.domain;

/**
 * Created by Arthur on 19.12.2016.
 */
public class Year {

    private final int year;

    public Year(int year) {
        this.year = year;
    }

    public Year nextYear() {
        return new Year(year + 1);
    }

    @Override
    public String toString() {
        return "" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Year year1 = (Year) o;

        return year == year1.year;

    }

    @Override
    public int hashCode() {
        return year;
    }
}
