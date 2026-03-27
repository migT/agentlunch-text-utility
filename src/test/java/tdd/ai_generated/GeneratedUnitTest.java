
package tdd.ai_generated;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getVowelCount(String input) {
        // Implement logic to count vowels
        return 0;
    }

    private Integer getConsonantCount(String input) {
        // Implement logic to count consonants
        return 0;
    }
}

package tdd.ai_generated;

import java.time.LocalDate;

public class Appointment {
    private LocalDate date;
    private String description;

    public Appointment(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}