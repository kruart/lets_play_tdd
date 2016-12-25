package ua.kruart.tdd.finances.domain;

/**
 * Created by Arthur on 05.12.2016.
 */

public class StockMarketYear {

    private Year year;
    private Dollars startingBalance;
    private Dollars startingPrincipal;
    private InterestRate interestRate;
    private TaxRate capitalGainsTaxRate;
    private Dollars totalWithdrawals;

    public StockMarketYear(Year year, Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.year = year;
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.interestRate = interestRate;
        this.capitalGainsTaxRate = capitalGainsTaxRate;
        this.totalWithdrawals = new Dollars(0);

    }

    public Year year() {
        return year;
    }

    public Dollars startingBalance() {
        return startingBalance;
    }

    public Dollars startingPrincipal() {
        return startingPrincipal;
    }

    public InterestRate interestRate() {
        return interestRate;
    }

    public TaxRate capitalGainsTaxRate() {
        return capitalGainsTaxRate;
    }

    public void withdraw(Dollars amount) {
        //Convert toInt to dollars
        this.totalWithdrawals = this.totalWithdrawals.plus(amount);
    }

    private Dollars capitalGainsWithdrawn() {
        Dollars capitalGains = startingBalance().minus(startingPrincipal());
        return capitalGains.minOfTwoValues(totalWithdrawals);
    }

    public Dollars capitalGainsTaxIncurred() {
        return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn());
    }

    public Dollars totalWithdrawn() {
        return totalWithdrawals.plus(capitalGainsTaxIncurred());
    }

    public Dollars appreciation() {
        return interestRate().interestOn(startingBalance.minus(totalWithdrawn()));
    }

    public Dollars endingBalance() {
        return startingBalance.minus(totalWithdrawn()).plus(appreciation());
    }

    public Dollars endingPrincipal() {
        Dollars capitalGains = startingBalance().minus(startingPrincipal());
        Dollars principalReducedBy = totalWithdrawn().subtractToZero(capitalGains);
        return startingPrincipal().minus(principalReducedBy);
//        return startingPrincipal().subtractToZero(totalWithdrawals);
    }

    public StockMarketYear nextYear() {
        return new StockMarketYear(this.year.nextYear(), this.endingBalance(), this.endingPrincipal(), interestRate(), this.capitalGainsTaxRate());
    }
}
