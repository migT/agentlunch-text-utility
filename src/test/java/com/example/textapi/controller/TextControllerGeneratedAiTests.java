package com.example.textapi.controller;

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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertNotNull(result);
        assertEquals("cba", result);
    }

    @Test
    void reverse_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        doThrow(new RuntimeException("Error reversing")).when(textService).reverse(input);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Error reversing", exception.getMessage());
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertNotNull(result);
        assertEquals("ABC", result);
    }

    @Test
    void uppercase_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "abc";
        doThrow(new RuntimeException("Error uppercasing")).when(textService).uppercase(input);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Error uppercasing", exception.getMessage());
    }

    @Test
    void stats_ShouldReturnStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expectedStats = Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 7,
                "RepeatedWords", List.of()
        );
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertNotNull(result);
        assertEquals(expectedStats, result);
    }

    @Test
    void stats_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world";
        doThrow(new RuntimeException("Error getting stats")).when(textService).stats(input);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Error getting stats", exception.getMessage());
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        when(textService.replace(input, target, replacement)).thenReturn("hello java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertNotNull(result);
        assertEquals("hello java", result);
    }

    @Test
    void replace_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        doThrow(new RuntimeException("Error replacing")).when(textService).replace(input, target, replacement);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> textController.replace(target, replacement, input));
        assertEquals("Error replacing", exception.getMessage());
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenReturn("hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertNotNull(result);
        assertEquals("hll", result);
    }

    @Test
    void removeVowels_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        doThrow(new RuntimeException("Error removing vowels")).when(textService).removeVowels(input);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Error removing vowels", exception.getMessage());
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertNotNull(result);
        assertEquals("eo", result);
    }

    @Test
    void removeConsonants_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello";
        doThrow(new RuntimeException("Error removing consonants")).when(textService).removeConsonants(input);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Error removing consonants", exception.getMessage());
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
    }

    @Test
    void countOccurrence_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String input = "hello hello world";
        String keyword = "hello";
        doThrow(new RuntimeException("Error counting occurrence")).when(textService).countOccurrence(input, keyword);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> textController.countOccurrence(keyword, input));
        assertEquals("Error counting occurrence", exception.getMessage());
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
    }

    @Test
    void jsonToYaml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        doThrow(new RuntimeException("Error converting JSON to YAML")).when(textService).convertJsonToYaml(json);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("Error converting JSON to YAML", exception.getMessage());
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
    }

    @Test
    void jsonToXml_ShouldThrowException_WhenTextServiceThrows() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        doThrow(new RuntimeException("Error converting JSON to XML")).when(textService).convertJsonToXml(json);

        // WHEN / THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("Error converting JSON to XML", exception.getMessage());
    }
}
