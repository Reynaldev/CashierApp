package Views;

import Controllers.InventoryController;

import javax.swing.*;
import java.awt.*;

public class EditItemView implements Runnable {
    private JFrame frame;
    private JPanel panel;
    private JLabel itemIDLabel;
    private JLabel itemNameLabel;
    private JLabel itemQuantityLabel;
    private JLabel itemPriceLabel;
    private JTextField itemIDText;
    private JTextField itemNameText;
    private JTextField itemQuantityText;
    private JTextField itemPriceText;
    private JTextField itemPriceTotalText;

    private String itemName;
    private int itemID;
    private int itemQuantity;
    private int itemPrice;
    private int itemPriceTotal;

    public EditItemView(int row) {
        Object[] data = InventoryController.getDataRow(row);

        System.out.println(
                "\nID          : " + data[0].toString() +
                "\nName        : " + data[1].toString() +
                "\nQuantity    : " + data[2].toString() +
                "\nPrice       : " + data[3].toString() +
                "\nPrice Total : " + data[4].toString());
    }

    @Override
    public void run() {
        frame = new JFrame("Edit Item");
        frame.setMinimumSize(new Dimension(350, 250));

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        frame.add(panel);
    }
}
