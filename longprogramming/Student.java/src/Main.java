import java.util.Scanner;

class Student {
    String name;
    int id;
    String grade;

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Grade: ");
        grade = sc.nextLine();
    }

    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.getDetails();
        s1.displayDetails();
    }
}
