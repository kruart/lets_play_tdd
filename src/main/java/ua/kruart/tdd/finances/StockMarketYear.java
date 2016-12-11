package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 05.12.2016.
 */

public class StockMarketYear {

    private int startingBalance;
    private int interestRate;
    private int totalWithdrawals;
    private int startingPrincipal;

    public StockMarketYear(int startingBalance, int startingPrincipal, int interestRate) {
        this.startingBalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.interestRate = interestRate;
        this.totalWithdrawals = 0;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal() {
        return startingPrincipal;
    }

    public int interestRate() {
        return interestRate;
    }

    public void withdraw(int amount) {
        this.totalWithdrawals += amount;
    }

    private int capitalGainsWithdrawn() {
        int result = (startingPrincipal() - totalWithdrawals) * -1;
        return Math.max(0, result);
    }

    public int capitalGainsTaxIncurred(int taxRate) {
        double dblTaxRate = taxRate / 100.0;
        double dblCapGains = capitalGainsWithdrawn();
        return (int)((dblCapGains / (1 - dblTaxRate)) - dblCapGains);
    }

    public int totalWithdrawn(int capitalGainsTax) {
        return totalWithdrawals + capitalGainsTaxIncurred(capitalGainsTax);
    }

    public int interestEarned(int capitalTaxRate) {
        return (startingBalance() - totalWithdrawn(capitalTaxRate)) * interestRate() / 100;
    }

    public int endingBalance(int capitalGainsTaxRate) {
        int modifiedStart = startingBalance - totalWithdrawn(capitalGainsTaxRate);
        return modifiedStart + interestEarned(capitalGainsTaxRate);
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawals;
        return Math.max(0, result);
    }

    public StockMarketYear nextYear(int capitalGainsTaxRate) {
        return new StockMarketYear(this.endingBalance(capitalGainsTaxRate), this.endingPrincipal(), interestRate());
    }
}
