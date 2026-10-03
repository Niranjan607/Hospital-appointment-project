package StudentManagmentSystem;


public class Student_details {

    int id;
    String name;
    String email;
    double marks;
    int attendance;
    Student_Status status;
    Course course;
    Student_details(int id, String name, String email,
            double marks, int attendance,
            Student_Status status2, Course course) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.attendance = attendance;
        this.status = status2;
        this.course = course;
    }

    String getGrade() {

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    void display() {

        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + getGrade());
        System.out.println("Attendance : " + attendance + "%");
        System.out.println("Status     : " + status);
        System.out.println("Course     : " + course.courseName);
    }

	public void put(int id2, Student_details student) {
		// TODO Auto-generated method stub
		
	}

}