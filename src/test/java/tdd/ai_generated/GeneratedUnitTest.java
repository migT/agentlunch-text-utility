
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

package tdd.ai_generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeneratedUnitTest {

    private GeneratedCode generatedCode;

    @BeforeEach
    public void setUp() {
        generatedCode = new GeneratedCode();
    }

    @Test
    public void testGetTodayAppointments() {
        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertNotNull(todayAppointments);
        assertEquals(1, todayAppointments.size());
        assertEquals("Appointment 1", todayAppointments.get(0).getDescription());
    }

    @Test
    public void testGetTodayAppointmentsEmpty() {
        // Arrange
        List<Appointment> appointments = Arrays.asList();
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertNotNull(todayAppointments);
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsNoAppointments() {
        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertNotNull(todayAppointments);
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsWithFutureDate() {
        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 4));

        // Assert
        assertNotNull(todayAppointments);
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsWithPastDate() {
        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 9, 30));

        // Assert
        assertNotNull(todayAppointments);
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsWithNullDate() {
        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            generatedCode.getTodayAppointments(null);
        });
    }
}