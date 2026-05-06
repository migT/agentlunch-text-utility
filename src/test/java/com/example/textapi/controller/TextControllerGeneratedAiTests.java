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

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void resetMocks() {
        // MockitoExtension automatically resets mocks before each test
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
    void reverse_ShouldThrowException_WhenInputIsNull() {
        // GIVEN
        String input = null;
        when(textService.reverse(input)).thenThrow(new NullPointerException("Input cannot be null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(input));
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
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> statsMap = Map.of("length", 11, "wordCount", 2);
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(statsMap, result);
        verify(textService).stats(input);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        String replaced = "hello java";
        when(textService.replace(input, target, replacement)).thenReturn(replaced);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(replaced, result);
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
    void countOccurrence_ShouldReturnOccurrenceCount() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";
        int count = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(count);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(count, result);
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
    void jsonToYaml_ShouldHandleConversionError() {
        // GIVEN
        String invalidJson = "invalid json";
        when(textService.convertJsonToYaml(invalidJson)).thenReturn("Error converting JSON to YAML: Invalid JSON");

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertEquals("Error converting JSON to YAML: Invalid JSON", result);
        verify(textService).convertJsonToYaml(invalidJson);
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
    void jsonToXml_ShouldHandleConversionError() {
        // GIVEN
        String invalidJson = "invalid json";
        when(textService.convertJsonToXml(invalidJson)).thenReturn("Error converting JSON to XML: Invalid JSON");

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertEquals("Error converting JSON to XML: Invalid JSON", result);
        verify(textService).convertJsonToXml(invalidJson);
    }
}
