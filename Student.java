public class Student {
    private String studentId;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(String studentId, String name, int age, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    // Display method
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Course: %s",
                studentId, name, age, course);
    }
}