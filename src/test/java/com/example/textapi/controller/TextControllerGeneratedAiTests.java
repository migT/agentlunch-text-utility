package com.example.textapi.controller;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    private TextController textController;

    @BeforeEach
    void setUp() {
        textController = new TextController(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String actual = textController.helloWorld();

        // THEN
        assertEquals(expected, actual, "Hello world response should match service output");
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String actual = textController.reverse(input);

        // THEN
        assertEquals(expected, actual, "Reversed string should match service output");
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "Hello";
        String expected = "HELLO";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String actual = textController.uppercase(input);

        // THEN
        assertEquals(expected, actual, "Uppercase string should match service output");
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 18);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 10);
        expected.put("RepeatedWords", java.util.Collections.singletonList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> actual = textController.stats(input);

        // THEN
        assertEquals(expected, actual, "Stats map should match service output");
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String actual = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, actual, "Replace result should match service output");
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";
        String expected = "Hll Wrld";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeVowels(input);

        // THEN
        assertEquals(expected, actual, "Vowel removal should match service output");
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        String expected = "eoo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, actual, "Consonant removal should match service output");
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Test test TEST";
        String keyword = "test";
        int expected = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int actual = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, actual, "Occurrence count should match service output");
    }
