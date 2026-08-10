package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Create a new instance before each test to ensure isolation
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertThat(result).isEqualTo("fedcba");
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertThat(result).isEqualTo("HELLO");
    }

    @Test
    void testUppercase_withMixedCase_returnsUppercase() {
        // GIVEN
        String input = "HeLLo WoRLd";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        Assertions.assertThat(result).isEqualTo("HELLO WORLD");
    }

    @Test
    void testStats_withTypicalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertThat(stats.get("length")).isEqualTo(22);
        Assertions.assertThat(stats.get("wordCount")).isEqualTo(4);
        Assertions.assertThat(stats.get("lineCount")).isEqualTo(2);
        Assertions.assertThat(stats.get("VowelCount")).isInstanceOf(Integer.class);
        Assertions.assertThat(stats.get("ConsonantCount")).isInstanceOf(Integer.class);
        Assertions.assertThat(stats.get("RepeatedWords")).isInstanceOf(List.class);
    }

    @Test
    void testStats_withEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        Assertions.assertThat(stats.get("length")).isEqualTo(0);
        Assertions.assertThat(stats.get("wordCount")).isEqualTo(1);
        Assertions.assertThat(stats.get("lineCount")).isEqualTo(1);
        Assertions.assertThat(stats.get("RepeatedWords")).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertThat(repeated).contains("apple : 3", "banana : 2");
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertThat(repeated).isEmpty();
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        Assertions.assertThat(repeated).isEmpty();
    }

    @Test
    void testReplace_withValidTarget_replacesCorrectly() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertThat(result).isEqualTo("hello java");
    }

    @Test
    void testReplace_withNoTarget_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        Assertions.assertThat(result).isEqualTo("hello world");
    }

    @Test
    void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        Assertions.assertThat(result).isEqualTo("Hll Wrld");
    }
