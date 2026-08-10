package com.example.textapi.service;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
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
    public void testReverse_withNormalString_shouldReturnReversedString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("olleh", result);
    }

    @Test
    public void testReverse_withEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    public void testUppercase_withLowercaseString_shouldReturnUppercaseString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    public void testUppercase_withMixedCaseString_shouldReturnUppercaseString() {
        // GIVEN
        String input = "HeLLo";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    public void testStats_withNormalString_shouldReturnCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(26, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("VowelCount"));
        assertEquals(12, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
        assertFalse(repeatedWords.contains("again : 1"));
    }

    @Test
    public void testStats_withNullInput_shouldReturnZeroStats() {
        // GIVEN
        String input = null;

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
    public void testGetRepeatedWords_withRepeatedWords_shouldReturnList() {
        // GIVEN
        String input = "apple apple banana apple banana orange";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertEquals(2, repeatedWords.size());
        assertTrue(repeatedWords.contains("apple : 3"));
        assertTrue(repeatedWords.contains("banana : 2"));
    }

    @Test
    public void testGetRepeatedWords_withNoRepeatedWords_shouldReturnEmptyList() {
        // GIVEN
        String input = "one two three";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withNullOrEmptyInput_shouldReturnEmptyList() {
        // GIVEN
        String input1 = null;
        String input2 = "";

        // WHEN
        List<String> result1 = textService.getRepeatedWords(input1);
        List<String> result2 = textService.getRepeatedWords(input2);

        // THEN
        assertTrue(result1.isEmpty());
        assertTrue(result2.isEmpty());
    }

    @Test
    public void testReplace_shouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hello java", result);
       @Test
    public void testRemoveVowels_shouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    public void testRemoveConsonants_shouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    public void testCountOccurrence_withMultipleOccurrences_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Java is great. I love Java. Java is popular.";
        String keyword = "Java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }

    @Test
    public void testCountOccurrence_withNoOccurrences_shouldReturnZero() {
        // GIVEN
        String input = "This is a test string.";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    public void testHelloworld_shouldReturnHelloWorldString() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{name:\"John\",age:30}"; // invalid JSON

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{name:\"John\",age:30}"; // invalid JSON

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}