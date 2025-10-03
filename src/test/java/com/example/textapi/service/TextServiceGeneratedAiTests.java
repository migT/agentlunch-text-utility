package com.example.textapi.service;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
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
        String input = "Hello";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("olleH", result);
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
    void testStats_withSimpleText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(10, stats.get("ConsonantCount"));
        assertTrue(stats.get("RepeatedWords") instanceof List);
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
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
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "cat dog cat bird dog cat";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.contains("cat : 3"));
        assertTrue(repeated.contains("dog : 2"));
        assertFalse(repeated.contains("bird : 1"));
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana cherry";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withNullInput_returnsEmptyList() {
        // GIVEN
        String input = null;
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testReplace_withValidInputs_returnsReplacedString() {
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
    void testReplace_withNoMatch_returnsOriginalString() {
        // GIVEN
        String input = "Hello world";
        String target = "bye";
        String replacement = "hi";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("Hello world", result);
    }

    @Test
    void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl", result);
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
    void testRemoveConsonants_removesAllConsonants() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu", result);
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
        String input = "apple banana cherry";
        String keyword = "dog";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Cat cat CAT cAt";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(4, count);
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
        assertTrue(yaml.contains("name: \"John\""));
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