package ua.kruart.tdd.finances;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arthur on 05.12.2016.
 */
public class SavingsAccountTest {

    @Test
    public void depositAndWithdrawalTest() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);

        assertEquals("after deposit", 100, account.balance());

        account.withdraw(50);
        assertEquals("after withdrawal", 50, account.balance());
    }

    @Test
    public void negativeBalanceIsJustFineTest() {
        SavingsAccount account = new SavingsAccount();
        account.withdraw(75);
        assertEquals(-75, account.balance());
    }

    @Test
    public void nextYear() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(10000);
        SavingsAccount nextYear = account.nextYear(10);
        assertEquals(11000, nextYear.balance());

    }
}
