package com.example.textapi.controller;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.extension.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
@MockitoJUnitRunner
public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = Mockito.createMock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld() {
        // GIVEN: A mock TextService instance
        // WHEN: The helloWorld method is called
        // THEN: The "Hello, World!" string is returned
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    void reverse() {
        // GIVEN: A mock TextService instance
        // WHEN: The reverse method is called with "hello"
        // THEN: "olleh" is returned
        Mockito.when(textService.reverse("hello")).thenReturn("olleh");
        assertEquals("olleh", textController.reverse("hello"));
    }

    @Test
    void uppercase() {
        // GIVEN: A mock TextService instance
        // WHEN: The uppercase method is called with "hello"
        // THEN: "HELLO" is returned
        Mockito.when(textService.uppercase("hello")).thenReturn("HELLO");
        assertEquals("HELLO", textController.uppercase("hello"));
    }

    @Test
    void stats() {
        // GIVEN: A mock TextService instance
        // WHEN: The stats method is called with "hello"
        // THEN: A map with length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords is returned
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 5);
        expected.put("wordCount", 1);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 2);
        expected.put("ConsonantCount", 3);
        expected.put("RepeatedWords", Collections.emptyList());
        Mockito.when(textService.stats("hello")).thenReturn(expected);
        Map<String, Object> actual = textController.stats("hello");
        assertEquals(expected, actual);
    }

    @Test
    void replace() {
        // GIVEN: A mock TextService instance
        // WHEN: The replace method is called with "hello", "world", "universe"
        // THEN: "hello" is returned
        Mockito.when(textService.replace("hello", "world", "universe")).thenReturn("hello");
        assertEquals("hello", textController.replace("hello", "world", "universe"));
    }

    @Test
    void removeVowels() {
        // GIVEN: A mock TextService instance
        // WHEN: The removeVowels method is called with "hello"
        // THEN: "hll" is returned
        Mockito.when(textService.removeVowels("hello")).thenReturn("hll");
        assertEquals("hll", textController.removeVowels("hello"));
    }

    @Test
    void removeConsonants() {
        // GIVEN: A mock TextService instance
        // WHEN: The removeConsonants method is called with "hello"
        // THEN: "he" is returned
        Mockito.when(textService.removeConsonants("hello")).thenReturn("he");
        assertEquals("he", textController.removeConsonants("hello"));java
        assertEquals("he", textController.removeConsonants("hello"));
    }

    @Test
    void countOccurrence() {
        // GIVEN: A mock TextService instance
        // WHEN: The countOccurrence method is called with "hello", "hello"
        // THEN: 1 is returned
        Mockito.when(textService.countOccurrence("hello", "hello")).thenReturn(1);
        assertEquals(1, textController.countOccurrence("hello", "hello"));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToYaml method is called with a JSON string
        // THEN: The YAML representation of the JSON string is returned
        Mockito.when(textService.convertJsonToYaml("{\"key\": \"value\"}")).thenReturn("key: value");
        assertEquals("key: value", textController.convertJsonToYaml("{\"key\": \"value\"}"));
    }

    @Test
    void convertJsonToXml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToXml method is called with a JSON string
        // THEN: The XML representation of the JSON string is returned
        Mockito.when(textService.convertJsonToXml("{\"key\": \"value\"}"))
                .thenReturn("<key>value</key>");
        assertEquals("<key>value</key>", textController.convertJsonToXml("{\"key\": \"value\"}"));
    }
}