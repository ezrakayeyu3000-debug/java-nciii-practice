import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "students.txt";       
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM v1.0");
        System.out.println("========================================");

        // Load saved students from file
        manager.loadFromFile(FILE_NAME);

        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    manager.saveToFile(FILE_NAME);
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter Age: ");
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        manager.addStudent(new Student(id, name, age, course));
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        Student s = manager.findById(id);
        if (s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter new Age: ");
        System.out.print("Enter new Course: ");
        String course = scanner.nextLine();

        if (manager.updateStudent(id, name, age, course)) {
            System.out.println("Student updated!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}