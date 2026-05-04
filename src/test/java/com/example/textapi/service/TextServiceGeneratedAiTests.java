package com.example.textapi.service;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABC123", result);
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
    void stats_givenTypicalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(29, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.get("VowelCount") instanceof Integer);
        assertTrue(stats.get("ConsonantCount") instanceof Integer);
        assertTrue(stats.get("RepeatedWords") instanceof List);
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    void stats_givenNullInput_returnsZeroAndEmptyList() {
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
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_returnsListOfRepeatedWords() {
        // GIVEN
        String input = "Test test TEST example example example";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 3"));
        assertEquals(2, repeatedWords.size());
    }

    @Test
    void getRepeatedWords_givenEmptyOrNullInput_returnsEmptyList() {
        // GIVEN
        String inputEmpty = "";
        String inputNull = null;

        // WHEN
        List<String> resultEmpty = textService.getRepeatedWords(inputEmpty);
        List<String> resultNull = textService.getRepeatedWords(inputNull);

        // THEN
        assertTrue(resultEmpty.isEmpty());
        assertTrue(resultNull.isEmpty());
    }

    @Test
    void replace_givenInput_replacesTargetWithReplacement() {
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
        String input = "Java java JAVA jAvA";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void countOccurrence_givenNoOccurrences_returnsZero() {
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
        // GIVEN

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
        assertEquals("key: value\n", yaml);
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
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
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}