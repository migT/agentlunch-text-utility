package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String actual = textController.helloWorld();

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String actual = textController.reverse(input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String actual = textController.uppercase(input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", Collections.emptyList());
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> actual = textController.stats(input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String expected = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String actual = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeVowels(input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int actual = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String actual = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
       // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String actual = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, actual);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
