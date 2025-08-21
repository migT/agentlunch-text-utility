package com.example.textapi.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_shouldReverseString() {
        // GIVEN a string input
        String input = "Hello";
        // WHEN the reverse method is called
        // THEN the reversed string should be "olleH"
        assertEquals("olleH", textService.reverse(input));
    }

    @Test
    void uppercase_shouldConvertStringToUpperCase() {
        // GIVEN a string input
        String input = "hello";
        // WHEN the uppercase method is called
        // THEN the uppercase string should be "HELLO"
        assertEquals("HELLO", textService.uppercase(input));
    }

    @Test
    void stats_shouldCalculateStringStats() {
        // GIVEN a string input
        String input = "This is a test string.";
        // WHEN the stats method is called
        // THEN the result map should contain the length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords
        Map<String, Object> result = textService.stats(input);
        assertEquals(7, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(4, result.get("VowelCount"));
        assertEquals(6, result.get("ConsonantCount"));
        assertEquals(2, result.get("RepeatedWords"));
    }

    @Test
    void getLength_shouldReturnCorrectLength() {
        // GIVEN a string input
        String input = "test";
        // WHEN the getLength method is called
        // THEN the length should be 4
        assertEquals(4, textService.getLength(input));
    }

    @Test
    void getSplitCount_shouldReturnCorrectSplitCount() {
        // GIVEN a string input and a split regex
        String input = "hello, world!";
        String splitRegex = "\\s+";
        // WHEN the getSplitCount method is called
        // THEN the split count should be 2
        assertEquals(2, textService.getSplitCount(input, splitRegex));
    }

    @Test
    void getConsonantCount_shouldReturnCorrectConsonantCount() {
        // GIVEN a string input
        String input = "Hello";
        // WHEN the getConsonantCount method is called
        // THEN the consonant count should be 3
        assertEquals(3, textService.getConsonantCount(input));
    }

    @Test
    void getVowelCount_shouldReturnCorrectVowelCount() {
        // GIVEN a string input
        String input = "Hello";
        // WHEN the getVowelCount method is called
        // THEN the vowel count should be 2
        assertEquals(2, textService.getVowelCount(input));
    }

    @Test
    void replace_shouldReplaceTargetWithReplacement() {
        // GIVEN a string input, a target string, and a replacement string
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Java";
        // WHEN the replace method is called
        // THEN the input string should be "Hello, Java!"
        assertEquals("Hello, Java!", textService.replace(input, target, replacement));
    }

    @Test
    void removeVowels_shouldRemoveVowelsFromInput() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeVowels method is called
        // THEN the output string should be "Hll, Wrld!"
        assertEqualsjava
        assertEquals("Hll, Wrld!", textService.removeVowels(input));
    }

    @Test
    void removeConsonants_shouldRemoveConsonantsFromInput() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeConsonants method is called
        // THEN the output string should be "He, Wr!"
        assertEquals("He, Wr!", textService.removeConsonants(input));
    }

    @Test
    void countOccurrence_shouldReturnCorrectOccurrenceCount() {
        // GIVEN a string input and a keyword
        String input = "Hello, World!";
        String keyword = "World";
        // WHEN the countOccurrence method is called
        // THEN the occurrence count should be 1
        assertEquals(1, textService.countOccurrence(input, keyword));
    }

    @Test
    void helloworld_shouldReturnHelloWorld() {
        // GIVEN no input
        // WHEN the helloworld method is called
        // THEN the output string should be "Hello, World!"
        assertEquals("Hello, World!", textService.helloworld());
    }

    @Test
    void convertJsonToYaml_shouldConvertJsonToYaml() {
        // GIVEN a JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToYaml method is called
        // THEN the output string should be YAML representation of the JSON
        String yaml = textService.convertJsonToYaml(json);
        // Assert that the YAML output is valid YAML
        assert (yaml.startsWith("---\n"));
    }

    @Test
    void convertJsonToXml_shouldConvertJsonToXml() {
        // GIVEN a JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToXml method is called
        // THEN the output string should be XML representation of the JSON
        String xml = textService.convertJsonToXml(json);
        // Assert that the XML output is valid XML
        assert (xml.startsWith("<?xml version=\"1.0\"?>\n<root>\n"));
    }
}