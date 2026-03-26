package com.example.textapi.service;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_givenNormalString_whenReverse_thenReturnsReversedString() {
        // GIVEN
        String input = "abc123";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("321cba");
    }

    @Test
    void reverse_givenEmptyString_whenReverse_thenReturnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void uppercase_givenMixedCaseString_whenUppercase_thenReturnsUppercaseString() {
        // GIVEN
        String input = "AbC123";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC123");
    }

    @Test
    void stats_givenStringWithMultipleWordsAndLines_whenStats_thenReturnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertThat(stats).containsEntry("length", input.length());
        assertThat(stats).containsEntry("wordCount", 5);
        assertThat(stats).containsEntry("lineCount", 2);
        assertThat(stats).containsKey("VowelCount");
        assertThat(stats).containsKey("ConsonantCount");
        assertThat(stats).containsKey("RepeatedWords");
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertThat(repeatedWords).contains("hello : 2", "world : 2");
    }

    @Test
    void stats_givenNullInput_whenStats_thenReturnsZeroAndEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertThat(stats.get("length")).isEqualTo(0);
        assertThat(stats.get("wordCount")).isEqualTo(0);
        assertThat(stats.get("lineCount")).isEqualTo(0);
        assertThat(stats.get("VowelCount")).isEqualTo(0);
        assertThat(stats.get("ConsonantCount")).isEqualTo(0);
        assertThat(stats.get("RepeatedWords")).isInstanceOf(List.class);
        assertThat((List<?>) stats.get("RepeatedWords")).isEmpty();
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_whenGetRepeatedWords_thenReturnsRepeatedWordsWithCount() {
        // GIVEN
        String input = "Test test TEST example example test";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).containsExactly("test : 3", "example : 2");
    }

    @Test
    void getRepeatedWords_givenEmptyString_whenGetRepeatedWords_thenReturnsEmptyList() {
        // GIVEN
        String input = "";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).isEmpty();
    }

    @Test
    void getRepeatedWords_givenNullInput_whenGetRepeatedWords_thenReturnsEmptyList() {
        // GIVEN
        String input = null;

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertThat(repeatedWords).isEmpty();
    }

    @Test
    void removeVowels_givenStringWithVowels_whenRemoveVowels_thenReturnsStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll Wrld");
    }

    @Test
    void removeConsonants_givenStringWithConsonants_whenRemoveConsonants_thenReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo o");
    }

    @Test
    void replace_givenStringWithTarget_whenReplace_thenReturnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertThat(result).isEqualTo("hello there");
    }

    @Test
    void countOccurrence_givenStringWithKeyword_whenCountOccurrence_thenReturnsCorrectCount() {
        // GIVEN
        String input = "test Test testing test";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isEqualTo(3);
    }

    @Test
    void countOccurrence_givenStringWithoutKeyword_whenCountOccurrence_thenReturnsZero() {
        // GIVEN
        String input = "hello world";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(count).isZero();
    }

    @Test
    void helloworld_whenCalled_thenReturnsHelloWorldString() {
        // GIVEN no special setup

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void convertJsonToYaml_givenValidJson_whenConvertJsonToYaml_thenReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotBlank();
        assertThat(yaml).contains("key");
        assertThat(yaml).contains("value");
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_givenValidJson_whenConvertJsonToXml_thenReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<key>value</key>");
    }

    @Test
    void convertJsonToXml_givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertThat(xml).startsWith("Error converting JSON to XML:");
    }
}