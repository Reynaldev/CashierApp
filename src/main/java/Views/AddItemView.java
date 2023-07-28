package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddItemView implements Runnable, ActionListener {
    private final int width = 350;
    private final int height = 250;

    // GUI
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JLabel itemIDLabel;
    private JLabel itemNameLabel;
    private JLabel itemQuantityLabel;
    private JLabel itemPriceLabel;
    private JTextField itemIDField;
    private JTextField itemNameField;
    private JTextField itemQuantityField;
    private JTextField itemPriceField;

    // Commands
    private final String addCommand = "AddCommand";

    @Override
    public void run() {
        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Frame
        frame = new JFrame("Add Item");
        frame.setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
        frame.setMinimumSize(new Dimension(width, height));

        GridBagConstraints constraints = new GridBagConstraints();
        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        // ID label
        itemIDLabel = new JLabel("ID", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(itemIDLabel, constraints);

        // Name label
        itemNameLabel = new JLabel("Name", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(itemNameLabel, constraints);

        // Quantity label
        itemQuantityLabel = new JLabel("Quantity", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(itemQuantityLabel, constraints);

        // Price label
        itemPriceLabel = new JLabel("Price", SwingConstants.LEFT);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(itemPriceLabel, constraints);

        // ID field
        itemIDField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(itemIDField, constraints);

        // Name field
        itemNameField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(itemNameField, constraints);

        // Quantity field
        itemQuantityField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(itemQuantityField, constraints);

        // Price field
        itemPriceField = new JTextField();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 0.9;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(itemPriceField, constraints);

        // Button
        addButton = new JButton("Add");
        addButton.setMnemonic(KeyEvent.VK_ENTER);
        addButton.setActionCommand(addCommand);

        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 4;
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
            // Throw message if ID field is empty
            if (itemIDField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "ID field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

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
            int id = Integer.parseInt(itemIDField.getText());
            int quantity = Integer.parseInt(itemQuantityField.getText());
            int price = Integer.parseInt(itemPriceField.getText());

            // Throw message if quantity is less than 1
            if (id < 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "ID should be more than 1!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

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
            InventoryController.add(id, name, quantity, price);

            // Close window
            frame.dispose();
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new AddItemView());
//    }
}
