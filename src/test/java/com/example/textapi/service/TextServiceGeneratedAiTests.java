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
    void reverse_givenNormalString_whenReverse_thenReturnsReversedString() {
        // GIVEN
        String input = "abcde";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("edcba", result);
    }

    @Test
    void reverse_givenEmptyString_whenReverse_thenReturnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_givenMixedCaseString_whenUppercase_thenReturnsUppercaseString() {
        // GIVEN
        String input = "AbCdEf";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABCDEF", result);
    }

    @Test
    void uppercase_givenEmptyString_whenUppercase_thenReturnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void stats_givenTypicalString_whenStats_thenReturnsCorrectStats() {
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
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("world")));
    }

    @Test
    void stats_givenNullInput_whenStats_thenReturnsZeroLengthAndEmptyRepeatedWords() {
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
        assertTrue(((List<?>) stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_whenGetRepeatedWords_thenReturnsListWithCounts() {
        // GIVEN
        String input = "test Test TEST example example unique";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertFalse(repeatedWords.stream().anyMatch(s -> s.startsWith("unique")));
    }

    @Test
    void getRepeatedWords_givenEmptyString_whenGetRepeatedWords_thenReturnsEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenNullInput_whenGetRepeatedWords_thenReturnsEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void removeVowels_givenString_whenRemoveVowels_thenReturnsStringWithoutVowels() {
        // GIVEN
        String input = "hello world";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("hll wrld", result);
    }

    @Test
    void removeConsonants_givenString_whenRemoveConsonants_thenReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "hello world";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void replace_givenStringAndTarget_whenReplace_thenReturnsReplacedString() {
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
    void countOccurrence_givenStringAndKeyword_whenCountOccurrence_thenReturnsCorrectCount() {
        // GIVEN
        String input = "Java java JaVa python java";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void countOccurrence_givenStringWithoutKeyword_whenCountOccurrence_thenReturnsZero() {
        // GIVEN
        String input = "Java python C++";
        String keyword = "ruby";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void helloworld_whenCalled_thenReturnsHelloWorldString() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_whenConvertJsonToYaml_thenReturnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name"));
        assertTrue(yaml.contains("John"));
        assertTrue(yaml.contains("age"));
        assertTrue(yaml.contains("30"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_whenConvertJsonToXml_thenReturnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}