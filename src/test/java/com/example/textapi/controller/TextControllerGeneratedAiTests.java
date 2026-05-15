package com.example.textapi.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

public class TextControllerGeneratedAiTests {

    private TextController textController;
    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    public void testHelloWorld() {
        // GIVEN
        // no additional setup needed

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("321cba", result);
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello hello\nWorld! World";

        // WHEN
        Map<String, Object> stats = textController.stats(input);

        // THEN
        assertNotNull(stats);
        assertTrue(stats.containsKey("length"));
        assertTrue(stats.containsKey("wordCount"));
        assertTrue(stats.containsKey("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
        assertEquals(24, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.get("VowelCount") instanceof Integer);
        assertTrue(stats.get("ConsonantCount") instanceof Integer);
        assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("baz bar baz", result);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "apple banana apple Apple";
        String keyword = "apple";

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, count);
    }

    @Test
    public void testJsonToYaml_ValidJson() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textController.jsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("key: value") || yaml.contains("key: \"value\""));
    }

    @Test
    public void testJsonToYaml_InvalidJson() {
        // GIVEN
        String json = "{key:\"value\""; // invalid JSON

        // WHEN
        String yaml = textController.jsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testJsonToXml_ValidJson() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textController.jsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<key>value</key>"));
    }

    @Test
    public void testJsonToXml_InvalidJson() {
        // GIVEN
        String json = "{key:\"value\""; // invalid JSON

        // WHEN
        String xml = textController.jsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}
