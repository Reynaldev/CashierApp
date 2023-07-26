package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemView implements Runnable, ActionListener {
    String addCommand = "Add";

    JFrame frame;

    JTextField itemNameField;
    JTextField itemQuantityField;
    JTextField itemPriceField;

    @Override
    public void run() {
        frame = new JFrame("Add Item");
        frame.setMinimumSize(new Dimension(350, 250));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.add(panel);

        // Item label
        JLabel itemNameLabel = new JLabel("Name     : ", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(itemNameLabel, constraints);

        JLabel itemQuantityLabel = new JLabel("Quantity : ", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(itemQuantityLabel, constraints);

        JLabel itemPriceLabel = new JLabel("Price    : ", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(itemPriceLabel, constraints);

        // Item field
        itemNameField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(itemNameField, constraints);

        itemQuantityField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(itemQuantityField, constraints);

        itemPriceField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(itemPriceField, constraints);

        // Button
        JButton addButton = new JButton("Add");
        addButton.setActionCommand(addCommand);

        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(addButton, constraints);

        // Action listener
        addButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (addCommand.equals(e.getActionCommand())) {
            try {
                String name = itemNameField.getText();
                int quantity = Integer.parseInt(itemQuantityField.getText());
                int price = Integer.parseInt(itemPriceField.getText());

                InventoryController.add(name, quantity, price);

                System.out.println(InventoryController.getAll());

                frame.dispose();
            } catch (Error err) {
                System.out.println("Error: " + err.getMessage());
            }
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new AddItemView());
//    }
}
