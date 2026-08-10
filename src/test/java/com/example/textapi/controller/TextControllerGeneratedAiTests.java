package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = Mockito.mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService).helloworld();
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
        verify(textService).reverse(input);
    }

    @Test
    void reverse_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", exception.getMessage());
        verify(textService).reverse(input);
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
        verify(textService).uppercase(input);
    }

    @Test
    void uppercase_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", exception.getMessage());
        verify(textService).uppercase(input);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "test input";
        Map<String, Object> statsMap = new HashMap<>();
        statsMap.put("length", 10);
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(10, result.get("length"));
        verify(textService).stats(input);
    }

    @Test
    void stats_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "test input";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", exception.getMessage());
        verify(textService).stats(input);
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
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void replace_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", exception.getMessage());
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String noVowels = "hll";
        when(textService.removeVowels(input)).thenReturn(noVowels);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(noVowels, result);
        verify(textService).removeVowels(input);
    }

    @Test
    void removeVowels_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", exception.getMessage());
        verify(textService).removeVowels(input);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String noConsonants = "eo";
        when(textService.removeConsonants(input)).thenReturn(noConsonants);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(noConsonants, result);
        verify(textService).removeConsonants(input);
    }

    @Test
    void removeConsonants_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", exception.getMessage());
        verify(textService).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCountOfKeyword() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        int count = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(count);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(count, result);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void countOccurrence_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", exception.getMessage());
        verify(textService).countOccurrence(input, keyword);
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
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void jsonToYaml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML conversion error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML conversion error", exception.getMessage());
        verify(textService).convertJsonToYaml(json);
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
        verify(textService).convertJsonToXml(json);
    }

    @Test
    void jsonToXml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML conversion error"));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML conversion error", exception.getMessage());
        verify(textService).convertJsonToXml(json);
    }
}
