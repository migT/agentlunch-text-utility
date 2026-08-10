package com.example.textapi.service;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        // GIVEN: Reset state before each test
        textService = new TextService();
    }

    @Test
    public void testReverse_withNormalString_returnsReversedString() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertEquals("dlroW olleH", result);
    }

    @Test
    public void testReverse_withEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertEquals("", result);
    }

    @Test
    public void testUppercase_withLowercaseString_returnsUppercaseString() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertEquals("HELLO WORLD", result);
    }

    @Test
    public void testUppercase_withMixedCaseString_returnsUppercaseString() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertEquals("HELLO WORLD", result);
    }

    @Test
    public void testStats_withNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertEquals(22, stats.get("length"));
        Assertions.assertEquals(4, stats.get("wordCount"));
        Assertions.assertEquals(2, stats.get("lineCount"));
        Assertions.assertEquals(8, stats.get("VowelCount"));
        Assertions.assertEquals(10, stats.get("ConsonantCount"));
        Assertions.assertTrue(((List<String>) stats.get("RepeatedWords")).contains("hello : 2"));
    }

    @Test
    public void testStats_withEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertEquals(0, stats.get("length"));
        Assertions.assertEquals(1, stats.get("wordCount"));
        Assertions.assertEquals(1, stats.get("lineCount"));
        Assertions.assertEquals(0, stats.get("VowelCount"));
        Assertions.assertEquals(0, stats.get("ConsonantCount"));
        Assertions.assertTrue(((List<String>) stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withRepeatedWords_returnsCorrectList() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(repeatedWords.contains("apple : 3"));
        Assertions.assertTrue(repeatedWords.contains("banana : 2"));
        Assertions.assertFalse(repeatedWords.contains("orange : 1"));
    }

    @Test
    public void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(repeatedWords.isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withEmptyString_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(repeatedWords.isEmpty());
    }

    @Test
    public void testReplace_withValidTarget_replacesTargetWithReplacement() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertEquals("Hello Java", result);
    }

    @Test
    public void testReplace_withTargetNotPresent_returnsOriginalString() {
        // GIVEN
        String input = "Hello World";
        String target = "Python";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertEquals("Hello World", result);
    }

    @Test
    public void testRemoveVowels_withV@Test
    public void testRemoveVowels_withVowelsPresent_removesAllVowels() {
        // GIVEN
        String input = "Beautiful Day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        Assertions.assertEquals("Btfl Dy", result);
    }

    @Test
    public void testRemoveVowels_withNoVowels_returnsOriginalString() {
        // GIVEN
        String input = "Rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        Assertions.assertEquals("Rhythm", result);
    }

    @Test
    public void testRemoveConsonants_withConsonantsPresent_removesAllConsonants() {
        // GIVEN
        String input = "Beautiful Day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        Assertions.assertEquals("eauiua", result);
    }

    @Test
    public void testRemoveConsonants_withNoConsonants_returnsOriginalString() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        Assertions.assertEquals("aeiou", result);
    }

    @Test
    public void testCountOccurrence_withMultipleOccurrences_returnsCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        Assertions.assertEquals(3, count);
    }

    @Test
    public void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange grape";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        Assertions.assertEquals(0, count);
    }

    @Test
    public void testHelloworld_returnsHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        Assertions.assertEquals("Hello, World!", result);
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        Assertions.assertTrue(yaml.contains("name: \"John\""));
        Assertions.assertTrue(yaml.contains("age: 30"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        Assertions.assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        Assertions.assertTrue(xml.contains("<name>John</name>"));
        Assertions.assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        Assertions.assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
