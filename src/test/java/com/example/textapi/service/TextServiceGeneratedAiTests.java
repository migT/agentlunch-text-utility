package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
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
    void reverse_givenNormalString_returnsReversedString() {
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
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABC123", result);
    }

    @Test
    void stats_givenNormalString_returnsCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(input.length(), stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue((Integer)stats.get("VowelCount") > 0);
        assertTrue((Integer)stats.get("ConsonantCount") > 0);
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    void stats_givenNullInput_returnsZeroAndEmptyResults() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(0, stats.get("length"));
        assertEquals(0, stats.get("wordCount"));
        assertEquals(0, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_returnsListOfRepeatedWords() {
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
    void getRepeatedWords_givenEmptyOrNullInput_returnsEmptyList() {
        // GIVEN
        String emptyInput = "";
        String nullInput = null;

        // WHEN
        List<String> emptyResult = textService.getRepeatedWords(emptyInput);
        List<String> nullResult = textService.getRepeatedWords(nullInput);

        // THEN
        assertNotNull(emptyResult);
        assertTrue(emptyResult.isEmpty());
        assertNotNull(nullResult);
        assertTrue(nullResult.isEmpty());
    }

    @Test
    void replace_givenInputReplacesTargetWithReplacement() {
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
    void countOccurrence_givenStringAndKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "foo Foo foo bar foofoo";
        String keyword = "foo";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
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
        assertNotNull(yaml);
        assertTrue(yaml.contains("name"));
        assertTrue(yaml.contains("age"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_returnsXmlString() {
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
    void convertJsonToXml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String xml = textService.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}