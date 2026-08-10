package com.example.textapi.controller;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize mocks and reset state before each test
        MockitoAnnotations.openMocks(this);
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abc";
        String reversed = "cba";
        when(textService.reverse(input)).thenReturn(reversed);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(reversed, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String upper = "ABC";
        when(textService.uppercase(input)).thenReturn(upper);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(upper, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> stats = new HashMap<>();
        stats.put("length", 11);
        stats.put("wordCount", 2);
        stats.put("lineCount", 1);
        stats.put("VowelCount", 3);
        stats.put("ConsonantCount", 7);
        stats.put("RepeatedWords", Collections.emptyList());
        when(textService.stats(input)).thenReturn(stats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(stats, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        String replaced = "hello java";
        when(textService.replace(input, target, replacement)).thenReturn(replaced);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(replaced, result);
    }

    @Test
    void testRemoveVowelsReturnsStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String noVowels = "hll";
        when(textService.removeVowels(input)).thenReturn(noVowels);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(noVowels, result);
    }

    @Test
    void testRemoveConsonantsReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String noConsonants = "eo";
        when(textService.removeConsonants(input)).thenReturn(noConsonants);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(noConsonants, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "test test TEST";
        String keyword = "test";
        int expectedCount = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedCount);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expectedCount, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}