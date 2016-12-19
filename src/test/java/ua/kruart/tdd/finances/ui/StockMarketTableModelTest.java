package ua.kruart.tdd.finances.ui;

import org.junit.Before;
import org.junit.Test;
import ua.kruart.tdd.finances.domain.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arthur on 15.12.2016.
 */
public class StockMarketTableModelTest {

    private static final Year STARTING_YEAR = new Year(2010);
    private static final Year ENDING_YEAR = new Year(2050);
    private static final Dollars STARTING_BALANCE = new Dollars(10000);
    private static final Dollars STARTING_PRINCIPAL = new Dollars(7000);
    private StockMarketTableModel model;

    @Before
    public void setup() {
        StockMarket market = new StockMarket(STARTING_YEAR, ENDING_YEAR, STARTING_BALANCE, STARTING_PRINCIPAL, new InterestRate(10), new TaxRate(25));
        model = new StockMarketTableModel(market);
    }

    @Test
    public void columns() {
        assertEquals(6, model.getColumnCount());
        assertEquals("Year", model.getColumnName(0));
        assertEquals("Starting Balance", model.getColumnName(1));
        assertEquals("Starting Principal", model.getColumnName(2));
    }

    @Test
    public void oneRow() {
        assertEquals("year", STARTING_YEAR, model.getValueAt(0, 0));
        assertEquals("starting balance", STARTING_BALANCE, model.getValueAt(0, 1));
        assertEquals("starting principal", STARTING_PRINCIPAL, model.getValueAt(0, 2));
        assertEquals("withdrawals", new Dollars(0), model.getValueAt(0, 3));
        assertEquals("appreciation", new Dollars(1000), model.getValueAt(0, 4));
        assertEquals("ending balance", new Dollars(11000), model.getValueAt(0, 5));
    }

    @Test
    public void multipleRows() {
        assertEquals(41, model.getRowCount());
        assertEquals(STARTING_YEAR, model.getValueAt(0, 0));
        assertEquals(STARTING_BALANCE, model.getValueAt(0, 1));
        assertEquals(new Dollars(11000), model.getValueAt(1, 1));
        assertEquals(ENDING_YEAR, model.getValueAt(40, 0));
    }
}