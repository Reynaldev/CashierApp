package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddItemView implements Runnable, ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JLabel itemNameLabel;
    private JLabel itemQuantityLabel;
    private JLabel itemPriceLabel;
    private JTextField itemNameField;
    private JTextField itemQuantityField;
    private JTextField itemPriceField;

    private String addCommand = "Add";

    @Override
    public void run() {
        frame = new JFrame("Add Item");
        frame.setMinimumSize(new Dimension(350, 250));

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.add(panel);

        // Item label
        itemNameLabel = new JLabel("Name     : ", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(itemNameLabel, constraints);

        itemQuantityLabel = new JLabel("Quantity : ", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(itemQuantityLabel, constraints);

        itemPriceLabel = new JLabel("Price    : ", SwingConstants.LEFT);

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
        addButton = new JButton("Add");
        addButton.setActionCommand(addCommand);
        addButton.setMnemonic(KeyEvent.VK_ENTER);

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
            // Throw message if name field is empty
            if (itemNameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Name field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Throw message if quantity field is empty
            if (itemQuantityField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Quantity field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Throw message if price field is empty
            if (itemPriceField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Price field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Initialize
            String name = itemNameField.getText();
            int quantity = Integer.parseInt(itemQuantityField.getText());
            int price = Integer.parseInt(itemPriceField.getText());

            // Throw message if quantity is less than 1
            if (quantity < 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Quantity should be more than 1!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Throw message if price is less than 100
            if (price < 100) {
                JOptionPane.showMessageDialog(
                        null,
                        "Price should be more than 100!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Call InventoryController function
            InventoryController.add(name, quantity, price);

            // Close window
            frame.dispose();
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new AddItemView());
//    }
}
