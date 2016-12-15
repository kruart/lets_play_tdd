package ua.kruart.tdd.finances;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arthur on 15.12.2016.
 */
public class StockMarketTableModelTest {

    private StockMarketTableModel model;

    @Before
    public void setup() {
        model = new StockMarketTableModel();
    }

    @Test
    public void columns() {
        assertEquals(7, model.getColumnCount());
        assertEquals("Year", model.getColumnName(0));
        assertEquals("Starting Balance", model.getColumnName(1));
        assertEquals("Starting Principal", model.getColumnName(2));
    }

    @Test
    public void firstRow() {

    }
}