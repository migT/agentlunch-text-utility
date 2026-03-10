package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void helloWorld_shouldReturnHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_shouldReturnReversedString() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo("cba");
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC");
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "test";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 4);
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isSameAs(expected);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_shouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        when(textService.replace(input, target, replacement)).thenReturn("hello there");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo("hello there");
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        when(textService.removeVowels(input)).thenReturn("hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("hll");
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        when(textService.removeConsonants(input)).thenReturn("e");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("e");
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_shouldReturnCorrectCount() {
        // GIVEN
        String input = "test test";
        String keyword = "test";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(2);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenReturn("key: value\n");

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo("key: value\n");
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenReturn("<key>value</key>\n");

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo("<key>value</key>\n");
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
