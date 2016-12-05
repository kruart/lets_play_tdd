package ua.kruart.tdd;

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
}
