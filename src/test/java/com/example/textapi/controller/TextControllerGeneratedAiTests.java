package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Map;
import java.util.HashMap;

public class TextControllerGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
    }

    @Test
    public void testHelloWorld() {
        // GIVEN: No preconditions needed

        // WHEN: Call the helloworld method
        String result = textService.helloworld();

        // THEN: Verify the expected output
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testReverse() {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the reverse method with the input
        String result = textService.reverse(input);

        // THEN: Verify the reversed output
        assertEquals("!dlroW ,olleH", result);
    }

    @Test
    public void testUppercase() {
        // GIVEN: A sample input string
        String input = "hello, world!";

        // WHEN: Call the uppercase method with the input
        String result = textService.uppercase(input);

        // THEN: Verify the uppercase output
        assertEquals("HELLO, WORLD!", result);
    }

    @Test
    public void testStats() {
        // GIVEN: A sample input string
        String input = "Hello, World! This is a test.";

        // WHEN: Call the stats method with the input
        Map<String, Object> result = textService.stats(input);

        // THEN: Verify the expected output
        assertNotNull(result);
        assertEquals(41, ((Integer) result.get("length")));
        assertEquals(6, ((Integer) result.get("wordCount")));
        assertEquals(1, ((Integer) result.get("lineCount")));
    }

    @Test
    public void testReplace() {
        // GIVEN: Sample input strings and a target/replacement pair
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";

        // WHEN: Call the replace method with the input and target/replacement pair
        String result = textService.replace(input, target, replacement);

        // THEN: Verify the replaced output
        assertEquals("Hello, Earth!", result);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the removeVowels method with the input
        String result = textService.removeVowels(input);

        // THEN: Verify the output without vowels
        assertEquals("Hll, Wrld!", result);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the removeConsonants method with the input
        String result = textService.removeConsonants(input);

        // THEN: Verify the output without consonants
        assertEquals("aeioo, !", result);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN: Sample input strings and a keyword
        String input = "Hello, World! This is a test. Hello again.";
        String keyword = "Hello";

        // WHEN: Call the countOccurrence method with the input and keyword
        int result = textService.countOccurrence(input, keyword);

        // THEN: Verify the expected output
        assertEquals(2, result);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN: A sample JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the convertJsonToYaml method with the JSON string
        String result = textService.convertJsonToYaml(json);

        // THEN: Verify the YAML output
        assertEquals("---\nkey: value\n", result);
    }

    @Test
    public void testJsonToXml() {
        // GIVEN: A sample JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the convertJsonToXml method with the JSON string
        String result = textService.convertJsonToXml(json);

        // THEN: Verify the XML output
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><key>value</key></root>", result);
    }
}
