package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the reverse method is called
        // THEN the reversed string should be "!dlroW ,olleH"
        String reversed = textService.reverse(input);
        assertEquals("!dlroW ,olleH", reversed);
    }

    @Test
    void testUppercase() {
        // GIVEN a string input
        String input = "hello, world!";
        // WHEN the uppercase method is called
        // THEN the uppercase string should be "HELLO, WORLD!"
        String uppercase = textService.uppercase(input);
        assertEquals("HELLO, WORLD!", uppercase);
    }

    @Test
    void testStats() {
        // GIVEN a string input
        String input = "This is a test string.";
        // WHEN the stats method is called
        // THEN the result map should contain the length, wordCount, lineCount, VowelCount, ConsonantCount, and RepeatedWords
        Map<String, Object> result = textService.stats(input);
        assertEquals(7, result.size());
        assertEquals(11, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(6, result.get("VowelCount"));
        assertEquals(12, result.get("ConsonantCount"));
        assertEquals(2, result.get("RepeatedWords").size());
    }

    @Test
    void testGetLength() {
        // GIVEN a string input
        String input = "Hello";
        // WHEN the getLength method is called
        // THEN the length should be 5
        Integer length = textService.getLength(input);
        assertEquals(5, length);
    }

    @Test
    void testGetSplitCount() {
        // GIVEN a string input and a split regex
        String input = "This is a test string.";
        String splitRegex = "\\s+";
        // WHEN the getSplitCount method is called
        // THEN the length should be 5
        Integer length = textService.getSplitCount(input, splitRegex);
        assertEquals(5, length);
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN a string input
        String input = "This is a test string. This is another test.";
        // WHEN the getRepeatedWords method is called
        // THEN the result list should contain "this : 2" and "test : 2"
        List<String> repeatedWords = textService.getRepeatedWords(input);
        assertEquals(2, repeatedWords.size());
        assertEquals("this : 2", repeatedWords.get(0));
        assertEquals("test : 2", repeatedWords.get(1));
    }

    @Test
    void testGetConsonantCount() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the getConsonantCount method is called
        // THEN the consonant count should be 6
        Integer consonantCount = textService.getConsonantCount(input);
        assertEquals(6, consonantCount);
    }

    @Test
    void testGetVowelCount() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the getVowelCount method is calledjava
        // THEN the vowel count should be 3
        Integer vowelCount = textService.getVowelCount(input);
        assertEquals(3, vowelCount);
    }

    @Test
    void testReplace() {
        // GIVEN a string input, a target, and a replacement
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Universe";
        // WHEN the replace method is called
        // THEN the replaced string should be "Hello, Universe!"
        String replaced = textService.replace(input, target, replacement);
        assertEquals("Hello, Universe!", replaced);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeVowels method is called
        // THEN the string without vowels should be "Hll, Wrld!"
        String withoutVowels = textService.removeVowels(input);
        assertEquals("Hll, Wrld!", withoutVowels);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN a string input
        String input = "Hello, World!";
        // WHEN the removeConsonants method is called
        // THEN the string without consonants should be "aeiou"
        String withoutConsonants = textService.removeConsonants(input);
        assertEquals("aeiou", withoutConsonants);
    }

    @Test
    void testRemovePattern() {
        // GIVEN a string input and a regex
        String input = "Hello, World!";
        String regex = "(?i)[aeiou]";
        // WHEN the removePattern method is called
        // THEN the string without vowels should be "Hll, Wrld!"
        String withoutVowels = textService.removePattern(input, regex);
        assertEquals("Hll, Wrld!", withoutVowels);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN a string input and a keyword
        String input = "This is a test string. This is another test.";
        String keyword = "test";
        // WHEN the countOccurrence method is called
        // THEN the count should be 2
        int count = textService.countOccurrence(input, keyword);
        assertEquals(2, count);
    }

    @Test
    void testHelloWorld() {
        // GIVEN no input
        // WHEN the helloworld method is called
        // THEN the returned string should be "Hello, World!"
        String helloWorld = textService.helloworld();
        assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN a json string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToYaml method is called
        // THEN the yaml string should be "name: John\nage: 30"
        String yaml = textService.convertJsonToYaml(json);
        assertEquals("name: John\nage: 30", yaml);
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN a json string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToXml method is called
        // THEN the xml string should be "<root name=\"John\" age=\"30\"/>"
        String xml = textService.convertJsonToXml(json);
        assertEquals("<root name=\"John\" age=\"30\"/>", xml);
    }
}