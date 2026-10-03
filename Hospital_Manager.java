package Shedule_Appoinment;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Hospital_Manager {

    private Map<Integer, Patient_Details> patients;
    private Map<Integer, Doctor_Details> doctors;
    private Map<String, Appointment_Check> appointments;
    private int appointmentCounter = 1001;

    public Hospital_Manager() {
        patients = new HashMap<>();
        doctors = new HashMap<>();
        appointments = new HashMap<>();
    }

    // Register Patient
    public void registerPatient(Patient_Details patient) {

        if (patients.containsKey(patient.getId())) {
            System.out.println("Patient ID already exists.");
            return;
        }

        patients.put(patient.getId(), patient);

        System.out.println("Patient registered successfully.");
    }

    // Add Doctor
    public void addDoctor(Doctor_Details doctor) {

        if (doctors.containsKey(doctor.getId())) {
            System.out.println("Doctor ID already exists.");
            return;
        }

        doctors.put(doctor.getId(), doctor);

        System.out.println("Doctor added successfully.");
    }

    // Add Doctor Slot
    public void addDoctorSlot(
            int doctorId,
            LocalDateTime slot)
            throws Nodoctor_details {

    	Doctor_Details doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new Nodoctor_details(
                    "Doctor not found."
            );
        }

        doctor.addSlot(slot);

        System.out.println("Slot added successfully.");
    }

    // Book Appointment
    public void bookAppointment(
            int patientId,
            int doctorId,
            LocalDateTime slot)
            throws Nopatient_details,
            Nodoctor_details,
            sheduleNot_Available {

        if (!patients.containsKey(patientId)) {
            throw new Nopatient_details(
                    "Patient not found."
            );
        }

        Doctor_Details doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new Nodoctor_details(
                    "Doctor not found."
            );
        }

        if (!doctor.getAvailableSlots().contains(slot)) {
            throw new sheduleNot_Available(
                    "Slot is not available."
            );
        }

        String key = doctorId + "_" + slot;

        if (appointments.containsKey(key)) {
            throw new sheduleNot_Available(
                    "Slot is already booked."
            );
        }

        Appointment_Check appointment =
                new Appointment_Check(
                        appointmentCounter++,
                        patientId,
                        doctorId,
                        slot
                );

        appointments.put(key, appointment);

        doctor.removeSlot(slot);

        System.out.println(
                "Appointment booked successfully."
        );

        System.out.println(
                "Appointment ID: " +
                appointment.getAppointmentId()
        );
    }

    // Cancel Appointment
    public void cancelAppointment(int appointmentId)
            throws AppointmentNot_Found, sheduleNot_Available {

    	AppointmentNot_Found appointment = null;
        String keyToRemove = null;

        for (Map.Entry<String, AppointmentNot_Found> entry :
                Appointment_Check.entrySet()) {

            if (entry.getValue().getAppointmentId()
                    == appointmentId) {

                appointment = entry.getValue();
                keyToRemove = entry.getKey();
                break;
            }
        }

        if (appointment == null) {
            throw new sheduleNot_Available(
                    "Appointment not found."
            );
        }

        Doctor_Details doctor =
                doctors.get(appointment.getDoctorId());

        if (doctor != null) {
            doctor.addSlot(
                    appointment.getDateTime()
            );
        }

        appointment.setStatus("CANCELLED");

        Appointment_Check.remove(keyToRemove);

        System.out.println(
                "Appointment cancelled successfully."
        );
    }

    // View Available Slots
    public void viewAvailableSlots(int doctorId)
            throws Nodoctor_details {

        Doctor_Details doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new Nodoctor_details(
                    "Doctor not found."
            );
        }

        System.out.println();
        System.out.println(
                "Available slots for Dr. " +
                doctor.getName()
        );

        if (doctor.getAvailableSlots().isEmpty()) {
            System.out.println(
                    "No available slots."
            );
            return;
        }

        for (LocalDateTime slot :
                doctor.getAvailableSlots()) {

            System.out.println(
                    slot.format(
                            java.time.format.DateTimeFormatter
                                    .ofPattern("dd-MM-yyyy HH:mm")
                    )
            );
        }
    }

    // View Doctor Schedule
    public void viewDoctorSchedule(int doctorId)
            throws Nodoctor_details {

        Doctor_Details doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new Nodoctor_details(
                    "Doctor not found."
            );
        }

        System.out.println();
        System.out.println(
                "Schedule of Dr. " +
                doctor.getName()
        );

        boolean found = false;

        for (Appointment_Check appointment : appointments.values()) {

            if (appointment.getDoctorId() == doctorId) {

                found = true;

                Patient_Details patient =
                        patients.get(
                                appointment.getPatientId()
                        );

                System.out.println(
                        "Appointment ID: " +
                        appointment.getAppointmentId()
                );

                System.out.println(
                        "Patient: " +
                        patient.getName()
                );

                System.out.println(
                        "Date & Time: " +
                        appointment.getDateTime()
                );

                System.out.println(
                        "Status: " +
                        appointment.getStatus()
                );

                System.out.println("----------------------");
            }
        }

        if (!found) {
            System.out.println(
                    "No appointments found."
            );
        }
    }

    // View Patient History
    public void viewPatientHistory(int patientId)
            throws Nopatient_details {

        Patient_Details patient = patients.get(patientId);

        if (patient == null) {
            throw new Nopatient_details(
                    "Patient not found."
            );
        }

        System.out.println();
        System.out.println(
                "History of " +
                patient.getName()
        );

        boolean found = false;

        for (Appointment_Check appointment :
                appointments.values()) {

            if (appointment.getPatientId() == patientId) {

                found = true;

                Doctor_Details doctor =
                        doctors.get(
                                appointment.getDoctorId()
                        );

                System.out.println(
                        "Appointment ID: " +
                        appointment.getAppointmentId()
                );

                System.out.println(
                        "Doctor: Dr. " +
                        doctor.getName()
                );

                System.out.println(
                        "Specialization: " +
                        doctor.getSpecialization()
                );

                System.out.println(
                        "Date & Time: " +
                        appointment.getDateTime()
                );

                System.out.println(
                        "Status: " +
                        appointment.getStatus()
                );

                System.out.println("----------------------");
            }
        }

        if (!found) {
            System.out.println(
                    "No appointment history."
            );
        }
    }

    // View All Patients
    public void viewAllPatients() {

        if (patients.isEmpty()) {
            System.out.println(
                    "No patients found."
            );
            return;
        }

        for (Patient_Details patient :
                patients.values()) {

            System.out.println(patient);
        }
    }

    // View All Doctors
    public void viewAllDoctors() {

        if (doctors.isEmpty()) {
            System.out.println(
                    "No doctors found."
            );
            return;
        }

        for (Doctor_Details doctor :
                doctors.values()) {

            System.out.println(doctor);
        }
    }
}