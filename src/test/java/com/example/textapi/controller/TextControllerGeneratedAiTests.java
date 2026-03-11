package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    private TextController textController;

    @BeforeEach
    void setUp() {
        textController = new TextController(textService);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        when(textService.reverse(input)).thenReturn("dcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo("dcba");
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "Hello";
        when(textService.uppercase(input)).thenReturn("HELLO");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO");
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 6);
        expected.put("ConsonantCount", 11);
        expected.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(expected);
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
        assertThat(result).isEqualTo("baz bar baz");
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
        assertThat(result).isEqualTo("Hll Wrld");
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        when(textService.removeConsonants(input)).thenReturn("eoo o");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eoo o");
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(3);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo(yaml);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>\n";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo(xml);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
