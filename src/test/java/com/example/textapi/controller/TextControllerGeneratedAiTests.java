package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        Mockito.reset(textService);
    }

    @Test
    void helloWorld_returnsServiceMessage() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_returnsStatisticsMap() {
        // GIVEN
        String input = "test input";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 10);
        expected.put("wordCount", 2);
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_returnsReplacedString_andCallsServiceWithCorrectParams() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String expected = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        ArgumentCaptor<String> inputCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> targetCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> replacementCaptor = ArgumentCaptor.forClass(String.class);
        verify(textService, times(1)).replace(inputCaptor.capture(), targetCaptor.capture(), replacementCaptor.capture());
        assertThat(inputCaptor.getValue()).isEqualTo(input);
        assertThat(targetCaptor.getValue()).isEqualTo(target);
        assertThat(replacementCaptor.getValue()).isEqualTo(replacement);
    }

    @Test
    void removeVowels_returnsStringWithoutVowels() {
        // GIVEN
        String input = "aeiou";
        String expected = "";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_returnsStringWithoutConsonants() {
        // GIVEN
        String input = "bcdf";
        String expected = "";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        int expected = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_returnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_returnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void replace_withEmptyTarget_insertsReplacementBetweenCharacters() {
        // GIVEN
        String input = "abc";
        String target = "";
        String replacement = "-";
        String expected = "-a-b-c-";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void countOccurrence_keywordNotPresent_returnsZero() {
        // GIVEN
        String input = "hello world";
        String keyword = "test";
        int expected = 0;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }
}
