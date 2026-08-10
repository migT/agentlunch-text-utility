package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsExpected() {
        // GIVEN
        String input = "hello, world!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenString_WhenStatisticsComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(36);
        assertThat(result.get("wordCount")).isEqualTo(6);
        assertThat(result.get("lineCount")).isEqualTo(1);
    }

    @Test
    public void testGetLength_GivenNullString_WhenLengthComputed_ThenResultIsZero() {
        // GIVEN
        String input = null;

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetSplitCount_GivenStringAndRegex_WhenSplitCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string.";
        String regex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string. Hello again.";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("Hello : 2", "This : 1");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(24);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void testReplace_GivenStringAndTarget_WhenReplaced_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";

        // WHEN
        String result = textService.replace(input, target, "Earth");

        // THEN
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsRemoved_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsRemoved_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("aeio, a!");
    }
