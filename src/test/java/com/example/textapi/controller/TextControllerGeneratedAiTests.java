package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
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

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


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
        String input = "abcd";
        when(textService.reverse(input)).thenReturn("dcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo("dcba");
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "test";
        when(textService.uppercase(input)).thenReturn("TEST");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("TEST");
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "Hello world";
        Map<String, Object> mockStats = new HashMap<>();
        mockStats.put("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(mockStats);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_shouldReturnReplacedString() {
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
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo");
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_shouldReturnCount() {
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
    void jsonToYaml_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}
