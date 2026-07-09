package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
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
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks or any modified state before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "test";
        when(textService.uppercase(input)).thenReturn("TEST");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("TEST", result);
    }

    @Test
    void testStats() {
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
    void testReplace() {
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
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
    }

    @Test
    void testCountOccurrence() {
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
    void testJsonToYaml() {
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
    void testJsonToXml() {
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
    void testJsonToYamlThrowsException() {
        // GIVEN
        String invalidJson = "{invalid}";
        when(textService.convertJsonToYaml(invalidJson)).thenThrow(new RuntimeException("Invalid JSON"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToYaml(invalidJson));
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String invalidJson = "{invalid}";
        when(textService.convertJsonToXml(invalidJson)).thenThrow(new RuntimeException("Invalid JSON"));

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> textController.jsonToXml(invalidJson));
    }
}
