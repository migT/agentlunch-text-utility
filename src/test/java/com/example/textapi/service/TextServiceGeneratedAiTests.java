package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import java.util.List;

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
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsCorrect() {
        // GIVEN
        String input = "hello, world!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenString_WhenStatisticsCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(31);
        assertThat((Integer) result.get("wordCount")).isEqualTo(6);
        assertThat((Integer) result.get("lineCount")).isEqualTo(1);
        assertThat((Integer) result.get("VowelCount")).isEqualTo(10);
        assertThat((Integer) result.get("ConsonantCount")).isEqualTo(14);
    }

    @Test
    public void testGetLength_GivenNullString_WhenLengthCalculated_ThenResultIsZero() {
        // GIVEN
        String input = null;

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetSplitCount_GivenStringAndRegex_WhenSplitCountCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsFound_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! Hello, World!";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("Hello : 2", "World : 2");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testReplace_GivenStringAndTarget_WhenReplaced_ThenResultIsCorrect() {
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
        assertThat(result).isEqualTo("aeo, a!");
    }

    @Test
    public void testCountOccurrence_GivenStringAndKeyword_WhenOccurrencesCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";

        // WHEN
        int result = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldReturned_ThenResultIsCorrect() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml_GivenJsonString_WhenConvertedToJson_ThenResultIsCorrect() {
        // GIVEN
        String json = "{\"key\": \"value\"}";

        // WHEN
        String result = textService.convertJsonToYaml(json);

        // THEN
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testConvertJsonToXml_GivenJsonString_WhenConvertedToJson_ThenResultIsCorrect() {
        // GIVEN
        String json = "{\"key\": \"value\"}";

        // WHEN
        String result = textService.convertJsonToXml(json);

        // THEN
        assertThat(result).isNotEmpty();
    }
}
