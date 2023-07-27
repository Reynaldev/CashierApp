package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView implements Runnable, ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton addItemButton;
    private JButton editItemButton;
    private JButton deleteItemButton;
    private JButton calculateButton;
    private JLabel totalPriceLabel;
    private JScrollPane tableScrollPane;
    private JTable table;

    // Actions name
    private String addItemCommand = "AddItem";
    private String editItemCommand = "EditItem";
    private String deleteItemCommand = "DeleteItem";
    private String calculateCommand = "CalculatePrice";

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
        constraints.gridwidth = 2;
        constraints.gridheight = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(tableScrollPane, constraints);

        // Total price
        totalPriceLabel = new JLabel();
        totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPriceLabel.setText("Total = Rp" + InventoryController.getTotalPrice());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weighty = 0.2;
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(totalPriceLabel, constraints);

        // Add item button
        addItemButton = new JButton("Add");
        addItemButton.setActionCommand(addItemCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.2;
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(addItemButton, constraints);

        // Edit item button
        editItemButton = new JButton("Edit");
        editItemButton.setActionCommand(editItemCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.2;
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(editItemButton, constraints);

        // Delete item button
        deleteItemButton = new JButton("Delete");
        deleteItemButton.setActionCommand(deleteItemCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.2;
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(deleteItemButton, constraints);

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.setActionCommand(calculateCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.2;
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(calculateButton, constraints);

        // Action listener
        addItemButton.addActionListener(this);
        editItemButton.addActionListener(this);
        deleteItemButton.addActionListener(this);
        calculateButton.addActionListener(this);

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
            System.out.println("Edit!");
        }

        // DELETE button
        if (e.getActionCommand().equals(deleteItemCommand)) {
            System.out.println("Delete!");
        }

        // CALCULATE button
        if (e.getActionCommand().equals(calculateCommand)) {
            totalPriceLabel.setText("Total  Rp" + InventoryController.getTotalPrice());
        }
    }
}
