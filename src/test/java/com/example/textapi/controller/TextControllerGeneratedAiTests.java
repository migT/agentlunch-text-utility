package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


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
        verify(textService).helloworld();
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
        verify(textService).reverse(input);
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
        verify(textService).uppercase(input);
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
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService).stats(input);
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
        String result = textController.replace(target, replacement, input);

        // THEN
        assertNotNull(result);
        assertEquals(expected, result);
        verify(textService).replace(input, target, replacement);
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
        verify(textService).removeVowels(input);
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
        verify(textService).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        int expectedCount = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedCount);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expectedCount, result);
        verify(textService).countOccurrence(input, keyword);
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
        verify(textService).convertJsonToYaml(json);
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
        verify(textService).convertJsonToXml(json);
    }

    @Test
    void jsonToYaml_WhenConversionFails_ShouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";
        String errorMessage = "Error converting JSON to YAML: some error";
        when(textService.convertJsonToYaml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
        verify(textService).convertJsonToYaml(invalidJson);
    }

    @Test
    void jsonToXml_WhenConversionFails_ShouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";
        String errorMessage = "Error converting JSON to XML: some error";
        when(textService.convertJsonToXml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
        verify(textService).convertJsonToXml(invalidJson);
    }
}
