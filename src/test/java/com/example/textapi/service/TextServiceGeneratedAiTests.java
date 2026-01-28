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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.textapi.utils.TextConversionUtil;
import org.springframework.stereotype.Service;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Service
public class TextService {

    public static final String HELLO_WORLD = "Hello, World!";
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

package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.textapi.utils.TextConversionUtil;
import org.springframework.stereotype.Service;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Service
public class TextServiceGeneratedAiTests {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private TextService textService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "hello, world!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello, World! This is a test.";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertThat(stats.get("length")).isEqualTo(31);
        assertThat(stats.get("wordCount")).isEqualTo(6);
        assertThat(stats.get("lineCount")).isEqualTo(1);
    }

    @Test
    public void testGetLength() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer length = textService.getLength(input);

        // THEN
        assertThat(length).isEqualTo(13);
    }

    @Test
    public void testGetSplitCount() {
        // GIVEN
        String input = "Hello, World!";
        String splitRegex = "\\s+";

        // WHEN
        Integer count = textService.getSplitCount(input, splitRegex);

        // THEN
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void testGetRepeatedWords() {
        // GIVEN
        String input = "Hello, World! Hello, World!";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).containsExactly("Hello, World! : 2");
    }

    @Test
    public void testGetConsonantCount() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer count = textService.getConsonantCount(input);

        // THEN
        assertThat(count).isEqualTo(9);
    }

    @Test
    public void testGetVowelCount() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer count = textService.getVowelCount(input);

        // THEN
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void testReplace() {
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
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("aeo, eeo!");
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "Hello, World!";
        String keyword = "World";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void testHelloworld() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotEmpty();
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotEmpty();
    }
}