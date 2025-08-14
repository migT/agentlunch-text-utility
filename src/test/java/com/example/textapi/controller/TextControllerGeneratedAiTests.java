package com.example.textapi.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import com.example.textapi.service.TextService;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MockitoExtension;
import org.junit.jupiter.api.extension.MockitoJUnitRunner;

@ExtendWith(MockitoExtension.class)
@MockitoJUnitRunner
public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
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
        // WHEN: The stats() method is called with "hello" as input.
        // THEN: The method should return a map containing the length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords.
        Map<String, Object> result = textController.stats("hello");
        assertNotNull(result);
        assertEquals(7, result.size());
        assertEquals(5, result.get("length"));
        assertEquals(1, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(1, result.get("VowelCount"));
        assertEquals(1, result.get("ConsonantCount"));
        assertEquals(0, result.get("RepeatedWords").length());
    }

    @Test
    public void replace_returnsReplacedString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The replace() method is called with "hello", "world", "universe" and "hello" as input.
        // THEN: The method should return "universe".
        assertEquals("universe", textController.replace("hello", "world", "universe"));
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
        // THEN: The method should return "eoo".
        assertEquals("eoo", textController.removeConsonants("hello"));
    }

    @Test
    public void countOccurrence_returnsCorrectCount() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The countOccurrence() method is called with "hello", "hello" as input.
        // THEN: The method should return 1.
        assertEquals(1, textController.countOccurrence("hello", "hello"));
    }

    @Testjava
    @Test
    public void convertJsonToYaml_returnsYamlString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The convertJsonToYaml() method is called with a valid JSON string.
        // THEN: The method should return the YAML representation of the JSON string.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String yaml = textController.convertJsonToYaml(json);
        assertEquals("name: John\nage: 30\n", yaml);
    }

    @Test
    public void convertJsonToXml_returnsXmlString() {
        // GIVEN: A new TextController instance is created.
        // WHEN: The convertJsonToXml() method is called with a valid JSON string.
        // THEN: The method should return the XML representation of the JSON string.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String xml = textController.convertJsonToXml(json);
        assertEquals("<name>John</name><age>30</age>", xml);
    }
}
