package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainView implements ActionListener {
    AddItemView addItemView;

    // Components
    JButton addItemButton;

    // Actions name
    String addItemCommand = "AddItem";

    public MainView() {
        // Frame
        JFrame frame = new JFrame("Cashier App");
        frame.setMinimumSize(new Dimension(640, 480));

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(20, 20, 20));
        frame.add(panel);

        // Table
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Quantity");
        columnNames.add("Price");

        JTable table = new JTable(InventoryController.getAll(), columnNames);
        table.setBounds(5, 5, 450, 250);

        JScrollPane tableScrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        tableScrollPane.setPreferredSize(table.getPreferredSize());
        tableScrollPane.setColumnHeaderView(table.getTableHeader());

        // Table
        GridBagConstraints tableConstraint = new GridBagConstraints();
        tableConstraint.fill = GridBagConstraints.BOTH;
        tableConstraint.insets = new Insets(12, 12, 12, 12);
        tableConstraint.weightx = 0.9;
        tableConstraint.weighty = 1;
        tableConstraint.gridheight = 2;
        tableConstraint.gridx = 0;
        tableConstraint.gridy = 0;
        panel.add(tableScrollPane, tableConstraint);

        // Add item button
        addItemButton = new JButton("Add Item");
        addItemButton.setActionCommand(addItemCommand);
        addItemButton.setBounds(table.getWidth() + 10, 5, 150, 25);

        GridBagConstraints addItemButtonConstraint = new GridBagConstraints();
        addItemButtonConstraint.fill = GridBagConstraints.HORIZONTAL;
        addItemButtonConstraint.insets = new Insets(12, 12, 12, 12);
        addItemButtonConstraint.weightx = 0.1;
        addItemButtonConstraint.gridx = 1;
        addItemButtonConstraint.gridy = 0;
        panel.add(addItemButton, addItemButtonConstraint);

        // Action listener
        addItemButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (addItemCommand.equals(e.getActionCommand())) {
            addItemView = new AddItemView();
        }
    }
}
