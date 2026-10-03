package Shedule_Appoinment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Doctor_Details {

    private int id;
    private String name;
    private String specialization;

    private List<LocalDateTime> availableSlots;

    public Doctor_Details(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<LocalDateTime> getAvailableSlots() {
        return availableSlots;
    }

    public void addSlot(LocalDateTime slot) {
        if (!availableSlots.contains(slot)) {
            availableSlots.add(slot);
        }
    }

    public void removeSlot(LocalDateTime slot) {
        availableSlots.remove(slot);
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id +
                ", Name: Dr. " + name +
                ", Specialization: " + specialization;
    }
}