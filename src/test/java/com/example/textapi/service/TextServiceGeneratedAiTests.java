package com.example.textapi.service;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static com.example.textapi.service.TextService.HELLO_WORLD;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_shouldReturnReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("321cba", result);
    }

    @Test
    void testReverse_withEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withMixedCaseString_shouldReturnUppercaseString() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withNormalString_shouldReturnCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(17, stats.get("length"));
        assertEquals(3, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(5, stats.get("VowelCount"));
        assertEquals(7, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
    }

    @Test
    void testStats_withEmptyString_shouldReturnZeroStats() {
        // GIVEN
        String input = "";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on \s+ returns array length 1 for empty string
        assertEquals(1, stats.get("lineCount")); // split on \n returns array length 1 for empty string
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testStats_withNullInput_shouldReturnZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on \s+ throws NPE if input is null, but stats calls getLength first
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_shouldReturnList() {
        // GIVEN
        String input = "Test test TEST example example";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertEquals(2, repeatedWords.size());
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_shouldReturnEmptyList() {
        // GIVEN
        String input = "unique words only";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_shouldReturnEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test    @Test
    void testGetRepeatedWords_withNullInput_shouldReturnEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetConsonantCount_withMixedString_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello World! 123";

        // WHEN
        Integer count = textService.getConsonantCount(input);

        // THEN
        // consonants: H, l, l, W, r, l, d = 7
        assertEquals(7, count);
    }

    @Test
    void testGetConsonantCount_withEmptyString_shouldReturnZero() {
        // GIVEN
        String input = "";

        // WHEN
        Integer count = textService.getConsonantCount(input);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void testGetVowelCount_withMixedString_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello World! 123";

        // WHEN
        Integer count = textService.getVowelCount(input);

        // THEN
        // vowels: e, o, o = 3
        assertEquals(3, count);
    }

    @Test
    void testGetVowelCount_withEmptyString_shouldReturnZero() {
        // GIVEN
        String input = "";

        // WHEN
        Integer count = textService.getVowelCount(input);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void testReplace_withExistingTarget_shouldReplaceAllOccurrences() {
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
    void testReplace_withNonExistingTarget_shouldReturnOriginalString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "qux";
        String replacement = "baz";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals(input, result);
    }

    @Test
    void testRemoveVowels_withMixedString_shouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveVowels_withEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void testRemoveConsonants_withMixedString_shouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void testRemoveConsonants_withEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_shouldReturnCorrectCount() {
        // GIVEN
        String input = "foo bar Foo foo";
        String keyword = "foo";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_shouldReturnZero() {
        // GIVEN
        String input = "foo bar baz";
        String keyword = "qux";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withEmptyInput_shouldReturnZero() {
        // GIVEN
        String input = "";
        String keyword = "foo";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void testHelloworld_shouldReturnHelloWorldString() {
        // GIVEN no setup needed

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals(HELLO_WORLD, result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}