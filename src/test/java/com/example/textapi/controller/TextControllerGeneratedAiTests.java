package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        Mockito.reset(textService);
    }

    @Test
    void helloWorld_shouldReturnHelloWorld() {
        // GIVEN
        String expected = "Hello, World!";
        Mockito.when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).helloworld();
    }

    @Test
    void reverse_shouldReturnReversedString() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        Mockito.when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).reverse(input);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "test";
        String expected = "TEST";
        Mockito.when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).uppercase(input);
    }

    @Test
    void stats_shouldReturnStatisticsMap() {
        // GIVEN
        String input = "sample text";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 4);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", Collections.emptyList());
        Mockito.when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).stats(input);
    }

    @Test
    void replace_shouldReturnReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String expected = "hello there";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        Mockito.when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        Mockito.when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_shouldReturnKeywordCount() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        int expected = 3;
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<key>value</key>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(json);
    }
}
