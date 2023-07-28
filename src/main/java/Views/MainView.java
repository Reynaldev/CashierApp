package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainView implements Runnable, ActionListener {
    private final int width = 640;
    private final int height = 480;

    // GUI
    private JFrame frame;
    private JPanel panel;
    private JButton addItemButton;
    private JButton editItemButton;
    private JButton deleteItemButton;
    private JButton calculateButton;
    private JLabel totalPriceLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem exitMenuItem, aboutMenuItem;
    private JScrollPane tableScrollPane;
    private JTable table;

    // Commands
    private String addItemCommand = "AddItem";
    private String editItemCommand = "EditItem";
    private String deleteItemCommand = "DeleteItem";
    private String calculateCommand = "CalculatePrice";
    private String exitCommand = "ExitCommand";
    private String aboutCommand = "AboutCommand";

    @Override
    public void run() {
        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Frame
        frame = new JFrame("Cashier App");
        frame.setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
        frame.setMinimumSize(new Dimension(width, height));

        // MenuBar
        menuBar = new JMenuBar();

        // File menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F1);
        menuBar.add(fileMenu);

        // About menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_F2);
        menuBar.add(helpMenu);

        // File menu items
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK
        ));
        exitMenuItem.setActionCommand(exitCommand);
        fileMenu.add(exitMenuItem);

        // About menu items
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setActionCommand(aboutCommand);
        helpMenu.add(aboutMenuItem);

        // Layout
        GridBagConstraints constraints = new GridBagConstraints();
        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        // Table
        table = new JTable(InventoryController.getTable());
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
        totalPriceLabel.setText("Total  Rp" + InventoryController.getTotalPrice());

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
        addItemButton.setMnemonic(KeyEvent.VK_A);
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
        editItemButton.setMnemonic(KeyEvent.VK_E);
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
        deleteItemButton.setMnemonic(KeyEvent.VK_D);
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
        calculateButton.setMnemonic(KeyEvent.VK_C);
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
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);

        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ADD button
        if (e.getActionCommand().equals(addItemCommand)) {
            // Open AddItemView window
            SwingUtilities.invokeLater(new AddItemView());
        }

        // EDIT button
        if (e.getActionCommand().equals(editItemCommand)) {
            // Get row
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "No row was selected!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Open EditItemView window
            SwingUtilities.invokeLater(new EditItemView(row));
        }

        // DELETE button
        if (e.getActionCommand().equals(deleteItemCommand)) {
            // Get row
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "No row was selected!",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Show warning dialog
            String message = "Data in row " + row + " will be DELETED.";
            int option = JOptionPane.showConfirmDialog(
                    null, message,
                    "Warning", JOptionPane.OK_CANCEL_OPTION
            );

            // Skip if CANCEL button is pressed
            if (option == JOptionPane.CANCEL_OPTION)
                return;

            // Delete
            InventoryController.delete(row);
        }

        // CALCULATE button
        if (e.getActionCommand().equals(calculateCommand)) {
            totalPriceLabel.setText("Total  Rp" + InventoryController.getTotalPrice());
        }

        if (e.getActionCommand().equals(exitCommand)) {
            frame.dispose();
        }

        if (e.getActionCommand().equals(aboutCommand)) {
            String message = "A simple Cashier Application made by ReynDev";
            JOptionPane.showMessageDialog(
                    null, message,
                    "About CashierApp", JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
