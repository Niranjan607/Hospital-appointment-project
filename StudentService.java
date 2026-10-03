package StudentManagmentSystem;
import java.util.HashMap;

public class StudentService {

    HashMap<Integer, Student_details> students =
            new HashMap<>();

    // Add new Student
    void addStudent(Student_details student) {

        if (students.containsKey(student.id)) {
            System.out.println("Student ID already exists.");
        } else {
            students.put(student.id, student);
            System.out.println("Student added successfully.");
        }
    }

    // All students Details
    void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student_details student : students.values()) {

            System.out.println();
            student.display();
            System.out.println("----------------------");
        }
    }

    // Searching by ID
    void searchById(int id) {

    	Student_details student = students.get(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.display();
        }
    }

    // Searching by name
    void searchByName(String name) {

        for (Student_details student : students.values()) {

            if (student.name.equalsIgnoreCase(name)) {
                student.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Updated marks
    void updateMarks(int id, double marks) {

    	Student_details student = students.get(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.marks = marks;
            System.out.println("Marks updated.");
        }
    }

    // Updated attendance
    void updateAttendance(int id, int attendance) {

    	Student_details student = students.get(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.attendance = attendance;
            System.out.println("Attendance updated.");
        }
    }

    // Remove student
    void removeStudent(int id) {

        if (students.remove(id) != null) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display topper List
    void displayTopper() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Student_details topper = null;

        for (Student_details student : students.values()) {

            if (topper == null ||
                    student.marks > topper.marks) {

                topper = student;
            }
        }

        System.out.println("===== TOPPER =====");
        topper.display();
    }
}