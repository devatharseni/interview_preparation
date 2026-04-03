import java.util.Scanner;

public class Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BILLING SYSTEM =====");

        int n = 0;

        // Safe input for number of items
        while (true) {
            System.out.print("Enter number of items: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // remove wrong input
            }
        }

        Item[] items = new Item[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1));

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            int qty;
            while (true) {
                System.out.print("Enter quantity: ");
                if (sc.hasNextInt()) {
                    qty = sc.nextInt();
                    break;
                } else {
                    System.out.println("Invalid! Enter number only.");
                    sc.next();
                }
            }

            double price;
            while (true) {
                System.out.print("Enter price: ");
                if (sc.hasNextDouble()) {
                    price = sc.nextDouble();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Invalid! Enter valid price.");
                    sc.next();
                }
            }

            items[i] = new Item(name, qty, price);
            grandTotal += items[i].getTotal();
        }

        // Print Bill
        System.out.println("\n======= BILL =======");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total");

        for (Item i : items) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",
                    i.name, i.qty, i.price, i.getTotal());
        }

        System.out.println("------------------------------");
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        System.out.println("Thank You!");

        sc.close();
    }
}
