package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditItemView implements Runnable, ActionListener {
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
    private JLabel itemPriceTotalLabel;
    private JTextField itemIDField;
    private JTextField itemNameField;
    private JTextField itemQuantityField;
    private JTextField itemPriceField;
    private JTextField itemPriceTotalField;

    // Commands
    private String editCommand = "EditCommand";

    // Vars
    private Object[] data;
    private String name;
    private int id;
    private int quantity;
    private int price;
    private int priceTotal;

    public EditItemView(int row) {
        this.data = InventoryController.getDataRow(row);

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

        // Price Total label
        itemPriceTotalLabel = new JLabel("Price Total", SwingConstants.LEFT);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(itemPriceTotalLabel, constraints);

        // ID field
        itemIDField = new JTextField(data[0].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(itemIDField, constraints);

        // Name field
        itemNameField = new JTextField(data[1].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(itemNameField, constraints);

        // Quantity field
        itemQuantityField = new JTextField(data[2].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(itemQuantityField, constraints);

        // Price field
        itemPriceField = new JTextField(data[3].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(itemPriceField, constraints);

        // Price Total field
        itemPriceTotalField = new JTextField(data[4].toString());

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(itemPriceTotalField, constraints);

        // Edit button
        editButton = new JButton("Edit");
        editButton.setActionCommand(editCommand);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(12, 12, 12, 12);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(editButton, constraints);

        // Action listener
        editButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

            if (itemPriceTotalField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Price Total field cannot be empty!",
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
        }
    }
}
