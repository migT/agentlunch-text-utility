package com.example.textapi.controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.example.textapi.service.TextService;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
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
        // GIVEN: A TextService instance is created.
        // WHEN: The helloWorld() method is called.
        // THEN: The "Hello, World!" string is returned.
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    void reverse() {
        // GIVEN: A TextService instance is created.
        // WHEN: The reverse() method is called with "hello" as input.
        // THEN: The reversed string "olleh" is returned.
        String input = "hello";
        String reversed = textController.reverse(input);
        assertEquals("olleh", reversed);
    }

    @Test
    void uppercase() {
        // GIVEN: A TextService instance is created.
        // WHEN: The uppercase() method is called with "hello" as input.
        // THEN: The uppercase string "HELLO" is returned.
        String input = "hello";
        String uppercase = textController.uppercase(input);
        assertEquals("HELLO", uppercase);
    }

    @Test
    void stats() {
        // GIVEN: A TextService instance is created.
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 5);
        expected.put("wordCount", 1);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 2);
        expected.put("ConsonantCount", 3);
        expected.put("RepeatedWords", Collections.emptyList());
        // WHEN: The stats() method is called with "hello" as input.
        // THEN: A map containing the calculated statistics is returned.
        Map<String, Object> actual = textController.stats("hello");
        assertEquals(expected, actual);
    }

    @Test
    void replace() {
        // GIVEN: A TextService instance is created.
        // WHEN: The replace() method is called with "hello", "world", "universe" as target and replacement, and "hello" as input.
        // THEN: The string "hello" is replaced with "universe".
        String input = "hello";
        String target = "world";
        String replacement = "universe";
        String replaced = textController.replace(input, target, replacement);
        assertEquals("hello", replaced);
    }

    @Test
    void removeVowels() {
        // GIVEN: A TextService instance is created.
        // WHEN: The removeVowels() method is called with "hello" as input.
        // THEN: The string "hll" is returned.
        String input = "hello";
        String removed = textController.removeVowels(input);
        assertEquals("hll", removed);
    }

    @Test
    void removeConsonants() {
        // GIVEN: A TextService instance is created.
        // WHEN: The removeConsonants() method is called with "hello" as input.
        // THEN: The string "he" is returned.
        String input = "hello";java
        String removed = textController.removeConsonants(input);
        assertEquals("he", removed);
    }

    @Test
    void countOccurrence() {
        // GIVEN: A TextService instance is created.
        // WHEN: The countOccurrence() method is called with "hello", "hello" asjava
        // THEN: The number of occurrences of "hello" in "hello" is 1.
        int count = textController.countOccurrence("hello", "hello");
        assertEquals(1, count);
    }

    @Test
    void helloworld() {
        // GIVEN: A TextService instance is created.
        // WHEN: The helloworld() method is called.
        // THEN: The "Hello, World!" string is returned.
        String helloWorld = textController.helloworld();
        assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A TextService instance is created.
        // WHEN: The convertJsonToYaml() method is called with a JSON string.
        // THEN: The YAML representation of the JSON string is returned.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String yaml = textController.convertJsonToYaml(json);
        assertEquals("{\n  \"name\": \"John\",\n  \"age\": 30\n}", yaml);
    }

    @Test
    void convertJsonToXml() {
        // GIVEN: A TextService instance is created.
        // WHEN: The convertJsonToXml() method is called with a JSON string.
        // THEN: The XML representation of the JSON string is returned.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String xml = textController.convertJsonToXml(json);
        assertEquals("<?xml version=\"1.0\"?>\n<root>\n  <name>John</name>\n  <age>30</age>\n</root>", xml);
    }
}