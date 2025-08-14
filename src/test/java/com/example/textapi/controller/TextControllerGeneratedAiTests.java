package com.example.textapi.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    void helloWorld() {
        // GIVEN: A TextService instance with the "Hello, World!" message.
        // WHEN: The helloWorld() method is called.
        // THEN: The "Hello, World!" message is returned.
        assertEquals("Hello, World!", textController.helloWorld());
    }

    @Test
    void reverse() {
        // GIVEN: A string input.
        // WHEN: The reverse() method is called with the input string.
        // THEN: The reversed string is returned.
        assertEquals("dlroW ,olleH", textController.reverse("Hello, World!"));
    }

    @Test
    void uppercase() {
        // GIVEN: A string input.
        // WHEN: The uppercase() method is called with the input string.
        // THEN: The uppercase version of the string is returned.
        assertEquals("HELLO, WORLD!", textController.uppercase("hello, world!"));
    }

    @Test
    void stats() {
        // GIVEN: A string input.
        // WHEN: The stats() method is called with the input string.
        // THEN: A map containing the length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords of the input string is returned.
        Map<String, Object> result = textController.stats("Hello, World!");
        assertEquals(6, result.size());
        assertEquals(5, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(1, result.get("VowelCount"));
        assertEquals(2, result.get("ConsonantCount"));
        assertEquals(1, result.get("RepeatedWords").size());
    }

    @Test
    void replace() {
        // GIVEN: A string input, a target string, and a replacement string.
        // WHEN: The replace() method is called with the input, target, and replacement strings.
        // THEN: The input string with the target string replaced by the replacement string is returned.
        assertEquals("Hello, Universe!", textController.replace("Hello, World!", "World", "Universe"));
    }

    @Test
    void removeVowels() {
        // GIVEN: A string input.
        // WHEN: The removeVowels() method is called with the input string.
        // THEN: The string with all vowels removed is returned.
        assertEquals("Hll, Wrld!", textController.removeVowels("Hello, World!"));
    }

    @Test
    void removeConsonants() {
        // GIVEN: A string input.
        // WHEN: The removeConsonants() method is called with the input string.
        // THEN: The string with all consonants removed is returned.
        assertEquals("Hello, World!", textController.removeConsonants("Hello, World!"));
    }

    @Test
    void countOccurrence() {
        // GIVEN: A string input and a keyword.
        // WHEN: The countOccurrence() method is called with the input and keyword.
        // THEN: The number of occurrences of the keyword in the input string is returned.
        assertEquals(1, textController.countOccurrence("Hello, World!", "World"));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A JSON string.
        // WHEN: The convertJsonToYaml() method is called with the JSON string.
        // THEN: The YAML representation of the JSON string is returned.
        assertEquals("YAML representation of JSON", textController.convertJsonToYaml("{\"key\":\"value\"}java
        assertEquals("XML representation of JSON", textController.convertJsonToXml("{\"key\":\"value\"}"));
    }
}