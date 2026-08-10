package com.example.textapi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.regex.Pattern;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_shouldReverseString() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the reverse method is called
        // THEN the reversed string should be "World!, Hello,"
        String reversed = textService.reverse(input);
        assertEquals("World!, Hello,", reversed);
    }

    @Test
    void uppercase_shouldConvertStringToUppercase() {
        // GIVEN a string input
        String input = "hello, world!";
        // WHEN the uppercase method is called
        // THEN the uppercase string should be "HELLO, WORLD!"
        String uppercase = textService.uppercase(input);
        assertEquals("HELLO, WORLD!", uppercase);
    }

    @Test
    void stats_shouldCalculateStringStatistics() {
        // GIVEN a string input
        String input = "This is a test string.";
        // WHEN the stats method is called
        // THEN the result map should contain the length, word count, line count, vowel count, consonant count, and repeated words
        Map<String, Object> result = textService.stats(input);
        assertEquals(6, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(3, result.get("VowelCount"));
        assertEquals(6, result.get("ConsonantCount"));
        assertEquals(2, result.get("RepeatedWords"));
    }

    @Test
    void getLength_shouldReturnCorrectLength() {
        // GIVEN a string input
        String input = "Hello";
        // WHEN the getLength method is called
        // THEN the length should be 5
        Integer length = textService.getLength(input);
        assertEquals(5, length);
    }

    @Test
    void getSplitCount_shouldReturnCorrectSplitCount() {
        // GIVEN a string input and a split regex
        String input = "apple,banana,orange";
        String splitRegex = "\\s+";
        // WHEN the getSplitCount method is called
        // THEN the split count should be 3
        Integer splitCount = textService.getSplitCount(input, splitRegex);
        assertEquals(3, splitCount);
    }

    @Test
    void getRepeatedWords_shouldReturnRepeatedWords() {
        // GIVEN a string input
        String input = "This is a test string. This is another test.";
        // WHEN the getRepeatedWords method is called
        // THEN the result list should contain "This : 2" and "This : 2"
        List<String> repeatedWords = textService.getRepeatedWords(input);
        assertEquals(2, repeatedWords.size());
        assertEquals("This : 2", repeatedWords.get(0));
        assertEquals("This : 2", repeatedWords.get(1));
    }

    @Test
    void getConsonantCount_shouldReturnCorrectConsonantCount() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the getConsonantCount method is called
        // THEN the consonant count should be 6
        Integer consonantCount = textService.getConsonantCount(input);
        assertEquals(6, consonantCount);
    }

    @Test
    void getVowelCount_shouldReturnCorrectVowelCount() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the getVowelCount method is called
        // THEN the vowel count should be 3
        Integer vowelCount = textService.getVowelCount(input);
        assertEquals(3, vowelCount);
    }

    @Test
    void replace_shouldReplaceTargetWithReplacement() {
        // GIVEN a string input, a target string, and a replacement string
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Universe";
        // WHEN the replace method is called
        //java
        // THEN the input string should be replaced with the replacement string
        String replaced = textService.replace(input, target, replacement);
        assertEquals("Hello, Universe!", replaced);
    }

    @Test
    void removeVowels_shouldRemoveVowels() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeVowels method is called
        // THEN the string should be removed
        String removedVowels = textService.removeVowels(input);
        assertEquals("Hll, Wrld!", removedVowels);
    }

    @Test
    void removeConsonants_shouldRemoveConsonants() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeConsonants method is called
        // THEN the string should be removed
        String removedConsonants = textService.removeConsonants(input);
        assertEquals("Ae, Woo!", removedConsonants);
    }

    @Test
    void removePattern_shouldRemovePattern() {
        // GIVEN a string input and a regex
        String input = "Hello, World!";
        String regex = "(?i)[aeiou]";
        // WHEN the removePattern method is called
        // THEN the string should be removed
        String removed = textService.removePattern(input, regex);
        assertEquals("Hll, Wrld!", removed);
    }

    @Test
    void countOccurrence_shouldReturnCorrectOccurrenceCount() {
        // GIVEN a string input and a keyword
        String input = "This is a test string. This is another test.";
        String keyword = "test";
        // WHEN the countOccurrence method is called
        // THEN the occurrence count should be 2
        int count = textService.countOccurrence(input, keyword);
        assertEquals(2, count);
    }

    @Test
    void helloworld_shouldReturnHelloWorld() {
        // GIVEN no input
        // WHEN the helloworld method is called
        // THEN the string "Hello, World!" should be returned
        String helloWorld = textService.helloworld();
        assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void convertJsonToYaml_shouldConvertJsonToYaml() {
        // GIVEN a json string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToYaml method is called
        // THEN the yaml string should be converted
        String yaml = textService.convertJsonToYaml(json);
        assertEquals("YAMLMapper().writeValueAsString(jsonNode)", yaml);
    }

    @Test
    void convertJsonToXml_shouldConvertJsonToXml() {
        // GIVEN a json string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToXml method is called
        // THEN the xml string should be converted
        String xml = textService.convertJsonToXml(json);
        assertEquals("XMLMapper().writeValueAsString(jsonNode)", xml);
    }
}
