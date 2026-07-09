package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Mocks reset automatically by MockitoExtension
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_ShouldReturnReversedString() {
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
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        String uppercased = "ABC";
        when(textService.uppercase(input)).thenReturn(uppercased);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(uppercased, result);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> statsMap = Map.of("length", 11, "wordCount", 2);
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(statsMap, result);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String replaced = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(replaced);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(replaced, result);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String withoutVowels = "hll";
        when(textService.removeVowels(input)).thenReturn(withoutVowels);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(withoutVowels, result);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String withoutConsonants = "eo";
        when(textService.removeConsonants(input)).thenReturn(withoutConsonants);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(withoutConsonants, result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        int count = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(count);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(count, result);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
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
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
    }

    // Exception handling tests for methods that may throw exceptions

    @Test
    void reverse_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.reverse(input));
    }

    @Test
    void uppercase_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.uppercase(input));
    }

    @Test
    void stats_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world";
        when(textService.stats(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.stats(input));
    }

    @Test
    void replace_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
    }

    @Test
    void removeVowels_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
    }

    @Test
    void removeConsonants_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
    }

    @Test
    void countOccurrence_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
    }

    @Test
    void jsonToYaml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
    }

    @Test
    void jsonToXml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("Service error"));

        // WHEN / THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
    }
}
