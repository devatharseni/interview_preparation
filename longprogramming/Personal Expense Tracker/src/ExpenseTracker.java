import java.io.*;
import java.util.*;

class Expense {
    String category;
    double amount;
    String date;

    Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return category + "," + amount + "," + date;
    }

    public static Expense fromString(String line) {
        String[] parts = line.split(",");
        return new Expense(parts[0], Double.parseDouble(parts[1]), parts[2]);
    }
}

public class ExpenseTracker {
    static List<Expense> expenses = new ArrayList<>();
    static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadExpenses();

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    totalExpense();
                    break;
                case 4:
                    saveExpenses();
                    System.out.println("Saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addExpense(Scanner sc) {
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        expenses.add(new Expense(category, amount, date));
        System.out.println("Expense added!");
    }

    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println("Category: " + e.category +
                    " | Amount: " + e.amount +
                    " | Date: " + e.date);
        }
    }

    static void totalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expense: " + total);
    }

    static void saveExpenses() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadExpenses() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromString(line));
            }
        } catch (IOException e) {

        }
    }
}