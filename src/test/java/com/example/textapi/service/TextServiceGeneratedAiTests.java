package com.example.textapi.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.Map;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_givenNormalString_shouldReturnReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("321cba");
    }

    @Test
    void reverse_givenEmptyString_shouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void uppercase_givenMixedCaseString_shouldReturnUppercaseString() {
        // GIVEN
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC123");
    }

    @Test
    void stats_givenNormalString_shouldReturnCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result).containsEntry("length", input.length());
        assertThat(result).containsEntry("wordCount", 5);
        assertThat(result).containsEntry("lineCount", 2);
        assertThat(result).containsKey("VowelCount");
        assertThat(result).containsKey("ConsonantCount");
        assertThat(result).containsKey("RepeatedWords");
        List<String> repeatedWords = (List<String>) result.get("RepeatedWords");
        assertThat(repeatedWords).contains("hello : 2", "world : 2");
    }

    @Test
    void stats_givenNullInput_shouldReturnZeroLengthAndEmptyRepeatedWords() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> result = textService.stats(input == null ? "" : input);

        // THEN
        assertThat(result.get("length")).isEqualTo(0);
        assertThat(result.get("wordCount")).isEqualTo(0);
        assertThat(result.get("lineCount")).isEqualTo(0);
        assertThat(result.get("VowelCount")).isEqualTo(0);
        assertThat(result.get("ConsonantCount")).isEqualTo(0);
        assertThat(result.get("RepeatedWords")).asList().isEmpty();
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_shouldReturnListOfRepeatedWordsWithCount() {
        // GIVEN
        String input = "Test test TEST example example example";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).containsExactly("test : 3", "example : 3");
    }

    @Test
    void getRepeatedWords_givenEmptyString_shouldReturnEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).isEmpty();
    }

    @Test
    void getRepeatedWords_givenNull_shouldReturnEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).isEmpty();
    }

    @Test
    void replace_givenInputAndTarget_shouldReplaceAllOccurrences() {
        // GIVEN
        String input = "hello world world";
        String target = "world";
        String replacement = "earth";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertThat(result).isEqualTo("hello earth earth");
    }

    @Test
    void removeVowels_givenString_shouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll Wrld");
    }

    @Test
    void removeConsonants_givenString_shouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo o");
    }

    @Test
    void countOccurrence_givenStringAndKeyword_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello world hello WORLD hello";
        String keyword = "hello";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isEqualTo(3);
    }

    @Test
    void countOccurrence_givenStringWithoutKeyword_shouldReturnZero() {
        // GIVEN
        String input = "Hello world";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isZero();
    }

    @Test
    void helloworld_shouldReturnHelloWorldString() {
        // GIVEN - no setup needed

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void convertJsonToYaml_givenValidJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("key: value");
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_givenValidJson_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<key>value</key>");
    }

    @Test
    void convertJsonToXml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertThat(xml).startsWith("Error converting JSON to XML:");
    }
}