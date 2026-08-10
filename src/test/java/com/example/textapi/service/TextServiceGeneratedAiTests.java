package com.example.textapi.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String reversed = textService.reverse(input);

        // THEN
        assertEquals("olleH", reversed);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";

        // WHEN
        String uppercase = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", uppercase);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "This is a test string.";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(8, stats.size());
        assertEquals(15, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(3, stats.get("VowelCount"));
        assertEquals(7, stats.get("ConsonantCount"));
        assertEquals("RepeatedWords : hello : 2", stats.get("RepeatedWords"));
    }

    @Test
    void testGetLength() {
        // GIVEN
        String input = "abc";

        // WHEN
        Integer length = textService.getLength(input);

        // THEN
        assertEquals(3, length);
    }

    @Test
    void testGetSplitCount() {
        // GIVEN
        String input = "apple,banana,orange";
        String splitRegex = "\\s+";

        // WHEN
        Integer splitCount = textService.getSplitCount(input, splitRegex);

        // THEN
        assertEquals(3, splitCount);
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "hello hello world";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertEquals(2, repeatedWords.size());
        assertEquals("hello : 2", repeatedWords.get(0));
        assertEquals("world : 1", repeatedWords.get(1));
    }

    @Test
    void testGetConsonantCount() {
        // GIVEN
        String input = "hello";

        // WHEN
        Integer consonantCount = textService.getConsonantCount(input);

        // THEN
        assertEquals(2, consonantCount);
    }

    @Test
    void testGetVowelCount() {
        // GIVEN
        String input = "hello";

        // WHEN
        Integer vowelCount = textService.getVowelCount(input);

        // THEN
        assertEquals(2, vowelCount);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Java";

        // WHEN
        String replaced = textService.replace(input, target, replacement);

        // THEN
        assertEquals("Hello, Java!", replaced);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "This is a test string.";

        // WHEN
        String removedVowels = textService.removeVowels(input);

        // THEN
        assertEquals("Ths s  tst strng.", removedVowels);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String removedConsonants = textService.removeConsonants(input);

        // THEN
        assertEquals("eoo", removedConsonants);
    }

    @Test
    void testRemovePattern() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "[b-df-hj-np-tv-z]";

        // WHEN
        String removedPattern = textService.removePattern(input, regex);

        // THEN
        assertEquals("Hello, World!", removedPattern);
        @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";

        // WHEN
        int occurrenceCount = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(2, occurrenceCount);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        // WHEN
        String helloWorld = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertEquals("{\n  \"name\": \"John\",\n  \"age\": 30\n}", yaml);
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertEquals("<root>\n  <name>John</name>\n  <age>30</age>\n</root>", xml);
    }
}
