package ua.kruart.tdd;

/**
 * Created by Arthur on 05.12.2016.
 */
public class SavingsAccount {

    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int balance() {
        return balance;
    }

}
