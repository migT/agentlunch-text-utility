package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    public void setUp() {
        textService = mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    public void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(Mockito.eq(input))).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(Mockito.eq(input))).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> expectedStats = Collections.singletonMap("length", 11);
        when(textService.stats(Mockito.eq(input))).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(Mockito.eq(input), Mockito.eq(target), Mockito.eq(replacement))).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(Mockito.eq(input))).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(Mockito.eq(input))).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "Hello World Hello";
        String keyword = "Hello";
        when(textService.countOccurrence(Mockito.eq(input), Mockito.eq(keyword))).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(Mockito.eq(json))).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
    }

    @Test
    public void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(Mockito.eq(json))).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
    }
}
