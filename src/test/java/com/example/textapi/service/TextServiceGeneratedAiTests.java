package com.example.textapi.service;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit5.MockitoJUnitRunner;
import org.mockito.junit5.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
@MockitoExtension
public class TextServiceGeneratedAiTests {

    @Test
    @DisplayName("Reverse String")
    void reverseString() {
        TextService textService = new TextService();
        String input = "Hello, World!";
        String reversed = textService.reverse(input);
        assertEquals("dlroW ,olleH", reversed);
    }

    @Test
    @DisplayName("Uppercase String")
    void uppercaseString() {
        TextService textService = new TextService();
        String input = "hello, world!";
        String uppercase = textService.uppercase(input);
        assertEquals("HELLO, WORLD!", uppercase);
    }

    @Test
    @DisplayName("Stats - Length, WordCount, LineCount, VowelCount, ConsonantCount, RepeatedWords")
    void stats() {
        TextService textService = new TextService();
        String input = "Hello, World!\nThis is a test.\n";
        Map<String, Object> stats = textService.stats(input);
        assertEquals(7, stats.get("length"));
        assertEquals(2, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(3, stats.get("VowelCount"));
        assertEquals(6, stats.get("ConsonantCount"));
        assertEquals(Arrays.asList("Hello : 1", "World : 1"), stats.get("RepeatedWords"));
    }

    @Test
    @DisplayName("RepeatedWords - Empty Input")
    void repeatedWordsEmptyInput() {
        TextService textService = new TextService();
        String input = "";
        List<String> repeatedWords = textService.getRepeatedWords(input);
        assertEquals(Collections.emptyList(), repeatedWords);
    }

    @Test
    @DisplayName("ConsonantCount - Empty Input")
    void consonantCountEmptyInput() {
        TextService textService = new TextService();
        String input = "";
        Integer consonantCount = textService.getConsonantCount(input);
        assertEquals(0, consonantCount);
    }

    @Test
    @DisplayName("VowelCount - Empty Input")
    void vowelCountEmptyInput() {
        TextService textService = new TextService();
        String input = "";
        Integer vowelCount = textService.getVowelCount(input);
        assertEquals(0, vowelCount);
    }

    @Test
    @DisplayName("Replace String")
    void replaceString() {
        TextService textService = new TextService();
        String input = "Hello, World!";
        String replaced = textService.replace(input, "World", "Universe");
        assertEquals("Hello, Universe!", replaced);
    }

    @Test
    @DisplayName("Remove Vowels")
    void removeVowels() {
        TextService textService = new TextService();
        String input = "Hello, World!";
        String removedVowels = textService.removeVowels(input);
        assertEquals("Hll, Wrld!", removedVowels);
    }

    @Test
    @DisplayName("Remove Consonants")
    void removeConsonants() {
        TextService textService = new TextService();
        String input = "Hello, World!";
        String removedConsonants = textService.removeConsonants(input);
        assertEquals("Eoo, Wrd!", removedConsonants);
    }

    @Test
    @DisplayName("Count Occurrence - Keyword in String")
    void countOccurrenceKeyword() {
        TextService textService = new TextService();
        String input = "Hello, World!";
        int count = textService.countOccurrence(input, "World");
        assertEquals(1, count);
    }

    @Testjava
    @DisplayName("HelloWorld")
    void helloworld() {
        TextService textService = new TextService();
        String helloWorld = textService.helloworld();
        assertEquals("Hello, World!", helloWorld);
    }
}
