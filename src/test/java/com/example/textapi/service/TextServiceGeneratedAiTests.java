package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.JUnit4;

@ExtendWith(JUnit4.class)
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
        assertEquals(5, stats.size());
        assertEquals(15, stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(3, stats.get("VowelCount"));
        assertEquals(6, stats.get("ConsonantCount"));
        assertEquals("RepeatedWords : null", stats.get("RepeatedWords"));
    }

    @Test
    void testGetLength() {
        // GIVEN
        String input = "test";

        // WHEN
        Integer length = textService.getLength(input);

        // THEN
        assertEquals(4, length);
    }

    @Test
    void testGetSplitCount() {
        // GIVEN
        String input = "hello world";
        String splitRegex = "\\s+";

        // WHEN
        Integer splitCount = textService.getSplitCount(input, splitRegex);

        // THEN
        assertEquals(2, splitCount);
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
        assertEquals(3, consonantCount);
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
        String input = "Hello, World!";

        // WHEN
        String removedVowels = textService.removeVowels(input);

        // THEN
        assertEquals("Hll, Wrld!", removedVowels);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String removedConsonants = textService.removeConsonants(input);

        // THEN
        assertEquals("eoo, o!", removedConsonants);
    }

    @Test
    void testRemovePattern() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "(?i)[aeiou]";

        // WHEN
        String removed = textService.removePattern(input, regex);

        // THEN
        assertEquals("", removed);
    }

    @Test
    void testCountOccurrence() {
        // Gjava
    void testCountOccurrence() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(2, count);
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
        assertEquals("<root><name>John</name><age>30</age></root>", xml);
    }
}
