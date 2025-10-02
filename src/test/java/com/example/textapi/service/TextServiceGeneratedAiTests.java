package com.example.textapi.service;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Create a new instance of TextService before each test to reset state
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
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue((Integer)stats.get("VowelCount") > 0);
        assertTrue((Integer)stats.get("ConsonantCount") > 0);
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
        assertTrue(((List<?>)stats.get("RepeatedWords")).isEmpty());
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
        assertFalse(repeated.contains("orange : 1"));
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "one two three";
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
    void testGetConsonantCount_withMixedText_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        Integer count = textService.stats(input).get("ConsonantCount") instanceof Integer
            ? (Integer) textService.stats(input).get("ConsonantCount")
            : null;
        // THEN
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    void testGetVowelCount_withMixedText_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        Integer count = textService.stats(input).get("VowelCount") instanceof Integer
            ? (Integer) textService.stats(input).get("VowelCount")
            : null;
        // THEN
        assertNotNull(count);
        assertTrue(count > 0);
    @Test
    void testReplace_withValidTargetAndReplacement_returnsReplacedString() {
        // GIVEN
        String input = "The quick brown fox";
        String target = "quick";
        String replacement = "slow";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("The slow brown fox", result);
    }

    @Test
    void testReplace_withTargetNotFound_returnsOriginalString() {
        // GIVEN
        String input = "The quick brown fox";
        String target = "cat";
        String replacement = "dog";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("The quick brown fox", result);
    }

    @Test
    void testRemoveVowels_withVowels_returnsStringWithoutVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginalString() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_returnsStringWithoutConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result);
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginalString() {
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
        String input = "cat dog cat bird cat";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "dog bird fish";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withKeywordCaseInsensitive_returnsCorrectCount() {
        // GIVEN
        String input = "Cat dog caT CAT";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldString() {
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
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
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
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}