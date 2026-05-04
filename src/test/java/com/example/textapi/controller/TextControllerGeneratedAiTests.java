package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
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
    void helloWorld_ReturnsHelloWorldString() {
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
    void reverse_WithValidInput_ReturnsReversedString() {
        // GIVEN
        String input = "abc";
        String reversed = "cba";
        when(textService.reverse(eq(input))).thenReturn(reversed);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertNotNull(result);
        assertEquals(reversed, result);
        verify(textService).reverse(eq(input));
    }

    @Test
    void uppercase_WithValidInput_ReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String upper = "ABC";
        when(textService.uppercase(eq(input))).thenReturn(upper);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertNotNull(result);
        assertEquals(upper, result);
        verify(textService).uppercase(eq(input));
    }

    @Test
    void stats_WithValidInput_ReturnsStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> stats = Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 7,
                "RepeatedWords", List.of()
        );
        when(textService.stats(eq(input))).thenReturn(stats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(stats, result);
        verify(textService).stats(eq(input));
    }

    @Test
    void replace_WithValidInput_ReturnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        String replaced = "hello java";
        when(textService.replace(eq(input), eq(target), eq(replacement))).thenReturn(replaced);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertNotNull(result);
        assertEquals(replaced, result);
        verify(textService).replace(eq(input), eq(target), eq(replacement));
    }

    @Test
    void removeVowels_WithValidInput_ReturnsStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String noVowels = "hll";
        when(textService.removeVowels(eq(input))).thenReturn(noVowels);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertNotNull(result);
        assertEquals(noVowels, result);
        verify(textService).removeVowels(eq(input));
    }

    @Test
    void removeConsonants_WithValidInput_ReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String noConsonants = "eo";
        when(textService.removeConsonants(eq(input))).thenReturn(noConsonants);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertNotNull(result);
        assertEquals(noConsonants, result);
        verify(textService).removeConsonants(eq(input));
    }

    @Test
    void countOccurrence_WithValidInput_ReturnsCorrectCount() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";
        int count = 2;
        when(textService.countOccurrence(eq(input), eq(keyword))).thenReturn(count);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(count, result);
        verify(textService).countOccurrence(eq(input), eq(keyword));
    }

    @Test
    void jsonToYaml_WithValidJson_ReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        when(textService.convertJsonToYaml(eq(json))).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertEquals(yaml, result);
        verify(textService).convertJsonToYaml(eq(json));
    }

    @Test
    void jsonToXml_WithValidJson_ReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(eq(json))).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertNotNull(result);
        assertEquals(xml, result);
        verify(textService).convertJsonToXml(eq(json));
    }

    @Test
    void reverse_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        when(textService.reverse(eq(input))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(input));
        verify(textService).reverse(eq(input));
    }

    @Test
    void uppercase_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        when(textService.uppercase(eq(input))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.uppercase(input));
        verify(textService).uppercase(eq(input));
    }

    @Test
    void stats_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        when(textService.stats(eq(input))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.stats(input));
        verify(textService).stats(eq(input));
    }

    @Test
    void replace_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        String target = "a";
        String replacement = "b";
        when(textService.replace(eq(input), eq(target), eq(replacement))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.replace(target, replacement, input));
        verify(textService).replace(eq(input), eq(target), eq(replacement));
    }

    @Test
    void removeVowels_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        when(textService.removeVowels(eq(input))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.removeVowels(input));
        verify(textService).removeVowels(eq(input));
    }

    @Test
    void removeConsonants_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        when(textService.removeConsonants(eq(input))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.removeConsonants(input));
        verify(textService).removeConsonants(eq(input));
    }

    @Test
    void countOccurrence_WithNullInput_ThrowsNullPointerException() {
        // GIVEN
        String input = null;
        String keyword = "test";
        when(textService.countOccurrence(eq(input), eq(keyword))).thenThrow(NullPointerException.class);

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.countOccurrence(keyword, input));
        verify(textService).countOccurrence(eq(input), eq(keyword));
    }

    @Test
    void jsonToYaml_WithInvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";
        String errorMessage = "Error converting JSON to YAML: ...";
        when(textService.convertJsonToYaml(eq(invalidJson))).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertEquals(errorMessage, result);
        verify(textService).convertJsonToYaml(eq(invalidJson));
    }

    @Test
    void jsonToXml_WithInvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";
        String errorMessage = "Error converting JSON to XML: ...";
        when(textService.convertJsonToXml(eq(invalidJson))).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertEquals(errorMessage, result);
        verify(textService).convertJsonToXml(eq(invalidJson));
    }
}
