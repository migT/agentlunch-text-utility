package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.regex.Pattern;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo(" !dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenString_WhenStatisticsComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(31);
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
    public void testGetSplitCount_GivenString_SplitRegex_WhenSplitCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";
        String splitRegex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, splitRegex);

        // THEN
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string. Hello again.";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("Hello : 2");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(17);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void testReplace_GivenString_TargetReplacement_WhenReplaced_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("aeio, a!");
    }

    @Test
    public void testCountOccurrence_GivenString_Keyword_WhenOccurrencesCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! Hello again.";
        String keyword = "Hello";

        // WHEN
        int result = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldComputed_ThenResultIsCorrect() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }
}
