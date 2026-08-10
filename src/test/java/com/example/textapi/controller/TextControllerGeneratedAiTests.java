package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import java.util.Map;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        Mockito.reset(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
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
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";
        when(textService.uppercase(input)).thenReturn("HELLO");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        Map<String, Object> expectedStats = Map.of(
                "length", 21,
                "wordCount", 4,
                "lineCount", 2,
                "VowelCount", 7,
                "ConsonantCount", 10,
                "RepeatedWords", List.of("hello : 2")
        );
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        when(textService.replace(input, target, replacement)).thenReturn("baz bar baz");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("baz bar baz", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";
        when(textService.removeVowels(input)).thenReturn("Hll Wrld");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        when(textService.removeConsonants(input)).thenReturn("eoo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eoo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}
