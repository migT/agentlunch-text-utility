package com.example.textapi.service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

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
        // GIVEN: Create a new instance before each test to reset state
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercaseString_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testUppercase_withMixedCaseString_returnsUppercase() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello Java";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(21, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue((Integer) stats.get("VowelCount") > 0);
        assertTrue((Integer) stats.get("ConsonantCount") > 0);
        assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    void testStats_withEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        assertTrue(((List<?>) stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
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
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello Java", result);
    }

    @Test
    void testReplace_withTargetNotFound_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "Python";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
    String input = "Hello World";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "bcdfg";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("bcdfg", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCount() {
        // GIVEN
        String input = "Java is great. I love Java. Java!";
        String keyword = "Java";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "Python is great.";
        String keyword = "Java";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testHelloworld_returnsHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}