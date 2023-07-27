package Controllers;

import Models.Inventory;
import Models.InventoryTableModel;

import javax.swing.table.DefaultTableModel;

public class InventoryController {
    static InventoryTableModel tableModel = new InventoryTableModel();

    static int id =  1;

    public static void add(String name, int quantity, int price) {
        Inventory inventory = new Inventory(id, name, quantity, price);

        tableModel.getTableModel().addRow(new Object[] {
                inventory.getId(),
                inventory.getName(),
                inventory.getQuantity(),
                inventory.getPrice(),
                inventory.getPriceTotal()
        });

        id++;
    }

    public static DefaultTableModel getTableModel() {
        return tableModel.getTableModel();
    }
}
