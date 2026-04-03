import java.util.Scanner;

class Item {
    String name;
    int qty;
    double price;

    Item(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    double getTotal() {
        return qty * price;
    }
}

