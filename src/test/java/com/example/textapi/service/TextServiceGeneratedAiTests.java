package com.example.textapi.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

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
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> result = textService.stats(input);
        // THEN
        assertNotNull(result);
        assertTrue(result.containsKey("length"));
        assertTrue(result.containsKey("wordCount"));
        assertTrue(result.containsKey("lineCount"));
        assertTrue(result.containsKey("VowelCount"));
        assertTrue(result.containsKey("ConsonantCount"));
        assertTrue(result.containsKey("RepeatedWords"));
    }

    @Test
    void testGetRepeatedWordsWithDuplicates() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.stream().anyMatch(s -> s.contains("apple")));
        assertTrue(result.stream().anyMatch(s -> s.contains("banana")));
    }

    @Test
    void testGetRepeatedWordsEmptyInput() {
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
        String input = "Java is great. I love Java. Java rocks!";
        // WHEN
        int count = textService.countOccurrence(input, "Java");
        // THEN
        assertEquals(3, count);
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
        String json = "{invalid json}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
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
        String json = "{invalid json}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
