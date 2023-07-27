package Models;

import javax.swing.table.DefaultTableModel;

public class InventoryTableModel {
    DefaultTableModel tableModel;

    String[] columnName;
    Object[][] data;

    public InventoryTableModel() {
        columnName = new String[]{
                "ID",
                "Name",
                "Quantity",
                "Price",
                "Total Price"
        };

        tableModel = new DefaultTableModel(data, columnName);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
