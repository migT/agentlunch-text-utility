package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
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
    void testHelloWorld() {
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
    void testReverse() {
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
    void testUppercase() {
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
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";
        String expected = "Hll Wrld";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        String expected = "eo o";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "foo bar foo baz foo";
        String keyword = "foo";
        int expected = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        String expected = "name: \"John\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVENvoid testJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"John\"}";
        String expected = "<ObjectNode><name>John</name></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
        verify(textService).convertJsonToXml(json);
    }
}
