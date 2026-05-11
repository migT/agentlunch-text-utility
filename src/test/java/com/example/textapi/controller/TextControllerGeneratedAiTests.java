package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextControllerGeneratedAiTests {

    private TextController textController;
    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN a new instance of TextService and TextController before each test
        textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN the TextController with TextService

        // WHEN calling helloWorld endpoint
        String result = textController.helloWorld();

        // THEN the result should be "Hello, World!"
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN an input string
        String input = "abcde";

        // WHEN calling reverse endpoint
        String result = textController.reverse(input);

        // THEN the result should be the reversed string
        assertEquals("edcba", result);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN an input string with mixed case
        String input = "Hello World";

        // WHEN calling uppercase endpoint
        String result = textController.uppercase(input);

        // THEN the result should be all uppercase
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN an input string with multiple lines and repeated words
        String input = "Hello world\nHello again world";

        // WHEN calling stats endpoint
        Map<String, Object> stats = textController.stats(input);

        // THEN the map should contain correct statistics
        assertNotNull(stats);
        assertEquals(input.length(), stats.get("length"));
        assertEquals(5, stats.get("wordCount")); // "Hello", "world", "Hello", "again", "world"
        assertEquals(2, stats.get("lineCount"));
        assertTrue((Integer) stats.get("VowelCount") > 0);
        assertTrue((Integer) stats.get("ConsonantCount") > 0);
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    void replace_ShouldReturnStringWithReplacements() {
        // GIVEN input string and replacement parameters
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN calling replace endpoint
        String result = textController.replace(target, replacement, input);

        // THEN the result should have all occurrences of target replaced
        assertEquals("baz bar baz", result);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN an input string with vowels
        String input = "Hello World";

        // WHEN calling removeVowels endpoint
        String result = textController.removeVowels(input);

        // THEN the result should not contain any vowels
        assertFalse(result.toLowerCase().matches(".*[aeiou].*"));
        assertTrue(result.length() < input.length());
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN an input string with consonants
        String input = "Hello World";

        // WHEN calling removeConsonants endpoint
        String result = textController.removeConsonants(input);

        // THEN the result should not contain any consonants
        assertFalse(result.toLowerCase().matches(".*[bcdfghjklmnpqrstvwxyz].*"));
        assertTrue(result.length() < input.length());
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN an input string and keyword to count
        String input = "foo bar foo Foo foobar";
        String keyword = "foo";

        // WHEN calling countOccurrence endpoint
        int count = textController.countOccurrence(keyword, input);

        // THEN the count should match occurrences of the exact word ignoring case
        assertEquals(3, count);
    }

    @Test
    void jsonToYaml_ShouldConvertValidJsonToYaml() {
        // GIVEN a valid JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN calling jsonToYaml endpoint
        String yaml = textController.jsonToYaml(json);

        // THEN the result should be a YAML representation containing the key and value
        assertNotNull(yaml);
        assertTrue(yaml.contains("key:"));
        assertTrue(yaml.contains("value"));
    }

    @Test
    void jsonToYaml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{key:\"value\"}";

        // WHEN calling jsonToYaml endpoint
        String result = textController.jsonToYaml(invalidJson);

        // THEN the result should contain an error message
        assertNotNull(result);
        assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void jsonToXml_ShouldConvertValidJsonToXml() {
        // GIVEN a valid JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN calling jsonToXml endpoint
        String xml = textController.jsonToXml(json);

        // THEN the result should be an XML representation containing the key and value
        assertNotNull(xml);
        assertTrue(xml.contains("<key>value</key>"));
    }

    @Test
    void jsonToXml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{key:\"value\"}";

        // WHEN calling jsonToXml endpoint
        String result = textController.jsonToXml(invalidJson);

        // THEN the result should contain an error message
        assertNotNull(result);
        assertTrue(result.toLowerCase().contains("error"));
    }
}
