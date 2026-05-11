package com.example.textapi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void reverse_givenNormalString_whenReverse_thenReturnsReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("321cba", result);
    }

    @Test
    void reverse_givenEmptyString_whenReverse_thenReturnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_givenMixedCaseString_whenUppercase_thenReturnsUppercaseString() {
        // GIVEN
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABC123", result);
    }

    @Test
    void stats_givenNormalString_whenStats_thenReturnsCorrectStats() {
        // GIVEN
        String input = "Hello hello world\nThis is a test.\nTest test test.";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(input.length(), stats.get("length"));
        assertEquals(10, stats.get("wordCount"));
        assertEquals(3, stats.get("lineCount"));
        assertTrue((Integer) stats.get("VowelCount") > 0);
        assertTrue((Integer) stats.get("ConsonantCount") > 0);
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("test : 4"));
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_whenGetRepeatedWords_thenReturnsCorrectList() {
        // GIVEN
        String input = "Apple apple banana Banana banana orange";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("apple : 2"));
        assertTrue(repeatedWords.contains("banana : 3"));
        assertFalse(repeatedWords.contains("orange : 1"));
    }

    @Test
    void getRepeatedWords_givenEmptyString_whenGetRepeatedWords_thenReturnsEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void consonantCount_and_vowelCount_givenString_whenCalled_thenReturnsCorrectCounts() {
        // GIVEN
        String input = "Hello World!";

        // WHEN
        int consonantCount = input.length() - textService.removeConsonants(input).length();
        int vowelCount = input.length() - textService.removeVowels(input).length();

        // THEN
        assertEquals(7, consonantCount);
        assertEquals(3, vowelCount);
    }

    @Test
    void replace_givenStringAndTargetAndReplacement_whenReplace_thenReturnsReplacedString() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void removeVowels_givenString_whenRemoveVowels_thenReturnsStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_givenString_whenRemoveConsonants_thenReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_givenStringAndKeyword_whenCountOccurrence_thenReturnsCorrectCount() {
        // GIVEN
        String input = "Java java JAVA JavaScript java.";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void helloworld_whenCalled_thenReturnsHelloWorld() {
        // GIVEN no input

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_whenConvertJsonToYaml_thenReturnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_whenConvertJsonToXml_thenReturnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void stats_givenNullInput_whenStats_thenThrowsNullPointerException() {
        // GIVEN
        String input = null;

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textService.stats(input));
    }
}
