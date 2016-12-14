package ua.kruart.tdd.finances;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        String[] titles = {"Year", "Starting Balance", "Starting Principal", "Withdrawals", "Appreciation", "Deposits", "Ending Balance"};
        DefaultTableModel model = new DefaultTableModel(titles, 0);
        model.addRow(new Integer[] {1, 2, 3, 4, 5, 6, 7});

        JTable table = new JTable(model);
        return new JScrollPane(table);
    }

    public static void main(String[] args) {
        new Application().setVisible(true);
        System.out.println("Hello, world!");
    }
}
