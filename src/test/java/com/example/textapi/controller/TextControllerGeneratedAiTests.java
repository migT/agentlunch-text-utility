package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import java.util.List;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
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
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 17);
        expectedStats.put("wordCount", 3);
        expectedStats.put("lineCount", 2);
        expectedStats.put("VowelCount", 5);
        expectedStats.put("ConsonantCount", 8);
        expectedStats.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
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
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        String expected = "eoo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        int expected = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expectedYaml = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expectedXml = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, result);
    }
}
