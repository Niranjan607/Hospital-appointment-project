package Shedule_Appoinment;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Hospital_AppoinmentMain {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final Hospital_Manager manager =
            new Hospital_Manager();

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm"
            );

    public static void main(String[] args) {

        while (true) {

            displayMenu();

            int choice =
                    readInt("Welcome to Meenakshi Hospital || Kindly Choose Your Option: ");

            try {

                switch (choice) {

                    case 1:
                        registerPatient();
                        break;

                    case 2:
                        addDoctor();
                        break;

                    case 3:
                        addDoctorSlot();
                        break;

                    case 4:
                        bookAppointment();
                        break;

                    case 5:
                        cancelAppointment();
                        break;

                    case 6:
                        viewAvailableSlots();
                        break;

                    case 7:
                        viewDoctorSchedule();
                        break;

                    case 8:
                        viewPatientHistory();
                        break;

                    case 9:
                        manager.viewAllPatients();
                        break;

                    case 10:
                        manager.viewAllDoctors();
                        break;

                    case 0:
                        System.out.println(
                                "Thank you!"
                        );
                        return;

                    default:
                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "ERROR: " +
                        e.getMessage()
                );
            }
        }
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println(
                "|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|"
        );
        System.out.println(
                " MEENAKSHI HOSPITAL APPOINTMENT "
        );
        System.out.println(
                "|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|"
        );

        System.out.println(
                "1. Register Patient"
        );

        System.out.println(
                "2. Add Doctor"
        );

        System.out.println(
                "3. Add Doctor Slot"
        );

        System.out.println(
                "4. Book Appointment"
        );

        System.out.println(
                "5. Cancel Appointment"
        );

        System.out.println(
                "6. View Available Slots"
        );

        System.out.println(
                "7. View Doctor Schedule"
        );

        System.out.println(
                "8. View Patient History"
        );

        System.out.println(
                "9. View All Patients"
        );

        System.out.println(
                "10. View All Doctors"
        );

        System.out.println(
                "0. Exit"
        );

        System.out.println(
                "|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|"
        );
    }

    private static void registerPatient() {

        int id =
                readInt("Enter Patient ID: ");

        String name =
                readString("Enter Patient Name: ");

        int age =
                readInt("Enter Age: ");

        String phone =
                readString("Enter Phone: ");


        Patient_Details patient =
                new Patient_Details(
                        id,
                        name,
                        age,
                        phone
                );

        manager.registerPatient(patient);
    }

    private static void addDoctor() {

        int id =
                readInt("Enter Doctor ID: ");

        String name =
                readString("Enter Doctor Name: ");

        String specialization =
                readString(
                        "Enter Specialization: "
                );

        Doctor_Details doctor =
                new Doctor_Details(
                        id,
                        name,
                        specialization
                );

        manager.addDoctor(doctor);
    }

    private static void addDoctorSlot()
            throws Nodoctor_details {

        int doctorId =
                readInt("Enter Doctor ID: ");

        LocalDateTime slot =
                readDateTime(
                        "Enter slot " +
                        "(dd-MM-yyyy HH:mm): "
                );

        manager.addDoctorSlot(
                doctorId,
                slot
        );
    }

    private static void bookAppointment()
            throws sheduleNot_Available,
            Nodoctor_details,
            Nopatient_details {

        int patientId =
                readInt("Enter Patient ID: ");

        int doctorId =
                readInt("Enter Doctor ID: ");

        LocalDateTime slot =
                readDateTime(
                        "Enter slot " +
                        "(dd-MM-yyyy HH:mm): "
                );

        manager.bookAppointment(
                patientId,
                doctorId,
                slot
        );
    }

    private static void cancelAppointment()
            throws sheduleNot_Available, AppointmentNot_Found {

        int appointmentId =
                readInt(
                        "Enter Appointment ID: "
                );

        manager.cancelAppointment(
                appointmentId
        );
    }

    private static void viewAvailableSlots()
            throws Nodoctor_details {

        int doctorId =
                readInt("Enter Doctor ID: ");

        manager.viewAvailableSlots(
                doctorId
        );
    }

    private static void viewDoctorSchedule()
            throws Nodoctor_details {

        int doctorId =
                readInt("Enter Doctor ID: ");

        manager.viewDoctorSchedule(
                doctorId
        );
    }

    private static void viewPatientHistory()
            throws Nopatient_details {

        int patientId =
                readInt("Enter Patient ID: ");

        manager.viewPatientHistory(
                patientId
        );
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Enter a valid number."
                );
            }
        }
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }

    private static LocalDateTime readDateTime(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                return LocalDateTime.parse(
                        scanner.nextLine().trim(),
                        FORMATTER
                );

            } catch (DateTimeParseException e) {

                System.out.println(
                        "Invalid format."
                );

                System.out.println(
                        "Example: 15-10-2026 10:30"
                );
            }
        }
    }
}