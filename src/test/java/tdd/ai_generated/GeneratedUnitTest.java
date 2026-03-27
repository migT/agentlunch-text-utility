
package tdd.ai_generated;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeneratedUnitTest {

    @Test
    public void testGetTodayAppointments() {
        GeneratedCode generatedCode = new GeneratedCode();

        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertEquals(2, todayAppointments.size());
        assertEquals("Appointment 1", todayAppointments.get(0).getDescription());
        assertEquals("Appointment 3", todayAppointments.get(1).getDescription());
    }

    @Test
    public void testGetTodayAppointmentsEmpty() {
        GeneratedCode generatedCode = new GeneratedCode();

        // Arrange
        List<Appointment> appointments = Arrays.asList();
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsNoAppointments() {
        GeneratedCode generatedCode = new GeneratedCode();

        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 3), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act
        List<Appointment> todayAppointments = generatedCode.getTodayAppointments(LocalDate.of(2023, 10, 1));

        // Assert
        assertEquals(0, todayAppointments.size());
    }

    @Test
    public void testGetTodayAppointmentsNullDate() {
        GeneratedCode generatedCode = new GeneratedCode();

        // Arrange
        List<Appointment> appointments = Arrays.asList(
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 1"),
            new Appointment(LocalDate.of(2023, 10, 2), "Appointment 2"),
            new Appointment(LocalDate.of(2023, 10, 1), "Appointment 3")
        );
        generatedCode.setAppointments(appointments);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            generatedCode.getTodayAppointments(null);
        });
    }
}