package Shedule_Appoinment;

import java.time.LocalDateTime;
import java.util.Map.Entry;

public class Appointment_Check {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDateTime dateTime;
    private String status;

    public Appointment_Check(int AppointmentId,
                       int patientId,
                       int doctorId,
                       LocalDateTime dateTime) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.status = "BOOKED";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId +
                ", Patient ID: " + patientId +
                ", Doctor ID: " + doctorId +
                ", Date & Time: " + dateTime +
                ", Status: " + status;
    }

	public static Entry<String, AppointmentNot_Found>[] entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void remove(String keyToRemove) {
		// TODO Auto-generated method stub
		
	}

}