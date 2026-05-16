package com.example.textapi.service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import com.example.textapi.utils.TextConversionUtil;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_shouldReverseString() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String reversed = textService.reverse(input);
        // THEN
        assertEquals("olleH", reversed);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "hello";
        // WHEN
        String uppercase = textService.uppercase(input);
        // THEN
        assertEquals("HELLO", uppercase);
    }

    @Test
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "This is a test string";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(6, stats.size());
        assertEquals("5", stats.get("length"));
        assertEquals("3", stats.get("wordCount"));
        assertEquals("2", stats.get("lineCount"));
        assertEquals("3", stats.get("VowelCount"));
        assertEquals("3", stats.get("ConsonantCount"));
        assertEquals("RepeatedWords : 1 : 1", stats.get("RepeatedWords"));
    }

    @Test
    void getLength_shouldReturnCorrectLength() {
        // GIVEN
        String input = "abc";
        // WHEN
        Integer length = textService.getLength(input);
        // THEN
        assertEquals(3, length);
    }

    @Test
    void getSplitCount_shouldReturnCorrectCount() {
        // GIVEN
        String input = "apple,banana,orange";
        String splitRegex = "\\s+";
        // WHEN
        Integer count = textService.getSplitCount(input, splitRegex);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void getConsonantCount_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello";
        // WHEN
        Integer count = textService.getConsonantCount(input);
        // THEN
        assertEquals(2, count);
    }

    @Test
    void getVowelCount_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello";
        // WHEN
        Integer count = textService.getVowelCount(input);
        // THEN
        assertEquals(2, count);
    }

    @Test
    void replace_shouldReplaceTargetWithReplacement() {
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
    void removeVowels_shouldRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll, Wrld!", result);
    }

    @Test
    void removeConsonants_shouldRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("He!", result);
    }

    @Test
    void removePattern_shouldRemovePattern() {
        // GIVEN
        String input = "Hello, World!";java
        String regex = "(?i)[b-df-hj-np-tv-z]";
        // WHEN
        String result = textService.removePattern(input, regex);
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void countOccurrence_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello,java";
        String input = "Hello, World!";
        String keyword = "World";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(1, count);
    }

    @Test
    void helloworld_shouldReturnHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
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