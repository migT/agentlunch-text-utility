package com.example.textapi.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
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
        // WHEN: The helloWorld() method is called
        // THEN: "Hello, World!" is returned
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    void reverse() {
        // GIVEN: A mock TextService instance
        // WHEN: The reverse() method is called with "hello"
        // THEN: "olleh" is returned
        String input = "hello";
        String expected = "olleh";
        Mockito.when(textService.reverse(input)).thenReturn(expected);
        assertEquals(expected, textController.reverse(input));
    }

    @Test
    void uppercase() {
        // GIVEN: A mock TextService instance
        // WHEN: The uppercase() method is called with "hello"
        // THEN: "HELLO" is returned
        String input = "hello";
        String expected = "HELLO";
        Mockito.when(textService.uppercase(input)).thenReturn(expected);
        assertEquals(expected, textController.uppercase(input));
    }

    @Test
    void stats() {
        // GIVEN: A mock TextService instance
        // WHEN: The stats() method is called with "hello"
        // THEN: A map with length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords is returned
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 5);
        expected.put("wordCount", 1);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 2);
        expected.put("ConsonantCount", 3);
        expected.put("RepeatedWords", Collections.emptyList());
        Mockito.when(textService.stats(input())).thenReturn(expected);
        Map<String, Object> actual = textController.stats("hello");
        assertEquals(actual, textController.stats("hello"));
    }

    @Test
    void replace() {
        // GIVEN: A mock TextService instance
        // WHEN: The replace() method is called with "hello", "world", "universe"
        // THEN: "hello" is returned
        String input = "hello";
        String target = "world";
        String replacement = "universe";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn("hello");
        assertEquals("hello", textController.replace(input, target, replacement));
    }

    @Test
    void removeVowels() {
        // GIVEN: A mock TextService instance
        // WHEN: The removeVowels() method is called with "hello"
        // THEN: "hll" is returned
        String input = "hello";
        Mockito.when(textService.removeVowels(input)).thenReturn("hll");
        assertEquals("hll", textController.removeVowels(input));
    }

    @Test
    void removeConsonants() {
        // GIVEN: A mock TextService instance
        // WHEN: The removeConsonantsjava
        // WHEN: The removeConsonants() method is called with "hello"
        // THEN: "helo" is returned
        String input = "hello";
        Mockito.when(textService.removeConsonants(input)).thenReturn("helo");
        assertEquals("helo", textController.removeConsonants(input));
    }

    @Test
    void countOccurrence() {
        // GIVEN: A mock TextService instance
        // WHEN: The countOccurrence() method is called with "hello", "hello"
        // THEN: 1 is returned
        String input = "hello";
        String keyword = "hello";
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(1);
        assertEquals(1, textController.countOccurrence(keyword, input));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToYaml() method is called with "{"json":"hello"}"
        // THEN: "hello" is returned
        String json = "{json:hello}";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn("hello");
        assertEquals("hello", textController.convertJsonToYaml(json));
    }

    @Test
    void convertJsonToXml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToXml() method is called with "{"json":"hello"}"
        // THEN: "hello" is returned
        String json = "{json:hello}";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn("hello");
        assertEquals("hello", textController.convertJsonToXml(json));
    }
}