package com.example.textapi.service;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "abc";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("cba", result);
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "abc";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("ABC", result);
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
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
    public void testGetRepeatedWords() {
        // GIVEN
        String input = "test test example";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("test : 2"));
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.replace(input, "World", "Java");
        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll", result);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo", result);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. I love Java.";
        // WHEN
        int count = textService.countOccurrence(input, "Java");
        // THEN
        assertEquals(2, count);
    }

    @Test
    public void testHelloworld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testConvertJsonToYamlValid() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.contains("name: \"John\"") || result.contains("name: 'John'") || result.contains("name: John"));
    }

    @Test
    public void testConvertJsonToYamlInvalid() {
        // GIVEN
        String json = "{name:John}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    public void testConvertJsonToXmlValid() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.contains("<name>John</name>"));
    }

    @Test
    public void testConvertJsonToXmlInvalid() {
        // GIVEN
        String json = "{name:John}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
