package Controllers;

import Models.InventoryTableModel;

import javax.swing.table.DefaultTableModel;

public class InventoryController {
    static DefaultTableModel table = new InventoryTableModel().getTableModel();

    public static void add(int id, String name, int quantity, int price) {
        int totalPrice = getPrice(price, quantity);

        // Insert data into the table
        table.addRow(new Object[] {
                id,
                name,
                quantity,
                price,
                totalPrice
        });
    }

    public static void update(Object[] data, int row) {
        int tableCol = table.getColumnCount();

        // Set value of the table
        for (int i = 0; i < tableCol; i++) {
            table.setValueAt(data[i], row, i);
        }
    }

    public static void delete(int row) {
        table.removeRow(row);
    }

    public static Object[] getDataRow(int row) {
        // Initialize Object[] to store array of column attribute
        Object[] data = new Object[5];

        // Copy column values into the Object[] array
        for (int i = 0; i < table.getColumnCount(); i++) {
            data[i] = table.getValueAt(row, i);
        }

        return data;
    }

    public static int getPrice(int price, int quantity) {
        return price * quantity;
    }

    public static int getTotalPrice() {
        // Row
        int row = table.getRowCount();

        // Return 0 if there's no row
        if (row < 1)
            return 0;

        // Initialize
        int total = 0;

        // Calculate the total price
        for (int i = 0; i < row; i++) {
            total +=  Integer.parseInt(table.getValueAt(i, 4).toString());
        }

        // Return total price
        return total;
    }

    public static DefaultTableModel getTable() {
        return table;
    }
}
