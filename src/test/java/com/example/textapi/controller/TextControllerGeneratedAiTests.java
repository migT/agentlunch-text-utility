package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.textapi.service.TextService;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import java.util.regex.Pattern;

@Test
public class TextControllerGeneratedAiTests {

    private TextController textController;
    private TextService textService;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        TextService textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    public void helloWorld_returnsHelloWorld() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The helloWorld() method is called.
        // THEN: The method should return "Hello, World!".
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    public void reverse_returnsReversedString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The reverse() method is called with "hello" as input.
        // THEN: The method should return "olleh".
        assertEquals("olleh", textController.reverse("hello"));
    }

    @Test
    public void uppercase_returnsUppercaseString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The uppercase() method is called with "hello" as input.
        // THEN: The method should return "HELLO".
        assertEquals("HELLO", textController.uppercase("hello"));
    }

    @Test
    public void stats_returnsStatsMap() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The stats() method is called with "hello world" as input.
        // THEN: The method should return a map containing the length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords.
        Map<String, Object> result = textController.stats("hello world");
        assertEquals(7, result.size());
        assertEquals(10, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(3, result.get("VowelCount"));
        assertEquals(4, result.get("ConsonantCount"));
        assertEquals(0, result.get("RepeatedWords").length());
    }

    @Test
    public void replace_returnsReplacedString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The replace() method is called with "hello", "world", "universe" as target and replacement, and "hello" as input.
        // THEN: The method should return "hello".
        assertEquals("hello", textController.replace("hello", "world", "universe"));
    }

    @Test
    public void removeVowels_returnsStringWithoutVowels() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The removeVowels() method is called with "hello" as input.
        // THEN: The method should return "hll".
        assertEquals("hll", textController.removeVowels("hello"));
    }

    @Test
    public void removeConsonants_returnsStringWithoutConsonants() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The removeConsonants() method is called with "hello" as input.
        // THEN: The method should return "helo".
        assertEquals("helo", textController.removeConsonants("hello"));
    }

    @Test
    public void countOccurrence_returnsCorrectOccurrenceCount() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The countOccurrence() method is called with "hello world", "world" as keyword.
        // THEN: The method should return 1.
        assertEquals(1, textController.countOccurrence("hello world", "world"));
    }
}
