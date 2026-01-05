package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
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
        // GIVEN: Reset all mocks before each test
        Mockito.reset(textService);
    }

    @Test
    void helloWorld_returnsHelloWorldString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_returnsStatsMap() {
        // GIVEN
        String input = "Hello world";
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
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_returnsReplacedString() {
        // GIVEN
        String input = "foo bar";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_returnsStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_returnsStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_returnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}
