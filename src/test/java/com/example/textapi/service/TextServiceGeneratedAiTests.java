package com.example.textapi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.Extension;

import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(TextServiceExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN: Input string is "hello"
        String input = "hello";
        // WHEN: Reverse the string
        String reversed = textService.reverse(input);
        // THEN: Reversed string should be "olleh"
        Assertions.assertEquals("olleh", reversed);
    }

    @Test
    void testUppercase() {
        // GIVEN: Input string is "hello"
        String input = "hello";
        // WHEN: Convert the string to uppercase
        String uppercase = textService.uppercase(input);
        // THEN: Uppercase string should be "HELLO"
        Assertions.assertEquals("HELLO", uppercase);
    }

    @Test
    void testStats() {
        // GIVEN: Input string is "Hello, World!"
        String input = "Hello, World!";
        // WHEN: Calculate the stats
        Map<String, Object> stats = textService.stats(input);
        // THEN: Stats should contain length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords
        Assertions.assertEquals(7, stats.get("length"));
        Assertions.assertEquals(2, stats.get("wordCount"));
        Assertions.assertEquals(1, stats.get("lineCount"));
        Assertions.assertEquals(3, stats.get("VowelCount"));
        Assertions.assertEquals(6, stats.get("ConsonantCount"));
        Assertions.assertEquals(2, stats.get("RepeatedWords"));
    }

    @Test
    void testGetLength() {
        // GIVEN: Input string is "hello"
        String input = "hello";
        // WHEN: Get the length of the string
        Integer length = textService.getLength(input);
        // THEN: Length should be 5
        Assertions.assertEquals(5, length);
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN: Input string is "hello hello world"
        String input = "hello hello world";
        // WHEN: Get the repeated words
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN: RepeatedWords should be ["hello : 2", "world : 1"]
        Assertions.assertEquals(2, repeatedWords.size());
        Assertions.assertEquals("hello : 2", repeatedWords.get(0));
        Assertions.assertEquals("world : 1", repeatedWords.get(1));
    }

    @Test
    void testGetConsonantCount() {
        // GIVEN: Input string is "Hello, World!"
        String input = "Hello, World!";
        // WHEN: Get the consonant count
        Integer consonantCount = textService.getConsonantCount(input);
        // THEN: ConsonantCount should be 6
        Assertions.assertEquals(6, consonantCount);
    }

    @Test
    void testGetVowelCount() {
        // GIVEN: Input string is "Hello, World!"
        String input = "Hello, World!";
        // WHEN: Get the vowel count
        Integer vowelCount = textService.getVowelCount(input);
        // THEN: VowelCount should be 3
        Assertions.assertEquals(3, vowelCount);
    }

    @Test
    void testReplace() {
        // GIVEN: Input string is "Hello, World!"
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Universe";
        // WHEN: Replace the target with the replacement
        String replaced = textService.replace(input, target, replacement);
        // THEN: Replaced string should be "Hello, Universe!"
        Assertions.assertEquals("Hello, Universe!", replaced);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN:javajava
        // WHEN: Remove vowels from the string
        String removedVowels = textService.removeVowels(input);
        // THEN: Removed vowels string should be "Hll, Wrld!"
        Assertions.assertEquals("Hll, Wrld!", removedVowels);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN: Input string is "Hello, World!"
        String input = "Hello, World!";
        // WHEN: Remove consonants from the string
        String removedConsonants = textService.removeConsonants(input);
        // THEN: Removed consonants string should be "e, o!"
        Assertions.assertEquals("e, o!", removedConsonants);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN: Input string is "Hello, World!", keyword is "World"
        String input = "Hello, World!";
        String keyword = "World";
        // WHEN: Count the occurrences of the keyword
        int occurrenceCount = textService.countOccurrence(input, keyword);
        // THEN: Occurrence count should be 1
        Assertions.assertEquals(1, occurrenceCount);
    }

    @Test
    void testHelloworld() {
        // GIVEN: No input
        // WHEN: Get the "hello world" string
        String helloWorld = textService.helloworld();
        // THEN: The returned string should be "Hello, World!"
        Assertions.assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN: Input JSON string is {"name": "John", "age": 30}
        String json = "{\"name\": \"John\", \"age\": 30}";
        // WHEN: Convert JSON to YAML
        String yaml = textService.convertJsonToYaml(json);
        // THEN: YAML string should be "name: John\nage: 30"
        Assertions.assertEquals("name: John\nage: 30", yaml);
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN: Input JSON string is {"name": "John", "age": 30}
        String json = "{\"name\": \"John\", \"age\": 30}";
        // WHEN: Convert JSON to XML
        String xml = textService.convertJsonToXml(json);
        // THEN: XML string should be "<root name=\"John\" age=\"30\"/>"
        Assertions.assertEquals("<?xml version=\"1.0\"?>\n<root name=\"John\" age=\"30\"/>", xml);
    }
}
