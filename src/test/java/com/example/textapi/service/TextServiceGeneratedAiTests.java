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

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("cba", result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("ABC", result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World\nHello";
        // WHEN
        Map<String, Object> result = textService.stats(input);
        // THEN
        assertEquals(17, result.get("length"));
        assertEquals(3, result.get("wordCount"));
        assertEquals(2, result.get("lineCount"));
        assertTrue((Integer) result.get("VowelCount") > 0);
        assertTrue((Integer) result.get("ConsonantCount") > 0);
        assertTrue(((List<String>) result.get("RepeatedWords")).size() > 0);
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "test test value value value";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("test : 2"));
        assertTrue(result.contains("value : 3"));
    }

    @Test
    void testGetRepeatedWordsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.replace(input, "World", "Java");
        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        // WHEN
        int count = textService.countOccurrence(input, "Java");
        // THEN
        assertEquals(2, count);
    }

    @Test
    void testHelloworld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYamlValid() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.contains("name: \"John\"") || result.contains("name: John"));
    }

    @Test
    void testConvertJsonToYamlInvalid() {
        // GIVEN
        String json = "{name:John}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlValid() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.contains("<name>John</name>"));
    }

    @Test
    void testConvertJsonToXmlInvalid() {
        // GIVEN
        String json = "{name:John}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
