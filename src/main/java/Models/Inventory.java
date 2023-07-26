package Models;

public class Inventory {
    int id;
    String name;
    int quantity;
    int price;

    public Inventory(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
