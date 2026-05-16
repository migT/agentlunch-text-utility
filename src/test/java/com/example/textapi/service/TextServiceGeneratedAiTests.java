package com.example.textapi.service;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        // GIVEN: Create a new instance before each test to reset state
        textService = new TextService();
    }

    @Test
    public void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    public void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    public void testUppercase_withLowercaseString_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    public void testStats_withTypicalInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        assertTrue(((List<String>) stats.get("RepeatedWords")).size() > 0);
    }

    @Test
    public void testStats_withNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(0, stats.get("wordCount"));
        assertEquals(0, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        assertTrue(((List<String>) stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.contains("apple : 3"));
        assertTrue(repeated.contains("banana : 2"));
    }

    @Test
    public void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    public void testReplace_withValidTarget_replacesTarget() {
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
    public void testReplace_withTargetNotPresent_returnsOriginal() {
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
    public void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl", result);
    }

    @Test
    public void testRemoveConsonants_removesAllConsonants() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu", result);
    }

    @Test
    public void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "cat dog cat bird cat";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    public void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "cat dog cat bird cat";
        String keyword = "fish";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    public void testHelloworld_returnsHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}