package Controllers;

import Models.Inventory;

import java.util.Vector;

public class InventoryController {
    static Vector<Inventory> inventoryList = new Vector<>();

    static int id =  0;

    public static void add(String name, int quantity, int price) {
        Inventory inventory = new Inventory(id, name, quantity, price);

        inventoryList.add(inventory);

        id++;
    }

    public static Vector<Inventory> getAll() {
        return inventoryList;
    }
}
