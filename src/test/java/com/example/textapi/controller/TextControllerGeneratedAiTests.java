package com.example.textapi.controller;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // No additional setup required; MockitoExtension handles mock initialization.
    }

    @Test
    void helloWorld_ShouldReturnHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService).helloworld();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService).reverse(input);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService).uppercase(input);
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = Map.of(
                "length", 17,
                "wordCount", 3,
                "lineCount", 2,
                "VowelCount", 5,
                "ConsonantCount", 10,
                "RepeatedWords", java.util.List.of("hello : 2")
        );
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
        verify(textService).stats(input);
    }

    @Test
    void replace_ShouldReturnReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        when(textService.replace(input, target, replacement)).thenReturn("baz bar baz");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("baz bar baz", result);
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenReturn("hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("hll", result);
        verify(textService).removeVowels(input);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenReturn("eoo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eoo", result);
        verify(textService).removeConsonants(input);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "hello world hello";
        String keyword = "hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenReturn("key: value\n");

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals("key: value\n", result);
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        when(textService.convertJsonToXml(json)).thenReturn("<key>value</key>");

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals("<key>value</key>", result);
        verify(textService).convertJsonToXml(json);
    }
}