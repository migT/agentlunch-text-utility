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
        // Reset state before each test
        textService = new TextService();
    }

    @Test
    void testReverse_regularString() {
        // GIVEN
        String input = "abcde";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("edcba", result);
    }

    @Test
    void testReverse_null_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.reverse(input));
    }

    @Test
    void testUppercase_andEmpty() {
        // GIVEN
        String input = "Hello";
        String empty = "";
        // WHEN
        String result = textService.uppercase(input);
        String emptyResult = textService.uppercase(empty);
        // THEN
        assertEquals("HELLO", result);
        assertEquals("", emptyResult);
    }

    @Test
    void testUppercase_null_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.uppercase(input));
    }

    @Test
    void testReplace_replacesAllOccurrences() {
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
    void testReplace_nullInput_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.replace(input, "a", "b"));
    }

    @Test
    void testGetRepeatedWords_nullReturnsEmptyList() {
        // GIVEN
        String input = null;
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testStats_basic() {
        // GIVEN
        String input = "Hello world\nHello";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertNotNull(stats);
        assertEquals(Integer.valueOf(17), stats.get("length"));
        assertEquals(Integer.valueOf(3), stats.get("wordCount"));
        assertEquals(Integer.valueOf(2), stats.get("lineCount"));
        assertEquals(Integer.valueOf(5), stats.get("VowelCount"));
        assertEquals(Integer.valueOf(10), stats.get("ConsonantCount"));
        @SuppressWarnings("unchecked")
        List<String> repeated = (List<String>) stats.get("RepeatedWords");
        assertNotNull(repeated);
        assertEquals(1, repeated.size());
        assertEquals("hello : 2", repeated.get(0));
    }

    @Test
    void testStats_null_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.stats(input));
    }

    @Test
    void testRemoveVowels_removesBothCases() {
        // GIVEN
        String input = "abcdE";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("bcd", result);
    }

    @Test
    void testRemoveVowels_null_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.removeVowels(input));
    }

    @Test
    void testRemoveConsonants_leavesVowelsDigitsAndPunctuation() {
        // GIVEN
        String input = "abcdE123!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aE123!", result);
    }

    @Test
    void testRemoveConsonants_null_throwsNpe() {
        // GIVEN
        String input = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.removeConsonants(input));
    }

    @Test
    void testCountOccurrence_caseInsensitiveAndWordBoundaries() {
        // GIVEN
        String input = "Hello hello, helloworld hello!";
        String keyword = "hello";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_nullInput_throwsNpe() {
        // GIVEN
        String input = null;
        String keyword = "hello";
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.countOccurrence(input, keyword));
    }

    @Test
    void testCountOccurrence_keywordNull_throwsNpe() {
        // GIVEN
        String input = "hello world";
        String keyword = null;
        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.countOccurrence(input, keyword));
    }

    @Test
    void testHelloworld_constant() {
        // GIVEN (no setup required)
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_andXml_withValidJson() {
        // GIVEN
        String json = "{\"a\":1,\"b\":\"text\"}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("a:") && yaml.contains("1"));
        assertTrue(yaml.contains("b:") && yaml.contains("text"));
        assertNotNull(xml);
        assertTrue(xml.toLowerCase().contains("<a>1</a>") || xml.contains("a"));
        assertTrue(xml.contains("b") && xml.contains("text"));
    }

    @Test
    void testConvertJsonToYaml_andXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "not a json";
        // WHEN
        String yaml = textService.convertJsonToYaml(invalidJson);
        String xml = textService.convertJsonToXml(invalidJson);
        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON"));
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON"));
    }
}
