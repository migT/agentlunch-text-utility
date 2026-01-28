package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

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
        assertThat(result.get("length")).isEqualTo(32);
        assertThat((Integer) result.get("wordCount")).isEqualTo(6);
        assertThat((Integer) result.get("lineCount")).isEqualTo(1);
        assertThat((Integer) result.get("VowelCount")).isEqualTo(11);
        assertThat((Integer) result.get("ConsonantCount")).isEqualTo(14);
    }

    @Test
    public void testGetLength_GivenNullString_WhenLengthComputed_ThenResultIsExpected() {
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
        String input = "Hello, World!";
        String regex = "\\s+";
        // WHEN
        Integer result = textService.getSplitCount(input, regex);
        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).containsExactly("Hello : 2", "World : 2");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer result = textService.getConsonantCount(input);
        // THEN
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountComputed_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer result = textService.getVowelCount(input);
        // THEN
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void testReplace_GivenStringAndTargetReplacement_WhenReplaced_ThenResultIsExpected() {
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
        assertThat(result).isEqualTo("aeo, aei!");
    }

    @Test
    public void testCountOccurrence_GivenStringAndKeyword_WhenOccurrencesCounted_ThenResultIsExpected() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";
        // WHEN
        int result = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(2, result);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldReturned_ThenResultIsExpected() {
        // GIVEN
        // No input needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml_GivenJsonString_WhenConvertedToJson_ThenResultIsExpected() {
        // GIVEN
        String json = "{\"key\": \"value\"}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertThat(result).isNotNull();
    }

    @Test
    public void testConvertJsonToXml_GivenJsonString_WhenConvertedToJson_ThenResultIsExpected() {
        // GIVEN
        String json = "{\"key\": \"value\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertThat(result).isNotNull();
    }
}

public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    public Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    public Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    public Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    public Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}
