package Views;

import Controllers.InventoryController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView implements Runnable, ActionListener {
    // Actions name
    private String addItemCommand = "AddItem";
    private String editItemCommand = "EditItem";
    private String deleteItemCommand = "DeleteItem";

    private JFrame frame;
    private JPanel panel;
    private JScrollPane tableScrollPane;
    private JTable table;

    @Override
    public void run() {
        // Frame
        frame = new JFrame("Cashier App");
        frame.setMinimumSize(new Dimension(640, 480));

        // Layout
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.add(panel);

        // Table
        table = new JTable(InventoryController.getTableModel());

        tableScrollPane = new JScrollPane(
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

        constraints = new GridBagConstraints();
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

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.2;
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
        constraints.weighty = 0;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(deleteItemButton, constraints);

        // Action listener
        addItemButton.addActionListener(this);
        editItemButton.addActionListener(this);
        deleteItemButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ADD button
        if (e.getActionCommand().equals(addItemCommand)) {
            SwingUtilities.invokeLater(new AddItemView());
        }

        // EDIT button
        if (e.getActionCommand().equals(editItemCommand)) {
            SwingUtilities.invokeLater(new AddItemView());
        }

        // DELETE button
        if (e.getActionCommand().equals(deleteItemCommand)) {
            SwingUtilities.invokeLater(new AddItemView());
        }
    }
}
