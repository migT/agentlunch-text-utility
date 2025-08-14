package com.example.textapi.service;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MockitoExtension;
import org.junit.jupiter.api.extension.MockitoJUnitRunner;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.*;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoJUnitRunner
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_shouldReverseString() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String reversed = textService.reverse(input);
        // THEN
        assertEquals("!dlroW ,olleH", reversed);
    }

    @Test
    void uppercase_shouldConvertStringToUppercase() {
        // GIVEN
        String input = "hello, world!";
        // WHEN
        String uppercase = textService.uppercase(input);
        // THEN
        assertEquals("HELLO, WORLD!", uppercase);
    }

    @Test
    void stats_shouldCalculateStringStats() {
        // GIVEN
        String input = "This is a test string.";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(5, stats.get("length"));
        assertEquals(2, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(2, stats.get("VowelCount"));
        assertEquals(6, stats.get("ConsonantCount"));
        assertEquals(Arrays.asList("This", "is", "a", "test", "string"), stats.get("RepeatedWords"));
    }

    @Test
    void getLength_shouldReturnCorrectLength() {
        // GIVEN
        String input = "Hello";
        // WHEN
        Integer length = textService.getLength(input);
        // THEN
        assertEquals(5, length);
    }

    @Test
    void getSplitCount_shouldReturnCorrectSplitCount() {
        // GIVEN
        String input = "apple,banana,orange";
        String splitRegex = "\\s+";
        // WHEN
        Integer splitCount = textService.getSplitCount(input, splitRegex);
        // THEN
        assertEquals(3, splitCount);
    }

    @Test
    void getRepeatedWords_shouldReturnRepeatedWords() {
        // GIVEN
        String input = "This is a test string. This is a test.";
        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN
        assertEquals(Arrays.asList("This : 2", "is : 2", "a : 1", "test : 2", "string : 1"), repeatedWords);
    }

    @Test
    void getConsonantCount_shouldReturnCorrectConsonantCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer consonantCount = textService.getConsonantCount(input);
        // THEN
        assertEquals(6, consonantCount);
    }

    @Test
    void getVowelCount_shouldReturnCorrectVowelCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer vowelCount = textService.getVowelCount(input);
        // THEN
        assertEquals(3, vowelCount);
    }

    @Test
    void replace_shouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Universe";
        // WHEN
        String replaced = textService.replace(input, target, replacement);
        // THEN
        assertEquals("Hello,java
        assertEquals("Hello, Universe!", replaced);
    }

    @Test
    void removeVowels_shouldRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String removedVowels = textService.removeVowels(input);
        // THEN
        assertEquals("Hll, Wrld!", removedVowels);
    }

    @Test
    void removeConsonants_shouldRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String removedConsonants = textService.removeConsonants(input);
        // THEN
        assertEquals("e, o!", removedConsonants);
    }

    @Test
    void removePattern_shouldRemovePattern() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "(?i)[b-df-hj-np-tv-z]";
        // WHEN
        String removed = textService.removePattern(input, regex);
        // THEN
        assertEquals("Hello, World!", removed);
    }

    @Test
    void countOccurrence_shouldCountKeywordOccurrences() {
        // GIVEN
        String input = "This is a test string. This is a test.";
        String keyword = "test";
        // WHEN
        int occurrences = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(2, occurrences);
    }

    @Test
    void helloworld_shouldReturnHelloWorld() {
        // GIVEN
        // WHEN
        String helloWorld = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", helloWorld);
    }

    @Test
    void convertJsonToYaml_shouldConvertJsonToYaml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertEquals("""
                name: John
                age: 30
                """, yaml);
    }

    @Test
    void convertJsonToXml_shouldConvertJsonToXml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertEquals("""
                <root>
                    <name>John</name>
                    <age>30</age>
                </root>
                """, xml);
    }
}
