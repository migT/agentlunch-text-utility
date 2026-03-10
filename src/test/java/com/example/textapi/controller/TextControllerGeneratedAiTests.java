package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
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
import org.springframework.http.MediaType;

import java.util.HashMap;
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
        // Reset mocks or any modified state before each test
    }

    @Test
    void helloWorld_shouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
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
    }

    @Test
    void reverse_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.reverse(input));
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
    }

    @Test
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 11);
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(11, result.get("length"));
    }

    @Test
    void stats_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "Hello world";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.stats(input));
    }

    @Test
    void replace_shouldReturnReplacedString() {
        // GIVEN
        String input = "Hello world";
        String target = "world";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void replace_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "Hello world";
        String target = "world";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
    }

    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
    }

    @Test
    void removeVowels_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
    }

    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
    }

    @Test
    void removeConsonants_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
    }

    @Test
    void countOccurrence_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Java Java Spring";
        String keyword = "Java";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
    }

    @Test
    void countOccurrence_shouldThrowExceptionWhenServiceFails() {
        // GIVEN
        String input = "Java Java Spring";
        String keyword = "Java";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count failed"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
    }

    @Test
    void jsonToYaml_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
    }

    @Test
    void jsonToYaml_shouldThrowExceptionWhenConversionFails() {
        // GIVEN
        String json = "{\"invalid_json\"";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("Conversion error"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
    }

    @Test
    void jsonToXml_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, result);
    }

    @Test
    void jsonToXml_shouldThrowExceptionWhenConversionFails() {
        // GIVEN
        String json = "{\"invalid_json\"";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("Conversion error"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
    }
}
