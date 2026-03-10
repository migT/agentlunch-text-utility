package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("olleh");
    }

    @Test
    void reverse_ShouldReturnEmptyStringWhenInputIsEmpty() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void reverse_ShouldThrowNPEWhenInputIsNull() {
        // GIVEN
        String input = null;

        // WHEN & THEN
        assertThatThrownBy(() -> textService.reverse(input))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void uppercase_ShouldReturnUpperCaseString() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO");
    }

    @Test
    void uppercase_ShouldThrowNPEWhenInputIsNull() {
        // GIVEN
        String input = null;

        // WHEN & THEN
        assertThatThrownBy(() -> textService.uppercase(input))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nThis is a test";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result).containsEntry("length", 26)
                .containsEntry("wordCount", 6)
                .containsEntry("lineCount", 2)
                .containsEntry("VowelCount", 7)
                .containsEntry("ConsonantCount", 14)
                .containsEntry("RepeatedWords", List.of("is : 2"));
    }

    @Test
    void stats_ShouldThrowNPEWhenInputIsNull() {
        // GIVEN
        String input = null;

        // WHEN & THEN
        assertThatThrownBy(() -> textService.stats(input))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void getRepeatedWords_ShouldReturnRepeatedWordsWithCounts() {
        // GIVEN
        String input = "test test test hello hello world";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("test : 3", "hello : 2");
    }

    @Test
    void getRepeatedWords_ShouldReturnEmptyListWhenNoRepetitions() {
        // GIVEN
        String input = "unique words only";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void getRepeatedWords_ShouldReturnEmptyListWhenInputIsNullOrEmpty() {
        // GIVEN
        String nullInput = null;
        String emptyInput = "";

        // WHEN
        List<String> nullResult = textService.getRepeatedWords(nullInput);
        List<String> emptyResult = textService.getRepeatedWords(emptyInput);

        // THEN
        assertThat(nullResult).isEmpty();
        assertThat(emptyResult).isEmpty();
    }

    @Test
    void getRepeatedWords_ShouldIgnorePunctuationAndCase() {
        // GIVEN
        String input = "Hello, hello! HELLO?";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("hello : 3");
    }

    @Test
    void getConsonantCount_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(7);
    }
