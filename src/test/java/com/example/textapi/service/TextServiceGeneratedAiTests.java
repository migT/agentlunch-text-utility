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

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("dcba", result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertTrue(stats.containsKey("length"));
        assertTrue(stats.containsKey("wordCount"));
        assertTrue(stats.containsKey("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertFalse(repeated.isEmpty());
        assertTrue(repeated.stream().anyMatch(s -> s.contains("apple")));
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "I love Java";
        // WHEN
        String result = textService.replace(input, "Java", "Python");
        // THEN
        assertEquals("I love Python", result);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. I love Java programming.";
        // WHEN
        int count = textService.countOccurrence(input, "Java");
        // THEN
        assertEquals(2, count);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYamlValid() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.contains("name: \"John\"") || result.contains("name: John"));
    }

    @Test
    void testConvertJsonToYamlInvalid() {
        // GIVEN
        String invalidJson = "{name:John}";
        // WHEN
        String result = textService.convertJsonToYaml(invalidJson);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlValid() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.contains("<name>John</name>"));
    }

    @Test
    void testConvertJsonToXmlInvalid() {
        // GIVEN
        String invalidJson = "{name:John}";
        // WHEN
        String result = textService.convertJsonToXml(invalidJson);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
