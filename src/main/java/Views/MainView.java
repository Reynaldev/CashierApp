package Views;

import Controllers.InventoryController;
import Models.Inventory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainView implements Runnable, ActionListener {
    // Actions name
    String addItemCommand = "AddItem";
    String editItemCommand = "EditItem";
    String deleteItemCommand = "DeleteItem";

    JTable table;

    @Override
    public void run() {
        // Frame
        JFrame frame = new JFrame("Cashier App");
        frame.setMinimumSize(new Dimension(640, 480));

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.add(panel);

        // Table
        table = new JTable(new InventoryTableModel());
        JScrollPane tableScrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.weighty = 0.8;
        constraints.gridheight = 3;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(tableScrollPane, constraints);

        // Add item button
        JButton addItemButton = new JButton("Add");
        addItemButton.setActionCommand(addItemCommand);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(addItemButton, constraints);

        // Edit item button
        JButton editItemButton = new JButton("Edit");
        editItemButton.setActionCommand(editItemCommand);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(editItemButton, constraints);

        // Delete item button
        JButton deleteItemButton = new JButton("Delete");
        deleteItemButton.setActionCommand(deleteItemCommand);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.1;
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(deleteItemButton, constraints);

        // Action listener
        addItemButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (addItemCommand.equals(e.getActionCommand())) {
            SwingUtilities.invokeLater(new AddItemView());
        }
    }

    class InventoryTableModel extends AbstractTableModel {
        String[] columnName = {
                "ID",
                "Name",
                "Quantity",
                "Price",
                "Price Total"
        };

        Object[][] data = {
                { 1, "Aqua",  }
        };

        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    }
}
