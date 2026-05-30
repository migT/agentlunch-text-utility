package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = new TextService();
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_returnsHelloWorldString() {
        // GIVEN
        // No additional setup needed

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo("cba");
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC");
    }

    @Test
    void stats_returnsCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello";

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).containsEntry("length", 17)
                          .containsEntry("wordCount", 3)
                          .containsEntry("lineCount", 2)
                          .containsEntry("VowelCount", 5)
                          .containsEntry("ConsonantCount", 10)
                          .containsEntry("RepeatedWords", List.of("hello : 2"));
    }

    @Test
    void replace_substitutesTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo("hello there");
    }

    @Test
    void replace_noTargetLeavesInputUnchanged() {
        // GIVEN
        String input = "hello";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void removeVowels_removesAllVowels() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("hll");
    }

    @Test
    void removeConsonants_removesAllConsonants() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo");
    }

    @Test
    void countOccurrence_countsKeywordOccurrencesCaseInsensitive() {
        // GIVEN
        String input = "Hello world hello HeLLo";
        String keyword = "hello";

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    void jsonToYaml_convertsJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).contains("key: value");
    }

    @Test
    void jsonToXml_convertsJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).contains("<key>value</key>");
    }
}
