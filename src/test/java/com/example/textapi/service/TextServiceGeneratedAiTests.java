package com.example.textapi.service;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
    }

    @Test
    public void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertEquals("olleh", result);
    }

    @Test
    public void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertEquals("", result);
    }

    @Test
    public void testUppercase_withLowercaseString_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertEquals("HELLO WORLD", result);
    }

    @Test
    public void testUppercase_withMixedString_returnsUppercase() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertEquals("HELLO WORLD", result);
    }

    @Test
    public void testStats_withNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertEquals(28, stats.get("length"));
        Assertions.assertEquals(5, stats.get("wordCount"));
        Assertions.assertEquals(2, stats.get("lineCount"));
        Assertions.assertTrue(((Integer)stats.get("VowelCount")) > 0);
        Assertions.assertTrue(((Integer)stats.get("ConsonantCount")) > 0);
        Assertions.assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    public void testStats_withEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertEquals(0, stats.get("length"));
        Assertions.assertEquals(1, stats.get("wordCount"));
        Assertions.assertEquals(1, stats.get("lineCount"));
        Assertions.assertEquals(0, stats.get("VowelCount"));
        Assertions.assertEquals(0, stats.get("ConsonantCount"));
        Assertions.assertTrue(((List<?>)stats.get("RepeatedWords")).isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "apple banana apple orange banana banana";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(result.contains("apple : 2"));
        Assertions.assertTrue(result.contains("banana : 3"));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testReplace_withValidTarget_returnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertEquals("hello java", result);
    }

    @Test
    public void testReplace_withTargetNotPresent_returnsOriginalString() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertEquals("hello world", result);
    }

    @Test
    public void testRemoveVowels_withVowels_returnsStringWithoutVowels() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        Assertions.assertEquals("hll wrld", result);
    }
