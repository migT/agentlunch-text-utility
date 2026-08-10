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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_givenString_returnsReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("321cba", result);
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
    void uppercase_givenString_returnsUppercaseString() {
        // GIVEN
        String input = "abcDef";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABCDEF", result);
    }

    @Test
    void uppercase_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void stats_givenNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(input.length(), stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.get("VowelCount") instanceof Integer);
        assertTrue(stats.get("ConsonantCount") instanceof Integer);
        assertTrue(stats.get("RepeatedWords") instanceof List);
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("world")));
    }

    @Test
    void stats_givenNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on null not called, but method returns 1 because split on null is not done, so no exception
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        assertTrue(((List<?>) stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    void getRepeatedWords_givenTextWithRepeatedWords_returnsListOfRepeatedWords() {
        // GIVEN
        String input = "test Test TEST example example";

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
    void replace_givenInput_replacesTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hello there", result);
    }

    @Test
    void removeVowels_givenString_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        //    @Test
    void removeConsonants_givenString_removesAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_givenInput_returnsCorrectCount() {
        // GIVEN
        String input = "Test test TEST testing tested test";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void countOccurrence_givenNoOccurrences_returnsZero() {
        // GIVEN
        String input = "Hello world";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void helloworld_returnsHelloWorldString() {
        // GIVEN - no setup needed

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("key: value"));
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
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<key>value</key>"));
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