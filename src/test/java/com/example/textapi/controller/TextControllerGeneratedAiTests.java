package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: reset mock to ensure a clean state before each test
        Mockito.reset(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        String expected = "Hello, World!";
        Mockito.when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        Mockito.when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "test";
        String expected = "TEST";
        Mockito.when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Collections.emptyList());

        Mockito.when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";

        Mockito.when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "aeiouAEIOUxyz";
        String expected = "xyz";

        Mockito.when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "bcdfghBCDFGHxyz";
        String expected = "xyz";

        Mockito.when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "test Test tESt testing";
        String keyword = "test";
        int expected = 3;

        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";

        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";

        Mockito.when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).convertJsonToXml(json);
    }

    @Test
    void testJsonToYamlWhenServiceThrowsException() {
        // GIVEN
        String json = "invalid json";
        RuntimeException exception = new RuntimeException("Conversion error");
        Mockito.when(textService.convertJsonToYaml(json)).thenThrow(exception);

        // WHEN / THEN
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals(exception.getMessage(), thrown.getMessage());
        Mockito.verify(textService).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXmlWhenServiceThrowsException() {
        // GIVEN
        String json = "invalid json";
        RuntimeException exception = new RuntimeException("Conversion error");
        Mockito.when(textService.convertJsonToXml(json)).thenThrow(exception);

        // WHEN / THEN
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals(exception.getMessage(), thrown.getMessage());
        Mockito.verify(textService).convertJsonToXml(json);
    }

    @Test
    void testReverseWithNullInput() {
        // GIVEN
        String input = null;
        String expected = null;
        Mockito.when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).reverse(input);
    }

    @Test
    void testUppercaseWithEmptyString() {
        // GIVEN
        String input = "";
        String expected = "";
        Mockito.when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService).uppercase(input);
    }
}
