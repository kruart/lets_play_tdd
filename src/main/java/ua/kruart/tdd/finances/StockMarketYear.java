package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 05.12.2016.
 */

public class StockMarketYear {

    private Dollars startingBalance;
    private Dollars startingPrincipal;
    private InterestRate interestRate;
    private TaxRate capitalGainsTaxRate;
    private Dollars totalWithdrawals;

    public StockMarketYear(Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.interestRate = interestRate;
        this.capitalGainsTaxRate = capitalGainsTaxRate;
        this.totalWithdrawals = new Dollars(0);

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
        //Convert amount to dollars
        this.totalWithdrawals = this.totalWithdrawals.add(amount);
    }

    private Dollars capitalGainsWithdrawn() {
        return totalWithdrawals.subtractToZero(startingPrincipal());
    }

    public int capitalGainsTaxIncurred() {
        return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn().amount());
    }

    public Dollars totalWithdrawn() {
        return totalWithdrawals.add(new Dollars(capitalGainsTaxIncurred()));
    }

    public int interestEarned() {
        return interestRate().interestOn(startingBalance.amount() - totalWithdrawn().amount());
    }

    public Dollars endingBalance() {
        return startingBalance.subtract(totalWithdrawn()).add(new Dollars(interestEarned()));
    }

    public int endingPrincipal() {
        return startingPrincipal().subtractToZero(totalWithdrawals).amount();
    }

    public StockMarketYear nextYear() {
        return new StockMarketYear(this.endingBalance(), new Dollars(this.endingPrincipal()), interestRate(), this.capitalGainsTaxRate());
    }

}
