package com.example.textapi.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = mock(TextService.class);
        textController = new TextController(textService);
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
    void reverse_ShouldThrowException_WhenInputIsNull() {
        // GIVEN
        String input = null;
        when(textService.reverse(input)).thenThrow(new NullPointerException("Input cannot be null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(input));
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
    void uppercase_ShouldThrowException_WhenInputIsNull() {
        // GIVEN
        String input = null;
        when(textService.uppercase(input)).thenThrow(new NullPointerException("Input cannot be null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.uppercase(input));
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = Map.of(
                "length", 17,
                "wordCount", 3,
                "lineCount", 2,
                "VowelCount", 5,
                "ConsonantCount", 9,
                "RepeatedWords", List.of("hello : 2")
        );
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
        String replacement = "java";
        String expected = "hello java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

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
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";
        int expectedCount = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedCount);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expectedCount, result);
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
    void jsonToYaml_ShouldReturnErrorMessage_WhenInvalidJson() {
        // GIVEN
        String invalidJson = "{invalid json}";
        String errorMessage = "Error converting JSON to YAML: Unexpected character ('i' (code 105)): was expecting double-quote to start field name";
        when(textService.convertJsonToYaml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertEquals(errorMessage, result);
        verify(textService, times(1)).convertJsonToYaml(invalidJson);
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

    @Test
    void jsonToXml_ShouldReturnErrorMessage_WhenInvalidJson() {
        // GIVEN
        String invalidJson = "{invalid json}";
        String errorMessage = "Error converting JSON to XML: Unexpected character ('i' (code 105)): was expecting double-quote to start field name";
        when(textService.convertJsonToXml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertEquals(errorMessage, result);
        verify(textService, times(1)).convertJsonToXml(invalidJson);
    }
}
