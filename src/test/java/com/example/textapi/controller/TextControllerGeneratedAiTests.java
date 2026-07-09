package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "test";
        when(textService.uppercase(input)).thenReturn("TEST");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("TEST", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> mockStats = new HashMap<>();
        mockStats.put("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(11, result.get("length"));
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello world";
        String target = "world";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        String keyword = "Java";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
