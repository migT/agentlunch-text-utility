package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = mock(TextService.class);
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        Mockito.when(textService.reverse(input)).thenReturn("dlroW olleH");

        // THEN
        assertThat(textService.reverse(input)).isEqualTo("dlroW olleH");
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsCorrect() {
        // GIVEN
        String input = "hello world";

        // WHEN
        Mockito.when(textService.uppercase(input)).thenReturn("HELLO WORLD");

        // THEN
        assertThat(textService.uppercase(input)).isEqualTo("HELLO WORLD");
    }

    @Test
    public void testStats_GivenString_WhenStatisticsCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.stats(input)).thenReturn(new HashMap<>());

        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(31);
        assertThat((Integer) result.get("wordCount")).isEqualTo(6);
        assertThat((Integer) result.get("lineCount")).isEqualTo(1);
        assertThat((Integer) result.get("VowelCount")).isEqualTo(11);
        assertThat((Integer) result.get("ConsonantCount")).isEqualTo(20);
    }

    @Test
    public void testGetLength_GivenNullString_WhenLengthCalculated_ThenResultIsZero() {
        // GIVEN
        String input = null;

        // WHEN
        Mockito.when(textService.getLength(input)).thenReturn(Integer.valueOf(0));

        // THEN
        assertThat(textService.getLength(input)).isEqualTo(0);
    }

    @Test
    public void testGetSplitCount_GivenString_SplitBySpaces_WhenCountCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.getSplitCount(input, "\\s+")).thenReturn(Integer.valueOf(6));

        // THEN
        assertThat(textService.getSplitCount(input, "\\s+")).isEqualTo(6);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsFound_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.getRepeatedWords(input)).thenReturn(new ArrayList<>());

        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("this : 1", "is : 2");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantsCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.getConsonantCount(input)).thenReturn(Integer.valueOf(20));

        // THEN
        assertThat(textService.getConsonantCount(input)).isEqualTo(20);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelsCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.getVowelCount(input)).thenReturn(Integer.valueOf(11));

        // THEN
        assertThat(textService.getVowelCount(input)).isEqualTo(11);
    }

    @Test
    public void testReplace_GivenString_TargetReplacement_WhenReplaced_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";
        String target = "World";
        String replacement = "Universe";

        // WHEN
        Mockito.when(textService.replace(input, target, replacement)).thenReturn("Hello Universe, this is a test string");

        // THEN
        assertThat(textService.replace(input, target, replacement)).isEqualTo("Hello Universe, this is a test string");
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.removeVowels(input)).thenReturn("Hll Wrld, ths s  tst strng");

        // THEN
        assertThat(textService.removeVowels(input)).isEqualTo("Hll Wrld, ths s  tst strng");
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";

        // WHEN
        Mockito.when(textService.removeConsonants(input)).thenReturn("aeo a eot");

        // THEN
        assertThat(textService.removeConsonants(input)).isEqualTo("aeo a eot");
    }

    @Test
    public void testCountOccurrence_GivenString_Target_WhenOccurrencesCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello World, this is a test string";
        String target = "is";

        // WHEN
        Mockito.when(textService.countOccurrence(input, target)).thenReturn(2);

        // THEN
        assertThat(textService.countOccurrence(input, target)).isEqualTo(2);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldReturned_ThenResultIsCorrect() {
        // GIVEN

        // WHEN
        Mockito.when(textService.helloworld()).thenReturn("Hello, World!");

        // THEN
        assertThat(textService.helloworld()).isEqualTo("Hello, World!");
    }
}
