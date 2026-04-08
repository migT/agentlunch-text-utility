package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void helloWorld_shouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_shouldReturnReversedString() {
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
    void reverse_shouldThrowException_whenServiceFails() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.reverse(input));
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
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
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 11);
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(11, result.get("length"));
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_shouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenReturn("hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_shouldReturnCorrectCount() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToYaml_shouldThrowException_whenConversionFails() {
        // GIVEN
        String json = "{\"invalid\":}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("Invalid JSON"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_shouldReturnXmlString() {
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

    @Test
    void jsonToXml_shouldThrowException_whenConversionFails() {
        // GIVEN
        String json = "{\"invalid\":}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("Invalid JSON"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
