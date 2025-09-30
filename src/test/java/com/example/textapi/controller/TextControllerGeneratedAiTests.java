package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    private TextController textController;

    @BeforeEach
    void setUp() {
        textController = new TextController(textService);
    }

    @Test
    void testHelloWorld_returnsHelloWorldString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse_returnsReversedString() {
        // GIVEN
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase_returnsUppercaseString() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats_returnsStatsMap() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", any());
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace_returnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels_removesVowelsFromString() {
        // GIVEN
        String input = "Hello World";
        String expected = "Hll Wrld";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants_removesConsonantsFromString() {
        // GIVEN
        String input = "Hello World";
        String expected = "eoo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        Assertions.assertEquals(expected, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\"}
