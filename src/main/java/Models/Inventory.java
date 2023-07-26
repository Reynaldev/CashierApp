package Models;

public class Inventory {
    public int id;
    public String name;
    public int quantity;
    public int price;

    public Inventory(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
