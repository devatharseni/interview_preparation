import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

// Main class
public class Main {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }
}