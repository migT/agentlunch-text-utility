package com.example.textapi.controller;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextControllerGeneratedAiTests {

    private TextController textController;
    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = Mockito.mock(TextService.class);
        textController = new TextController();

        // Use reflection to set the private textService field since it is private
        try {
            java.lang.reflect.Field field = TextController.class.getDeclaredField("textService");
            field.setAccessible(true);
            field.set(textController, textService);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set textService field via reflection: " + e.getMessage());
        }
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertNotNull(result);
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "test input";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 10);
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String expected = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(input, target, replacement);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCountOfKeyword() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        int expectedCount = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedCount);

        // WHEN
        int result = textController.countOccurrence(input, keyword);

        // THEN
        assertEquals(expectedCount,result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertEquals(expectedYaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertNotNull(result);
        assertEquals(expectedXml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}