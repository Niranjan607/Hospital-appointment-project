package Shedule_Appoinment;

import java.time.LocalDateTime;

public class AppointmentNot_Found extends Exception {

    public AppointmentNot_Found(String message) {
        super(message);
    }

	public int getAppointmentId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getDoctorId() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDateTime getDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}
}