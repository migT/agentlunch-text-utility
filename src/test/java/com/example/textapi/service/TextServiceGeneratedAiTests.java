package com.example.textapi.service;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Create a new instance before each test to reset state
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("olleH", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercaseString_returnsUppercase() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void testUppercase_withMixedCaseString_returnsUppercase() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue((Integer)stats.get("VowelCount") > 0);
        assertTrue((Integer)stats.get("ConsonantCount") > 0);
        assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    void testStats_withEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        assertTrue(((List<?>)stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.contains("apple : 3"));
        assertTrue(repeated.contains("banana : 2"));
        assertFalse(repeated.contains("orange : 1"));
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void testReplace_withNoTarget_returnsOriginal() {
        // GIVEN
        String input = "Hello World";
        String target = "Python";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("Hello World", result);
    }
}