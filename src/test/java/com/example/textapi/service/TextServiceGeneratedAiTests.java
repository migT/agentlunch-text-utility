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
    void reverse_givenNormalString_shouldReturnReversedString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("olleh", result);
    }

    @Test
    void reverse_givenEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_givenMixedCaseString_shouldReturnUppercaseString() {
        // GIVEN
        String input = "HeLLo";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void uppercase_givenEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void stats_givenNormalString_shouldReturnCorrectStats() {
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
    void stats_givenNullInput_shouldReturnZeroStats() {
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
    void getRepeatedWords_givenStringWithRepeatedWords_shouldReturnListOfRepeatedWords() {
        // GIVEN
        String input = "Test test TEST example example";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
    }

    @Test
    void getRepeatedWords_givenStringWithNoRepeatedWords_shouldReturnEmptyList() {
        // GIVEN
        String input = "unique words only";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertNotNull(repeatedWords);
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenNullOrEmptyInput_shouldReturnEmptyList() {
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
    void replace_givenString_shouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "Hello world";
        String target = "world";
        String replacement = "Java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void replace_givenStringWithNoTarget_shouldReturnOriginalString() {
        // GIVEN
        String input = "Hello world";
        String target = "Python";
        String replacement = "Java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals(input, result);
    }

    @Test
    void removeVowels_givenString_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeVowels_givenEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void removeConsonants_givenString_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void removeConsonants_givenEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void countOccurrence_givenStringAndKeyword_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Java java JAVA jAvA";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void countOccurrence_givenStringWithoutKeyword_shouldReturnZero() {
        // GIVEN
        String input = "Hello world";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void helloworld_shouldReturnHelloWorldString() {
        // GIVEN no special setup

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.length() > 0);
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_shouldReturnXmlString() {
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
    void convertJsonToXml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN
        String xml = textService.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}