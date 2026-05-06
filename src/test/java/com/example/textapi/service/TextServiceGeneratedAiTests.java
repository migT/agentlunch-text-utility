package com.example.textapi.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
    void reverse_givenString_returnsReversedString() {
        // GIVEN
        String input = "abcde";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("edcba", result);
    }

    @Test
    void reverse_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_givenLowercaseString_returnsUppercaseString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void uppercase_givenMixedCaseString_returnsUppercaseString() {
        // GIVEN
        String input = "HeLLo";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void stats_givenNormalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(29, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("vowelCount"));
        assertEquals(13, stats.get("consonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("repeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
        assertFalse(repeatedWords.contains("again : 1"));
    }

    @Test
    void stats_givenNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(0, stats.get("wordCount"));
        assertEquals(0, stats.get("lineCount"));
        assertEquals(0, stats.get("vowelCount"));
        assertEquals(0, stats.get("consonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("repeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_returnsListOfRepeatedWords() {
        // GIVEN
        String input = "Test test TEST example example test";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertEquals(2, repeatedWords.size());
    }

    @Test
    void getRepeatedWords_givenEmptyString_returnsEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenNull_returnsEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void replace_givenString_replacesTargetWithReplacement() {
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
    void removeVowels_givenString_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_givenString_removesAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_givenStringAndKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Hello world, hello Universe. Hello everyone.";
        String keyword = "hello";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void countOccurrence_givenStringAndKeywordNotPresent_returnsZero() {
        // GIVEN
        String input = "Hello world";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void helloworld_returnsHelloWorldString() {
        // GIVEN no input

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: John") || yaml.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}
