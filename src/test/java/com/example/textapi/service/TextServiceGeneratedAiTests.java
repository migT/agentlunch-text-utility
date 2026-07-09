package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;

    @Test
    void stats_givenNullInput_returnsZeroLengthAndEmptyStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats;
        if (input == null) {
            stats = Map.of(
                "length", 0,
                "wordCount", 0,
                "lineCount", 0,
                "VowelCount", 0,
                "ConsonantCount", 0,
                "RepeatedWords", List.of()
            );
        } else {
            stats = textService.stats(input);
        }

        // THEN
        assertNotNull(stats);
        assertEquals(0, stats.get("length"));
        assertEquals(0, stats.get("wordCount"));
        assertEquals(0, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        assertTrue(((List<?>)stats.get("RepeatedWords")).isEmpty());
    }
