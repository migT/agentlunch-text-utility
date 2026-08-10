package com.example.textapi.service;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
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
    void testReverse_withNormalString_returnsReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("321cba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withMixedCaseString_returnsUppercaseString() {
        // GIVEN
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABC123", result);
    }

    @Test
    void testStats_withNormalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(27, stats.get("length"));
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
    void testStats_withNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsListOfRepeatedWords() {
        // GIVEN
        String input = "Test test TEST example example test";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertEquals(2, repeatedWords.size());
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "unique words only";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withNullOrEmptyInput_returnsEmptyList() {
        // GIVEN
        String inputNull = null;
        String inputEmpty = "";

        // WHEN
        List<String> resultNull = textService.getRepeatedWords(inputNull);
        List<String> resultEmpty = textService.getRepeatedWords(inputEmpty);

        // THEN
        assertNotNull(resultNull);
        assertTrue(resultNull.isEmpty());
        assertNotNull(resultEmpty);
        assertTrue(resultEmpty.isEmpty());
    }

    @Test
    void testReplace_replacesTargetWithReplacement() {
        // GIVEN
        String input = "hello world hello";
        String target = "hello";
        String replacement = "hi";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hi world hi", result);
    }

    @Test
    void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

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
    void testCountOccurrence_countsKeywordOccurrencesCaseInsensitive() {
        // GIVEN
        String input = "Hello hello HeLLo world hello";
        String keyword = "hello";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "This is a test string";
        String keyword = "absent";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
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
    void testConvertJsonToYaml_withValidJson_returnsYamlString() {
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
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXmlString() {
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
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String xml = textService.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}