package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 05.12.2016.
 */
public class SavingsAccountYear {

    private int startingBalance = 0;
    private int interestRate = 0;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int balance() {
        return startingBalance;
    }

    public void deposit(int amount) {
        startingBalance += amount;
    }

    public void withdraw(int amount) {
        startingBalance -= amount;
    }


    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate());
    }

    public int endingBalance() {
        return balance() + (balance() * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }
}
