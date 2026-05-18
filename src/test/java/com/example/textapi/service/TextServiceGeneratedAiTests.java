package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
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
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
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
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
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
    void testReplace_withNoMatch_returnsOriginal() {
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
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
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
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
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