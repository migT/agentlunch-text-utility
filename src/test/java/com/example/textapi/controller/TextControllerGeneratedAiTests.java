package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN a mocked TextService and a TextController using it
        textService = Mockito.mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN the textService returns "Hello, World!"
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN helloWorld() is called
        String result = textController.helloWorld();

        // THEN the result should be "Hello, World!"
        assertEquals("Hello, World!", result);
        verify(textService).helloworld();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN an input string and expected reversed string
        String input = "abc";
        String reversed = "cba";
        when(textService.reverse(input)).thenReturn(reversed);

        // WHEN reverse() is called with input
        String result = textController.reverse(input);

        // THEN the result should be the reversed string
        assertEquals(reversed, result);
        verify(textService).reverse(input);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN an input string and expected uppercase string
        String input = "abc";
        String upper = "ABC";
        when(textService.uppercase(input)).thenReturn(upper);

        // WHEN uppercase() is called with input
        String result = textController.uppercase(input);

        // THEN the result should be the uppercase string
        assertEquals(upper, result);
        verify(textService).uppercase(input);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN an input string and a stats map
        String input = "hello world";
        Map<String, Object> statsMap = Map.of("length", 11, "wordCount", 2);
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN stats() is called with input
        Map<String, Object> result = textController.stats(input);

        // THEN the result should be the stats map
        assertNotNull(result);
        assertEquals(statsMap, result);
        verify(textService).stats(input);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN input string, target, replacement and expected output
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        String replaced = "hello java";
        when(textService.replace(input, target, replacement)).thenReturn(replaced);

        // WHEN replace() is called with input, target, replacement
        String result = textController.replace(target, replacement, input);

        // THEN the result should be the replaced string
        assertEquals(replaced, result);
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN an input string and expected output without vowels
        String input = "hello";
        String noVowels = "hll";
        when(textService.removeVowels(input)).thenReturn(noVowels);

        // WHEN removeVowels() is called with input
        String result = textController.removeVowels(input);

        // THEN the result should be string without vowels
        assertEquals(noVowels, result);
        verify(textService).removeVowels(input);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN an input string and expected output without consonants
        String input = "hello";
        String noConsonants = "eo";
        when(textService.removeConsonants(input)).thenReturn(noConsonants);

        // WHEN removeConsonants() is called with input
        String result = textController.removeConsonants(input);

        // THEN the result should be string without consonants
        assertEquals(noConsonants, result);
        verify(textService).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCountOfKeyword() {
        // GIVEN an input string, keyword and expected count
        String input = "hello hello world";
        String keyword = "hello";
        int count = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(count);

        // WHEN countOccurrence() is called with keyword and input
        int result = textController.countOccurrence(keyword, input);

        // THEN the result should be the count of keyword occurrences
        assertEquals(count, result);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN a JSON string and expected YAML string
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN jsonToYaml() is called with JSON string
        String result = textController.jsonToYaml(json);

        // THEN the result should be the YAML string
        assertEquals(yaml, result);
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN a JSON string and expected XML string
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN jsonToXml() is called with JSON string
        String result = textController.jsonToXml(json);

        // THEN the result should be the XML string
        assertEquals(xml, result);
        verify(textService).convertJsonToXml(json);
    }
}
