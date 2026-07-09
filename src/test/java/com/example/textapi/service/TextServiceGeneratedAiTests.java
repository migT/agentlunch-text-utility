package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("cba");
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
    void uppercase_ShouldConvertToUpperCase() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC");
    }

    @Test
    void uppercase_ShouldReturnEmptyStringWhenInputIsEmpty() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void stats_ShouldReturnCorrectStatisticsForTypicalInput() {
        // GIVEN
        String input = "Hello world\nThis is a test";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertThat(stats.get("length")).isEqualTo(26);
        assertThat(stats.get("wordCount")).isEqualTo(6);
        assertThat(stats.get("lineCount")).isEqualTo(2);
        assertThat(stats.get("VowelCount")).isEqualTo(7);
        assertThat(stats.get("ConsonantCount")).isEqualTo(14);
        assertThat(stats.get("RepeatedWords")).isInstanceOf(List.class);
        assertThat((List<?>) stats.get("RepeatedWords")).isEmpty();
    }

    @Test
    void stats_ShouldReturnCorrectStatisticsForEmptyInput() {
        // GIVEN
        String input = "";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertThat(stats.get("length")).isEqualTo(0);
        assertThat(stats.get("wordCount")).isEqualTo(1);
        assertThat(stats.get("lineCount")).isEqualTo(1);
        assertThat(stats.get("VowelCount")).isEqualTo(0);
        assertThat(stats.get("ConsonantCount")).isEqualTo(0);
        assertThat((List<?>) stats.get("RepeatedWords")).isEmpty();
    }

    @Test
    void stats_ShouldThrowNullPointerExceptionWhenInputIsNull() {
        // GIVEN
        String input = null;

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textService.stats(input));
    }
