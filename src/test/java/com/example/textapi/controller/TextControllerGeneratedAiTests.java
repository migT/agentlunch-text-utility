package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        Mockito.when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertNotNull(result);
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc123";
        Mockito.when(textService.reverse(input)).thenReturn("321cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertNotNull(result);
        assertEquals("321cba", result);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "Hello World";
        Mockito.when(textService.uppercase(input)).thenReturn("HELLO WORLD");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertNotNull(result);
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello Hello\nWorld!";
        Map<String, Object> mockStats = new HashMap<>();
        mockStats.put("length", 12);
        mockStats.put("wordCount", 3);
        mockStats.put("lineCount", 2);
        mockStats.put("VowelCount", 4);
        mockStats.put("ConsonantCount", 7);
        mockStats.put("RepeatedWords", Arrays.asList("hello : 2"));
        Mockito.when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(12, result.get("length"));
        assertEquals(3, result.get("wordCount"));
        assertEquals(2, result.get("lineCount"));
        assertTrue(result.containsKey("VowelCount"));
        assertTrue(result.containsKey("ConsonantCount"));
        assertTrue(result.containsKey("RepeatedWords"));
        List<?> repeatedWords = (List<?>) result.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("hello")));
    }

    @Test
    void replace_ShouldReturnStringWithReplacements() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn("baz bar baz");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertNotNull(result);
        assertEquals("baz bar baz", result);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";
        Mockito.when(textService.removeVowels(input)).thenReturn("Hll Wrld");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertNotNull(result);
        assertFalse(result.matches(".*[aeiouAEIOU].*"));
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";
        Mockito.when(textService.removeConsonants(input)).thenReturn("eo o");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertNotNull(result);
        assertFalse(result.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*"));
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "foo bar foo Foo";
        String keyword = "foo";
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void jsonToYaml_ShouldConvertJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("key: value"));
    }

    @Test
    void jsonToYaml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{key:\"value\"}";
        String errorMsg = "Error converting JSON to YAML: Some error";
        Mockito.when(textService.convertJsonToYaml(invalidJson)).thenReturn(errorMsg);

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void jsonToXml_ShouldConvertJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<key>value</key>"));
    }

    @Test
    void jsonToXml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{key:\"value\"}";
        String errorMsg = "Error converting JSON to XML: Some error";
        Mockito.when(textService.convertJsonToXml(invalidJson)).thenReturn(errorMsg);

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
