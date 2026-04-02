import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();

        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();
    }

    void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Salary : " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.getDetails();
        emp.displayDetails();
    }
}