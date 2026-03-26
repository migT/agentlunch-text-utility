package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
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
        assertEquals(expected, result);
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
        assertEquals(expected, result);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expected = Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 7,
                "RepeatedWords", List.of()
        );
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        String expected = "hello java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
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
        assertEquals(expected, result);
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
        assertEquals(expected, result);
    }

    @Test
    void countOccurrence_ShouldReturnCountOfKeyword() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }

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
        String replacement = "java";
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
