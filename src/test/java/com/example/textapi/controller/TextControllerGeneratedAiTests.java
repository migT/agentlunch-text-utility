package com.example.textapi.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or initialize before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");
        // WHEN
        String result = textController.helloWorld();
        // THEN
        assertEquals("Hello, World!", result);
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
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");
        // WHEN
        String result = textController.uppercase(input);
        // THEN
        assertEquals("ABC", result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "abc def";
        Map<String, Object> expected = Collections.singletonMap("length", 7);
        when(textService.stats(input)).thenReturn(expected);
        // WHEN
        Map<String, Object> result = textController.stats(input);
        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        when(textService.replace(input, target, replacement)).thenReturn("hello java");
        // WHEN
        String result = textController.replace(target, replacement, input);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenReturn("hll");
        // WHEN
        String result = textController.removeVowels(input);
        // THEN
        assertEquals("hll", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenReturn("eo");
        // WHEN
        String result = textController.removeConsonants(input);
        // THEN
        assertEquals("eo", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);
        // WHEN
        int result = textController.countOccurrence(keyword, input);
        // THEN
        assertEquals(2, result);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);
        // WHEN
        String result = textController.jsonToYaml(json);
        // THEN
        assertEquals(yaml, result);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);
        // WHEN
        String result = textController.jsonToXml(json);
        // THEN
        assertEquals(xml, result);
    }
}
