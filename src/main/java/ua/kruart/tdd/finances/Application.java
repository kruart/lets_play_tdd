package ua.kruart.tdd.finances;

import ua.kruart.tdd.finances.domain.*;
import ua.kruart.tdd.finances.ui.StockMarketTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur on 14.12.2016.
 */
public class Application extends JFrame {
    private static final long serialVersionUID = 1L;

    public Application() {
        this.setSize(900, 400);
        this.setLocation(400, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container content = this.getContentPane();
        content.add(table());
    }

    private JScrollPane table() {
        StockMarketTableModel model = new StockMarketTableModel(stockMarket());
        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    private StockMarket stockMarket() {
        Year startingYear = new Year(2010);
        Year endingYear = new Year(2050);
        Dollars startingBalance = new Dollars(10000);
        Dollars startingPrincipal = new Dollars(7000);
        InterestRate interestRate = new InterestRate(10);
        TaxRate capitalGainsTaxRate = new TaxRate(25);
        return new StockMarket(startingYear, endingYear, startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }
}
