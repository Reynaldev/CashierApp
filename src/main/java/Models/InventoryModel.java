package Models;

import javax.swing.table.AbstractTableModel;

public class InventoryModel extends AbstractTableModel {
    static String[] columnName = {
            "ID",
            "Name",
            "Quantity",
            "Price",
            "Price Total"
    };

    static Object[][] data = {
            { 1, "Aqua", 1, 4000, 4000 }
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}
