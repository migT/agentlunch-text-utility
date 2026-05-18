package com.example.textapi.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks before each test
        clearInvocations(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", Collections.emptyList());
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        String expected = "hello Java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowelsReturnsStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonantsReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        String keyword = "Java";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYamlReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        String expectedYaml = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXmlReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        String expectedXml = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
