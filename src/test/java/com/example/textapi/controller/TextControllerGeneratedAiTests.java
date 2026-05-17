package com.example.textapi.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        // GIVEN the controller is initialized

        // WHEN helloWorld endpoint is called
        String result = textController.helloWorld();

        // THEN the result should be the expected hello world string
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN an input string
        String input = "abcde";

        // WHEN reverse endpoint is called
        String result = textController.reverse(input);

        // THEN the result should be the reversed string
        assertEquals("edcba", result);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN an input string
        String input = "abcde";

        // WHEN uppercase endpoint is called
        String result = textController.uppercase(input);

        // THEN the result should be the uppercase string
        assertEquals("ABCDE", result);
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN an input string with multiple words and lines
        String input = "Hello world\nHello again world";

        // WHEN stats endpoint is called
        Map<String, Object> stats = textController.stats(input);

        // THEN the map should contain correct statistics
        assertNotNull(stats);
        assertEquals(input.length(), stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(9, stats.get("VowelCount"));
        assertEquals(6, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
        assertTrue(repeatedWords.contains("world : 2"));
    }

    @Test
    void replace_ShouldReturnStringWithReplacements() {
        // GIVEN an input string and target and replacement strings
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN replace endpoint is called
        String result = textController.replace(target, replacement, input);

        // THEN the result should have target replaced by replacement
        assertEquals("baz bar baz", result);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN an input string containing vowels
        String input = "Hello World";

        // WHEN removeVowels endpoint is called
        String result = textController.removeVowels(input);

        // THEN the result should not contain vowels
        assertFalse(result.toLowerCase().matches(".*[aeiou].*"));
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN an input string containing consonants
        String input = "Hello World";

        // WHEN removeConsonants endpoint is called
        String result = textController.removeConsonants(input);

        // THEN the result should not contain consonants
        assertFalse(result.toLowerCase().matches(".*[bcdfghjklmnpqrstvwxyz].*"));
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN an input string and keyword to count
        String input = "foo bar foo Foo";
        String keyword = "foo";

        // WHEN countOccurrence endpoint is called
        int count = textController.countOccurrence(keyword, input);

        // THEN the count should be case-insensitive and correct
        assertEquals(3, count);
    }

    @Test
    void jsonToYaml_ShouldConvertValidJsonToYaml() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN jsonToYaml endpoint is called
        String yaml = textController.jsonToYaml(json);

        // THEN the result should contain YAML representation of JSON
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void jsonToYaml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN jsonToYaml endpoint is called
        String yaml = textController.jsonToYaml(invalidJson);

        // THEN the result should contain error message
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void jsonToXml_ShouldConvertValidJsonToXml() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN jsonToXml endpoint is called
        String xml = textController.jsonToXml(json);

        // THEN the result should contain XML representation of JSON
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void jsonToXml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{name:\"John\",age:30}";

        // WHEN jsonToXml endpoint is called
        String xml = textController.jsonToXml(invalidJson);

        // THEN the result should contain error message
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}