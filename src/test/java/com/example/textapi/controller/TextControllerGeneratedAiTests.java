package com.example.textapi.controller;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN a new instance of TextService and TextController before each test
        textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN a TextController with a real TextService

        // WHEN helloWorld() is called
        String result = textController.helloWorld();

        // THEN it returns "Hello, World!"
        assertEquals("Hello, World!", result);
    }

    @Test
    void testReverse() {
        // GIVEN an input string
        String input = "abcde";

        // WHEN reverse() is called
        String result = textController.reverse(input);

        // THEN the result is the reversed string
        assertEquals("edcba", result);
    }

    @Test
    void testUppercase() {
        // GIVEN an input string with mixed case
        String input = "AbC123";

        // WHEN uppercase() is called
        String result = textController.uppercase(input);

        // THEN the result is uppercase
        assertEquals("ABC123", result);
    }

    @Test
    void testStats() {
        // GIVEN an input string with multiple lines and words
        String input = "Hello world\nHello again";

        // WHEN stats() is called
        Map<String, Object> stats = textController.stats(input);

        // THEN the map contains correct statistics
        assertNotNull(stats);
        assertEquals(22, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("VowelCount"));
        assertEquals(10, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
    }

    @Test
    void testReplace() {
        // GIVEN an input string with target and replacement strings
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN replace() is called
        String result = textController.replace(target, replacement, input);

        // THEN all occurrences of target are replaced
        assertEquals("baz bar baz", result);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN an input string with vowels
        String input = "Hello World";

        // WHEN removeVowels() is called
        String result = textController.removeVowels(input);

        // THEN the result contains no vowels
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN an input string with consonants
        String input = "Hello World";

        // WHEN removeConsonants() is called
        String result = textController.removeConsonants(input);

        // THEN the result contains no consonants
        assertEquals("eo o", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN an input string and a keyword
        String input = "foo bar Foo foo";
        String keyword = "foo";

        // WHEN countOccurrence() is called
        int count = textController.countOccurrence(keyword, input);

        // THEN the count matches the number of occurrences ignoring case
        assertEquals(3, count);
    }

    @Test
    void testJsonToYaml_ValidJson() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN jsonToYaml() is called
        String yaml = textController.jsonToYaml(json);

        // THEN the result is a valid YAML representation containing keys and values
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testJsonToYaml_InvalidJson() {
        // GIVEN an invalid JSON string
        String json = "{name:John,age:30}";

        // WHEN jsonToYaml() is called
        String yaml = textController.jsonToYaml(json);

        // THEN the result contains an errormessage about conversion failure
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testJsonToXml_ValidJson() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN jsonToXml() is called
        String xml = textController.jsonToXml(json);

        // THEN the result is a valid XML representation containing keys and values
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testJsonToXml_InvalidJson() {
        // GIVEN an invalid JSON string
        String json = "{name:John,age:30}";

        // WHEN jsonToXml() is called
        String xml = textController.jsonToXml(json);

        // THEN the result contains an error message about conversion failure
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}