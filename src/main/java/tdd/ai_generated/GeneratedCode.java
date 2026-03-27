
package tdd.ai_generated;

import java.time.LocalDate;
import java.util.List;

public class GeneratedCode {

    private List<Appointment> appointments;

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Appointment> getTodayAppointments(LocalDate date) {
        return appointments.stream()
                .filter(appointment -> appointment.getDate().equals(date))
                .toList();
    }
}