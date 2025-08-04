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
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("321cba", result);
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
    void testUppercase_withMixedCase_returnsUppercase() {
        // GIVEN
        String input = "AbC";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABC", result);
    }

    @Test
    void testStats_withNormalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(27, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("VowelCount"));
        assertEquals(11, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    void testStats_withNullInput_returnsZeroAndEmpty() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on null would throw NPE, but method does not handle null here, so test is to confirm behavior
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "Test test TEST example example unique";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertFalse(repeatedWords.contains("unique : 1"));
    }

    @Test
    void testGetRepeatedWords_withNullOrEmpty_returnsEmptyList() {
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
    void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveConsonants_removesAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "Java java JAVA jAvA";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "Hello World";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldString() {
        // GIVEN no input

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYamlString() {
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
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXmlString() {
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
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}