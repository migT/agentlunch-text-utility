package com.example.textapi.service;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN a fresh instance of TextService before each test
        textService = new TextService();
    }

    @Test
    void reverse_shouldReturnReversedString() {
        // GIVEN an input string
        String input = "abcdef";

        // WHEN reverse is invoked
        String result = textService.reverse(input);

        // THEN the result should be the reversed string
        assertThat(result).isEqualTo("fedcba");
    }

    @Test
    void uppercase_shouldConvertToUpperCase() {
        // GIVEN a mixed‑case string
        String input = "HeLLo WoRLd";

        // WHEN uppercase is invoked
        String result = textService.uppercase(input);

        // THEN the result should be all upper case
        assertThat(result).isEqualTo("HELLO WORLD");
    }

    @Test
    void stats_shouldCalculateCorrectMetrics() {
        // GIVEN a sample multiline string with repeated words and known vowel/consonant counts
        String input = "Hello world\nHello Java\nJava is fun";

        // WHEN stats is invoked
        Map<String, Object> stats = textService.stats(input);

        // THEN each metric should match the expected value
        assertThat(stats).containsEntry("length", input.length());
        assertThat(stats).containsEntry("wordCount", 7);
        assertThat(stats).containsEntry("lineCount", 3);
        // Vowels: e,o,o,o,a,a,i,u = 11 (adjusted)
        assertThat(stats).containsEntry("VowelCount", 11);
        // Consonants: H,l,l,w,r,l,d,H,l,l,J,v,J,s,f,n = 17 (adjusted)
        assertThat(stats).containsEntry("ConsonantCount", 17);
        // Repeated words: "hello" and "java"
        @SuppressWarnings("unchecked")
        List<String> repeated = (List<String>) stats.get("RepeatedWords");
        assertThat(repeated).containsExactlyInAnyOrder("hello : 2", "java : 2");
    }

    @Test
    void stats_shouldThrowExceptionWhenInputIsNull() {
        // GIVEN a null input
        String input = null;

        // WHEN stats is invoked
        // THEN a NullPointerException is thrown because split is called on null
        assertThatThrownBy(() -> textService.stats(input))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void getRepeatedWords_shouldReturnEmptyListForNullOrEmptyInput() {
        // GIVEN a null input
        String nullInput = null;

        // WHEN getRepeatedWords is invoked with null
        List<String> nullResult = textService.getRepeatedWords(nullInput);

        // THEN the result should be empty
        assertThat(nullResult).isEmpty();

        // GIVEN an empty string
        String emptyInput = "";

        // WHEN getRepeatedWords is invoked with empty string
        List<String> emptyResult = textService.getRepeatedWords(emptyInput);

        // THEN the result should also be empty
        assertThat(emptyResult).isEmpty();
    }

    @Test
    void getRepeatedWords_shouldIdentifyRepeatedWordsCaseInsensitively() {
        // GIVEN a sentence with repeated words and punctuation
        String input = "Test, test! Testing test.";

        // WHEN getRepeatedWords is invoked
        List<String> result = textService.getRepeatedWords(input);

        // THEN the list should contain the repeated word "test" with count 3
        assertThat(result).containsExactly("test : 3");
    }

    @Test
    void replace_shouldReplaceAllOccurrencesOfTarget() {
        // GIVEN an input string, target and replacement
        String input = "foo bar foo baz";
        String target = "foo";
        String replacement = "qux";

        // WHEN replace is invoked
        String result = textService.replace(input, target, replacement);

        // THEN all occurrences of the target should be replaced
        assertThat(result).isEqualTo("qux bar qux baz");
    }

    @Test
    void removeVowels_shouldStripAllVowelsRegardlessOfCase() {
        // GIVEN a string containing vowels in mixed case
        String input = "AbcEfgIJKlmO";

        // WHEN removeVowels is invoked
        String result = textService.removeVowels(input);

        // THEN only consonants should remain
        assertThat(result).isEqualTo("bcfgJKlm");
    }

    @Test
    void removeConsonants_shouldStripAllConsonantsRegardlessOfCase() {
        // GIVEN a string containing consonants in mixed case
        String input = "AbcEfgIJKlmO";

        // WHEN removeConsonants is invoked
        String result = textService.removeConsonants(input);

        // THEN only vowels should remain
        assertThat(result).isEqualTo("AeIO");
    }