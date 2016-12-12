package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 05.12.2016.
 */

public class StockMarketYear {

    private int startingBalance;
    private InterestRate interestRate;
    private int totalWithdrawals;
    private Dollars startingPrincipal;
    private TaxRate capitalGainsTaxRate;

    public StockMarketYear(int startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.interestRate = interestRate;
        this.capitalGainsTaxRate = capitalGainsTaxRate;
        this.totalWithdrawals = 0;

    }

    public int startingBalance() {
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

    public void withdraw(int amount) {
        this.totalWithdrawals += amount;
    }

    private int capitalGainsWithdrawn() {
        int result = (startingPrincipal().amount() - totalWithdrawals) * -1;
        return Math.max(0, result);
    }

    public int capitalGainsTaxIncurred() {
        return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn());
    }

    public int totalWithdrawn() {
        return totalWithdrawals + capitalGainsTaxIncurred();
    }

    public int interestEarned() {
        return interestRate().interestOn(startingBalance - totalWithdrawn());
    }

    public int endingBalance() {
        return startingBalance - totalWithdrawn() + interestEarned();
    }

    public int endingPrincipal() {
        return startingPrincipal().subtractToZero(new Dollars(totalWithdrawals)).amount();
    }

    public StockMarketYear nextYear() {
        return new StockMarketYear(this.endingBalance(), new Dollars(this.endingPrincipal()), interestRate(), this.capitalGainsTaxRate());
    }

}
