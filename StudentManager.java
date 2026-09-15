import java .io.*;
import java.util.ArrayList;
import java .util.List;



public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n===== STUDENT LIST =====");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("========================\n");
    }

    // Search by ID
    public Student findById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        return null;
    }

    // Update a student
    public boolean updateStudent(String studentId, String newName, int newAge, String newCourse) {
        Student s = findById(studentId);
        if (s == null) {
            return false;
        }
        s.setName(newName);
        s.setAge(newAge);
        s.setCourse(newCourse);
        return true;
    }

    // Delete a student
    public boolean deleteStudent(String studentId) {
        Student s = findById(studentId);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    // Get all students (for saving)
    public List<Student> getAllStudents() {
        return students;
    }

    // Get total count
    public int getStudentCount() { 
        return students.size();
    }
        // Save students to file
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                writer.println(s.getStudentId() + "," + s.getName() + "," 
                              + s.getAge() + "," + s.getCourse());
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    // Load students from file
    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    students.add(new Student(parts[0], parts[1],
                                             Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}