package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MainView extends JFrame{

    private final JPanel mainPanel;
    private final JTable table;
    private DefaultTableModel model_table;
    private JScrollPane scroll_table;

    public MainView(String[] header, Vector <Object []> data) {
        mainPanel = new JPanel(null);
        setSize(500, 500);

        table = new JTable();
        model_table = new DefaultTableModel();
        for(String label : header) {
            model_table.addColumn(label);
        }
        table.setModel(model_table);

                                // add value to table
        for(Object[] itemData : data) {
                model_table.addRow(itemData);
        }


        scroll_table = new JScrollPane(table);            // add table to scroll panel
        scroll_table.setBounds(10, 10, 1500, 1000);
        scroll_table.setVisible(true);
        mainPanel.add(scroll_table);

        this.add(mainPanel);
    }
}