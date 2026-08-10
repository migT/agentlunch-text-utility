package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.utils.TextConversionUtil;
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
    public void testReverse_GivenInputString_WhenReversed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenInputString_WhenConvertedToUppercase_ThenResultIsCorrect() {
        // GIVEN
        String input = "hello, world!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenInputString_WhenProcessed_ThenResultContainsCorrectStatistics() {
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
    public void testGetLength_GivenInputString_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void testGetSplitCount_GivenInputStringAndRegex_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";
        String regex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testGetRepeatedWords_GivenInputString_WhenProcessed_ThenResultContainsCorrectRepeatedWords() {
        // GIVEN
        String input = "Hello, World! Hello, World!";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).contains("Hello, World! : 2");
    }

    @Test
    public void testGetConsonantCount_GivenInputString_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void testGetVowelCount_GivenInputString_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testReplace_GivenInputStringAndReplacement_WhenProcessed_ThenResultIsCorrect() {
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
    public void testRemoveVowels_GivenInputString_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenInputString_WhenProcessed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo,a o!");
    }
