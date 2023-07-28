package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditItemView implements Runnable, ActionListener, PropertyChangeListener {
    private final int width = 350;
    private final int height = 300;

    // GUI
    private JFrame frame;
    private JPanel panel;
    private JButton editButton;
    private JLabel itemIDLabel;
    private JLabel itemNameLabel;
    private JLabel itemQuantityLabel;
    private JLabel itemPriceLabel;
    private JFormattedTextField itemIDField;
    private JFormattedTextField itemNameField;
    private JFormattedTextField itemQuantityField;
    private JFormattedTextField itemPriceField;

    // Commands
    private final String editCommand = "EditCommand";

    // Vars
    private Object[] data;
    private int row;

    public EditItemView(int row) {
        this.data = InventoryController.getDataRow(row);
        this.row = row;

//        System.out.println(
//                "\nID          : " + this.data[0].toString() +
//                "\nName        : " + this.data[1].toString() +
//                "\nQuantity    : " + this.data[2].toString() +
//                "\nPrice       : " + this.data[3].toString() +
//                "\nPrice Total : " + this.data[4].toString());
    }

    @Override
    public void run() {
        // get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Frame
        frame = new JFrame("Edit Item");
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

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(itemNameLabel, constraints);

        // Quantity label
        itemQuantityLabel = new JLabel("Quantity", SwingConstants.LEFT);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(itemQuantityLabel, constraints);

        // Price label
        itemPriceLabel = new JLabel("Price", SwingConstants.LEFT);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(itemPriceLabel, constraints);

        // ID field
        itemIDField = new JFormattedTextField(data[0].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(itemIDField, constraints);

        // Name field
        itemNameField = new JFormattedTextField(data[1].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(itemNameField, constraints);

        // Quantity field
        itemQuantityField = new JFormattedTextField(data[2].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(itemQuantityField, constraints);

        // Price field
        itemPriceField = new JFormattedTextField(data[3].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(itemPriceField, constraints);

        // Edit button
        editButton = new JButton("Edit");
        editButton.setActionCommand(editCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(editButton, constraints);

        // Action listener
        editButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(editCommand)) {
//            System.out.println("Editing data...");

            // Validation
            if (itemNameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Name field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (itemQuantityField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Quantity field cannot be empty!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

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
            data[0] = itemIDField.getText();
            data[1] = itemNameField.getText();
            data[2] = itemQuantityField.getText();
            data[3] = itemPriceField.getText();
            data[4] = InventoryController.getPrice(
                    Integer.parseInt(data[3].toString()),
                    Integer.parseInt(data[2].toString())
            );

            // Throw message if ID is less than 1
            if (Integer.parseInt(data[0].toString()) < 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "ID should be more than 1!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Throw message if quantity is less than 1
            if (Integer.parseInt(data[2].toString()) < 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Quantity should be more than 1!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Throw message if price is less than 100
            if (Integer.parseInt(data[3].toString()) < 100) {
                JOptionPane.showMessageDialog(
                        null,
                        "Price should be more than 100!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Update
            InventoryController.update(data, row);

            // Close window
            frame.dispose();
        }
    }
}
