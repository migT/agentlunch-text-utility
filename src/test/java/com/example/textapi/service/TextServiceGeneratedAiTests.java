package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
    }

    @Test
    public void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcde";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("edcba", result);
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
    public void testUppercase_withMixedCase_returnsUppercase() {
        // GIVEN
        String input = "AbCdEf";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABCDEF", result);
    }

    @Test
    public void testStats_withNormalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(29, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("VowelCount"));
        assertEquals(11, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
        assertFalse(repeatedWords.contains("again : 1"));
    }

    @Test
    public void testStats_withNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on null would throw, but method handles null length only
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withRepeatedWords_returnsCorrectList() {
        // GIVEN
        String input = "Test test TEST example example unique";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertFalse(repeatedWords.contains("unique : 1"));
    }

    @Test
    public void testGetRepeatedWords_withEmptyOrNullInput_returnsEmptyList() {
        // GIVEN
        String input1 = "";
        String input2 = null;

        // WHEN
        List<String> result1 = textService.getRepeatedWords(input1);
        List<String> result2 = textService.getRepeatedWords(input2);

        // THEN
        assertNotNull(result1);
        assertTrue(result1.isEmpty());
        assertNotNull(result2);
        assertTrue(result2.isEmpty());
    }

    @Test
    public void testGetConsonantCount_withMixedInput_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World!";

        // WHEN
        Integer count = textService.getConsonantCount(input);

        // THEN
        assertEquals(Integer.valueOf(7), count);
    }

    @Test
    public void testGetVowelCount_withMixedInput_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World!";

        // WHEN
        Integer count = textService.getVowelCount(input);

        // THEN
        assertEquals(Integer.valueOf(3), count);
    }

    @Test
    public void testReplace_withTargetPresent_replacesAllOccurrences() {
        // GIVEN
        String    @Test
    public void testRemoveVowels_withMixedInput_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    public void testRemoveConsonants_withMixedInput_removesAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    public void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana Apple apple BANANA apple";
        String keyword = "apple";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    public void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "this is a test string";
        String keyword = "absent";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    public void testHelloworld_returnsHelloWorldString() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}