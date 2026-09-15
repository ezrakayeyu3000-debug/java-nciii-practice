import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added successfully!");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️  No students found.");
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
}