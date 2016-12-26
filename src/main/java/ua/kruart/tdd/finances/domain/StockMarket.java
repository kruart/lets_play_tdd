package ua.kruart.tdd.finances.domain;

import ua.kruart.tdd.finances.util.Require;

/**
 * Created by Arthur on 18.12.2016.
 */
public class StockMarket {

    private final Year startingYear;
    private final Year endingYear;
    private final Dollars sellEveryYear;
    private StockMarketYear[] years;

    public StockMarket(Year startingYear, Year endingYear, Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate, Dollars sellEveryYear) {
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.sellEveryYear = sellEveryYear;
        populateYears(startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
    }

    private void populateYears(Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.years = new StockMarketYear[numberOfYears()];

        years[0] = new StockMarketYear(startingYear, startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
        years[0].sell(sellEveryYear);
        for (int i = 1; i < numberOfYears(); i++) {
            years[i] = years[i - 1].nextYear();
            years[i].sell(sellEveryYear);
        }
    }

    public int numberOfYears() {
        return startingYear.numberOfYearsInclusive(endingYear);
    }

    public StockMarketYear getYearOffset(int offset) {
        Require.that(offset >= 0 && offset < numberOfYears(), "Offset needs to be between 0 and " + (numberOfYears() - 1) + "; was " + offset);
        return years[offset];
    }
}
