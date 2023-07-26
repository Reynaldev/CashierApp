package Controllers;

import Models.Inventory;

import java.util.Vector;

public class InventoryController {
    static Vector<Vector<Inventory>> inventoryList = new Vector<Vector<Inventory>>();

    static int id =  0;

    public static void add(String name, int quantity, int price) {
        Inventory inventory = new Inventory(id, name, quantity, price);

        inventoryList.elementAt(inventoryList.size()).add(inventory);

        id++;
    }

    public static Vector<Vector<Inventory>> getAll() {
        return inventoryList;
    }
}
