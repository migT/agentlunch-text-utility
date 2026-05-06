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
    void reverse_givenNonEmptyString_returnsReversedString() {
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
    void uppercase_givenMixedCaseString_returnsUppercaseString() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO WORLD", result);
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
        assertNotNull(stats);
        assertEquals(29, stats.get("length"));
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
    void stats_givenEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(0, stats.get("length"));
        assertEquals(0, stats.get("wordCount"));
        assertEquals(0, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenTextWithRepeatedWords_returnsCorrectList() {
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
    void getRepeatedWords_givenEmptyString_returnsEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenNull_returnsEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void replace_givenString_replacesTargetWithReplacement() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("baz bar baz", result);
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
    void countOccurrence_givenStringAndKeyword_countsOccurrencesCorrectly() {
        // GIVEN
        String input = "foo bar Foo foofoo foo";
        String keyword = "foo";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void helloworld_returnsHelloWorldString() {
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
        assertNotNull(yaml);
        assertTrue(yaml.contains("key:"));
        assertTrue(yaml.contains("value"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void convertJsonToXml_givenValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<key>"));
        assertTrue(xml.contains("value"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
