package com.example.textapi.service;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("olleH");
    }

    @Test
    void reverse_ShouldReturnEmptyStringWhenInputIsEmpty() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("");
    }

    @Test
    void uppercase_ShouldConvertToUpperCase() {
        // GIVEN
        String input = "hello world";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO WORLD");
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(17);
        assertThat(result.get("wordCount")).isEqualTo(3);
        assertThat(result.get("lineCount")).isEqualTo(2);
        assertThat(result.get("VowelCount")).isEqualTo(5);
        assertThat(result.get("ConsonantCount")).isEqualTo(10);
        @SuppressWarnings("unchecked")
        List<String> repeated = (List<String>) result.get("RepeatedWords");
        assertThat(repeated).containsExactly("hello : 2");
    }

    @Test
    void replace_ShouldReplaceAllOccurrences() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertThat(result).isEqualTo("baz bar baz");
    }

    @Test
    void removeVowels_ShouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll");
    }

    @Test
    void removeConsonants_ShouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo");
    }

    @Test
    void countOccurrence_ShouldCountCaseInsensitiveOccurrences() {
        // GIVEN
        String input = "Hello world, hello again";
        String keyword = "hello";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isEqualTo(2);
    }
}