package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MainView {
    // Components
    JButton addItemButton;

    // Actions name
    String buttonClickedAction = "ButtonClicked";

    public MainView() {
        // Frame
        JFrame frame = new JFrame("Cashier App");
        frame.setMinimumSize(new Dimension(640, 480));

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(20, 20, 20));
        frame.add(panel);

//
//        // Table
//        Vector<String> columnNames = new Vector<String>();
//        columnNames.add("ID");
//        columnNames.add("Name");
//        columnNames.add("Quantity");
//        columnNames.add("Price");

        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", 5, false},
                {"John", "Doe",
                        "Rowing", 3, true},
                {"Sue", "Black",
                        "Knitting", 2, false},
                {"Jane", "White",
                        "Speed reading", 20, true},
                {"Joe", "Brown",
                        "Pool", 10, false}
        };

        JTable table = new JTable(data, columnNames);
        table.setBounds(5, 5, 450, 250);

        JScrollPane tableScrollPane = new JScrollPane(
                table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        tableScrollPane.setPreferredSize(table.getPreferredSize());
        tableScrollPane.setColumnHeaderView(table.getTableHeader());

        GridBagConstraints tableConstraint = new GridBagConstraints();
        tableConstraint.fill = GridBagConstraints.BOTH;
        tableConstraint.weightx = 0.8;
        tableConstraint.weighty = 1;
        tableConstraint.gridheight = 2;
        tableConstraint.gridx = 0;
        tableConstraint.gridy = 0;
        panel.add(tableScrollPane, tableConstraint);

        addItemButton = new JButton("Add Item");
        addItemButton.setBounds(table.getWidth() + 10, 5, 150, 25);

        GridBagConstraints addItemButtonConstraint = new GridBagConstraints();
        addItemButtonConstraint.weightx = 0;
        addItemButtonConstraint.gridx = 1;
        addItemButtonConstraint.gridy = 0;
        panel.add(addItemButton, addItemButtonConstraint);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
