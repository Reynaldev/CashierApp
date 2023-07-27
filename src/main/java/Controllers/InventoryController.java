package Controllers;

import Models.Inventory;
import Models.InventoryTableModel;

import javax.swing.table.DefaultTableModel;

public class InventoryController {
    static InventoryTableModel tableModel = new InventoryTableModel();

    static int id =  1;

    public static void add(String name, int quantity, int price) {
        // Initialize data
        Inventory inventory = new Inventory(id, name, quantity, price);

        // Add data into the table
        tableModel.getTableModel().addRow(new Object[] {
                inventory.getId(),
                inventory.getName(),
                inventory.getQuantity(),
                inventory.getPrice(),
                inventory.getPriceTotal()
        });

        // Item ID
        id++;
    }

    public static int getTotalPrice() {
        // Row
        int row = tableModel.getTableModel().getRowCount();

        // Return 0 if there's no row
        if (row < 1)
            return 0;

        // Initialize
        int total = 0;

        // Calculate the total price
        for (int i = 0; i < row; i++) {
            total +=  Integer.parseInt(tableModel.getTableModel().getValueAt(i, 4).toString());
        }

        // Return total price
        return total;
    }

    public static DefaultTableModel getTableModel() {
        return tableModel.getTableModel();
    }
}
