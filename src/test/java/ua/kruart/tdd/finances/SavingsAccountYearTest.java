package ua.kruart.tdd.finances;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arthur on 05.12.2016.
 */
public class SavingsAccountYearTest {

    @Test
    public void startingBalanceMatchesConstructor() {
        assertEquals(10000, newAccount().startingBalance());
    }

    @Test
    public void interestRateMatchesConstructor() {
        assertEquals(10, newAccount().interestRate());
    }

    @Test
    public void endingBalanceAppliesInterestRate() {
        assertEquals(11000, newAccount().endingBalance());
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.endingBalance(), thisYear.nextYear().startingBalance());
    }


    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }

    @Test
    public void withdrawingFundsOccursAtTheBeginningOfTheYear() {
        SavingsAccountYear year = newAccount();
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance());
    }

    @Test
    @Ignore
    public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        year.withdraw(3000);
        assertEquals(7700, year.endingBalance());
        year.withdraw(5000);
        assertEquals(2000 + 200 - (1250), year.endingBalance());
    }

    private SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }
}
