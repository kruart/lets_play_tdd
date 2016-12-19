package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 18.12.2016.
 */
public class StockMarket {

    private final int startingYear;
    private final int endingYear;
    private StockMarketYear[] years;

    public StockMarket(int startingYear, int endingYear, Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        populateYears(startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
    }

    private void populateYears(Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.years = new StockMarketYear[numberOfYears()];

        years[0] = new StockMarketYear(startingYear, startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
        for (int i = 1; i < numberOfYears(); i++) {
            years[i] = years[i - 1].nextYear();
        }
    }

    public int numberOfYears() {
        return endingYear - startingYear + 1;
    }

    public StockMarketYear getYear(int offset) {
        return years[offset];
    }
}
