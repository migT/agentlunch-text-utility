package com.example.textapi.service;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
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
    void testReverseWithNormalString() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverseWithEmptyString() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercaseWithLowercaseInput() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void testUppercaseWithMixedCaseInput() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStatsWithSimpleText() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
    }

    @Test
    void testStatsWithEmptyString() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
    }

    @Test
    void testGetRepeatedWordsWithNoRepeats() {
        // GIVEN
        String input = "one two three";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testGetRepeatedWordsWithRepeats() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.contains("apple : 3"));
        assertTrue(repeated.contains("banana : 2"));
        assertEquals(2, repeated.size());
    }

    @Test
    void testGetRepeatedWordsWithNullInput() {
        // GIVEN
        String input = null;
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testReplaceWithValidInput() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplaceWithNoMatch() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
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
        assertEquals("eoOo", result);
    }

    @Test
    void testCountOccurrenceWithSingleOccurrence() {
        // GIVEN
        String input = "apple bananaapple orange";
        String keyword = "banana";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(1, count);
    }

    @Test
    void testCountOccurrenceWithMultipleOccurrences() {
        // GIVEN
        String input = "cat dog cat bird cat";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrenceWithNoOccurrences() {
        // GIVEN
        String input = "apple banana orange";
        String keyword = "grape";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrenceWithCaseInsensitive() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld() {
        // GIVEN
        // No setup required
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYamlWithValidJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYamlWithInvalidJson() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXmlWithValidJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXmlWithInvalidJson() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}