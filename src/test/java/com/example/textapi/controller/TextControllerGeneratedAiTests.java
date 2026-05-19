package com.example.textapi.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MockitoExtension;
import org.junit.jupiter.api.extension.MockitoJUnitRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = Mockito.createMock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_returnsHelloWorld() {
        // GIVEN: A TextService instance is created.
        // WHEN: The helloWorld() method is called.
        // THEN: The HELLO_WORLD string is returned.
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN: A TextService instance is created.
        // WHEN: The reverse() method is called with "hello" as input.
        // THEN: "olleh" is returned.
        String input = "hello";
        String reversed = textController.reverse(input);
        assertEquals("olleh", reversed);
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN: A TextService instance is created.
        // WHEN: The uppercase() method is called with "hello" as input.
        // THEN: "HELLO" is returned.
        String input = "hello";
        String uppercase = textController.uppercase(input);
        assertEquals("HELLO", uppercase);
    }

    @Test
    void stats_returnsStatsMap() {
        // GIVEN: A TextService instance is created.
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 5);
        expectedStats.put("wordCount", 1);
        expectedStats.put("lineCount", 1);
        expectedStats.put("VowelCount", 2);
        expectedStats.put("ConsonantCount", 3);
        expectedStats.put("RepeatedWords", Collections.emptyList());
        // WHEN: The stats() method is called with "hello" as input.
        // THEN: The expectedStats map is returned.
        Map<String, Object> actualStats = textController.stats("hello");
        assertEquals(expectedStats, actualStats);
    }

    @Test
    void replace_returnsReplacedString() {
        // GIVEN: A TextService instance is created.
        // WHEN: The replace() method is called with "hello", "world", "universe" and "hello" as input.
        // THEN: "universe" is returned.
        String input = "hello";
        String target = "world";
        String replacement = "universe";
        String replaced = textController.replace(input, target, replacement);
        assertEquals("universe", replaced);
    }

    @Test
    void removeVowels_returnsStringWithoutVowels() {
        // GIVEN: A TextService instance is created.
        // WHEN: The removeVowels() method is called with "hello" as input.
        // THEN: "hll" is returned.
        String input = "hello";
        String withoutVowels = textController.removeVowels(input);
        assertEquals("hll", withoutVowels);java
        assertEquals("eoo", withoutConsonants);
    }

    @Test
    void countOccurrence_returnsCorrectOccurrenceCount() {
        // GIVEN: A TextService instance is created.
        // WHEN: The countOccurrence() method is called with "hello", "l" as keyword.
        // THEN: 1 is returned.
        String input = "hello";
        int occurrenceCount = textController.countOccurrence("l", "l");
        assertEquals(1, occurrenceCount);
    }

    @Test
    void convertJsonToYaml_returnsYamlString() {
        // GIVEN: A TextService instance is created.
        // WHEN: The convertJsonToYaml() method is called with a valid JSON string.
        // THEN: The corresponding YAML string is returned.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String yaml = textController.convertJsonToYaml(json);
        assertEquals("{\n  \"name\": \"John\",\n  \"age\": 30\n}", yaml);
    }

    @Test
    void convertJsonToXml_returnsXmlString() {
        // GIVEN: A TextService instance is created.
        // WHEN: The convertJsonToXml() method is called with a valid JSON string.
        // THEN: The corresponding XML string is returned.
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String xml = textController.convertJsonToXml(json);
        assertEquals("<?xml version=\"1.0\"?>\n<root>\n  <name>John</name>\n  <age>30</age>\n</root>", xml);
    }
}