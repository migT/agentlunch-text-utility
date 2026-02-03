package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

public class TextService {

    public int getLength(String input) {
        if (input == null) {
            return 0;
        }
        return input.length();
    }

    public int getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return length;
    }

    public int getConsonantCount(String input) {
        return input.replaceAll("(?i)[b-df-hj-np-tv-z]", "").length();
    }

    public int getVowelCount(String input) {
        return input.replaceAll("(?i)[^aeiou]", "").length();
    }
}

package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;
import java.util.Map;
import java.util.Collections;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String expectedOutput = "!,dlroW ,olleH";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsExpected() {
        // GIVEN
        String input = "hello, world!";
        String expectedOutput = "HELLO, WORLD!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void testStats_GivenString_WhenStatisticsComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! This is a test string.";
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("length", 36);
        expectedMap.put("wordCount", 6);
        expectedMap.put("lineCount", 1);
        expectedMap.put("VowelCount", 11);
        expectedMap.put("ConsonantCount", 15);
        expectedMap.put("RepeatedWords", Collections.emptyList());

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result).isEqualTo(expectedMap);
    }

    @Test
    public void testGetLength_GivenString_WhenLengthComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        int expectedLength = 13;

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(expectedLength);
    }

    @Test
    public void testGetSplitCount_GivenStringAndRegex_WhenSplitCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "\\s+";
        int expectedCount = 2;

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(expectedCount);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! Hello, again!";
        List<String> expectedList = new ArrayList<>();

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).isEqualTo(expectedList);
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        int expectedCount = 15;

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(expectedCount);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        int expectedCount = 11;

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(expectedCount);
    }

    @Test
    public void testReplace_GivenStringAndTarget_WhenReplaced_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";
        String expectedOutput = "Hello, Earth!";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsRemoved_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String expectedOutput = "Hll, Wrld!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsRemoved_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        String expectedOutput = "e,o,a,e,i,e";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void testCountOccurrence_GivenStringAndKeyword_WhenOccurrencesCounted_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! Hello again!";
        String keyword = "Hello";
        int expectedCount = 2;

        // WHEN
        int result = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(result).isEqualTo(expectedCount);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldReturned_ThenResultIsExpected() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }
}
