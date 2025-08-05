package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello hello\nWorld world";

        // WHEN
        Map<String, Object> stats = textController.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("hello there", result);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("hll", result);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, count);
    }

    @Test
    public void testJsonToYaml_ValidJson() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textController.jsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("key:"));
        assertTrue(yaml.contains("value"));
    }

    @Test
    public void testJsonToYaml_InvalidJson() {
        // GIVEN
        String json = "{invalid json}";

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
        assertTrue(xml.contains("<key>value</key>"));
    }

    @Test
    public void testJsonToXml_InvalidJson() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textController.jsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}
