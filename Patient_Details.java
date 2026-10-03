package Shedule_Appoinment;

public class Patient_Details {

    private int id;
    private String name;
    private int age;
    private String phone;
    private String email;

    public Patient_Details(int id, String name, int age,
                   String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
    public String toString() {
        return "Patient ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}