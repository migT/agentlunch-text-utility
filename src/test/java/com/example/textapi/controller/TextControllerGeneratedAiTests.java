package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.HashMap;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.clearInvocations;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

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
        verify(textService).helloworld();
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).reverse(input);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).uppercase(input);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", java.util.Collections.emptyList());
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).stats(input);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowelsReturnsStringWithoutVowels() {
        // GIVEN
        String input = "Hello";
        String expected = "Hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).removeVowels(input);
    }

    @Test
    void testRemoveConsonantsReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "Hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).removeConsonants(input);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
        verify(textService).convertJsonToXml(json);
    }
}
