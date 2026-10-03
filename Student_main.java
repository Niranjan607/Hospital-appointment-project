package StudentManagmentSystem;
import java.util.Scanner;

public class Student_main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service =
                new StudentService();

        while (true) {

            System.out.println();
            System.out.println("=====STACKLY STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Remove Student");
            System.out.println("8. Display Topper");
            System.out.println("9. Calculate Grade");
            System.out.println("Successfull. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // Add Student
            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                System.out.print("Enter Attendance: ");
                int attendance = sc.nextInt();
                sc.nextLine();

                System.out.println("1. ACTIVE");
                System.out.println("2. INACTIVE");
                System.out.println("3. COMPLETED");

                System.out.print("Enter status: ");
                int statusChoice = sc.nextInt();
                sc.nextLine();

                Student_Status status;

                if (statusChoice == 1) {
                    status = Student_Status.ACTIVE;
                } else if (statusChoice == 2) {
                    status = Student_Status.INACTIVE;
                } else {
                    status = Student_Status.COMPLETE;
                }

                System.out.print("Enter Course Name: ");
                String courseName = sc.nextLine();

                Course course =
                        new Course(courseName);

                Student_details student =
                        new Student_details(id,name,email,marks,attendance,status,course);

                service.addStudent(student);
            }

            // Display students
            else if (choice == 2) {

                service.displayStudents();
            }

            // Search ID
            else if (choice == 3) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                service.searchById(id);
            }

            // Search Name
            else if (choice == 4) {

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                service.searchByName(name);
            }

            // Update Marks
            else if (choice == 5) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                service.updateMarks(id, marks);
            }

            // Update Attendance
            else if (choice == 6) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                System.out.print("Enter attendance: ");
                int attendance = sc.nextInt();

                service.updateAttendance(
                        id,
                        attendance
                );
            }

            // Remove
            else if (choice == 7) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                service.removeStudent(id);
            }

            // Topper
            else if (choice == 8) {

                service.displayTopper();
            }

            // Grade
            else if (choice == 9) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                Student_details student =
                        service.students.get(id);

                if (student == null) {
                    System.out.println(
                            "Student not found."
                    );
                } else {
                    System.out.println(
                            "Grade: " +
                            student.getGrade()
                    );
                }
            }

            // Exit
            else if (choice == 0) {

                System.out.println("Thank you!");

                sc.close();

                break;
            }

            else {

                System.out.println(
                        "Invalid choice."
                );
            }
        }
    }
}