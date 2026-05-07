package com.example.textapi.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.textapi.service.TextService;

import java.util.List;
import java.util.Map;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN
        textService = mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";
        String reversed = "cba";
        when(textService.reverse(input)).thenReturn(reversed);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(reversed, result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        String upper = "ABC";
        when(textService.uppercase(input)).thenReturn(upper);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(upper, result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> statsMap = Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 7,
                "RepeatedWords", List.of()
        );
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(11, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(3, result.get("VowelCount"));
        assertEquals(7, result.get("ConsonantCount"));
        assertTrue(result.get("RepeatedWords") instanceof List);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String replaced = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(replaced);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(replaced, result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String noVowels = "hll";
        when(textService.removeVowels(input)).thenReturn(noVowels);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(noVowels, result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String noConsonants = "eo";
        when(textService.removeConsonants(input)).thenReturn(noConsonants);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(noConsonants, result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCountOfKeyword() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        int count = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(count);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(count, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
