package ua.kruart.tdd.finances;

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
        StockMarketTableModel model = new StockMarketTableModel(2010, new Dollars(10000), new Dollars(7000), new InterestRate(10), new TaxRate(25));
        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
    }
}
