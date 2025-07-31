package com.example.textapi.service;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class TextServiceGeneratedAiTests {

    private TextService textService = new TextService();

    @BeforeEach
    void setUp() {
        // Reset any modified state before each test
    }

    @Test
    @DisplayName("Test reverse method")
    void testReverseMethod() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("dlroW olleH", result);
    }

    @Test
    @DisplayName("Test uppercase method")
    void testUppercaseMethod() {
        // GIVEN
        String input = "hello, world!";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO, WORLD!", result);
    }

    @Test
    @DisplayName("Test stats method")
    void testStatsMethod() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        // WHEN
        Map<String, Object> result = textService.stats(input);
        // THEN
        assertEquals(5, (int) result.get("length"));
        assertEquals(6, (int) result.get("wordCount"));
        assertEquals(2, (int) result.get("lineCount"));
        assertEquals(4, (int) result.get("VowelCount"));
        assertEquals(3, (int) result.get("ConsonantCount"));
    }

    @Test
    @DisplayName("Test replace method")
    void testReplaceMethod() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("Hello, Java!", result);
    }

    @Test
    @DisplayName("Test removeVowels method")
    void testRemoveVwlsMethod() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll, Wrld!", result);
    }

    @Test
    @DisplayName("Test removeConsonants method")
    void testRemoveConsMethod() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo, o!", result);
    }

    @Test
    @DisplayName("Test countOccurrence method")
    void testCountOccurrenceMethod() {
        // GIVEN
        String input = "Hello, World! Hello, Java!";
        String keyword = "Hello";
        // WHEN
        int result = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test helloworld method")
    void testHelloworldMethod() {
        // GIVEN
        // No input needed for this method
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }
}
