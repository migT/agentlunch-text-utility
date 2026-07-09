package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;

import com.example.textapi.service.TextService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
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
    void reverse_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.reverse(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(null));
        verify(textService, times(1)).reverse(null);
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
    void uppercase_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.uppercase(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.uppercase(null));
        verify(textService, times(1)).uppercase(null);
    }

    @Test
    void stats_returnsStatisticsMap() {
        // GIVEN
        String input = "test input";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 10);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 4);
        expected.put("ConsonantCount", 6);
        expected.put("RepeatedWords", java.util.Collections.emptyList());
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void stats_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.stats(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.stats(null));
        verify(textService, times(1)).stats(null);
    }

    @Test
    void replace_returnsReplacedString() {
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
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void replace_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.replace(null, "a", "b")).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.replace("a", "b", null));
        verify(textService, times(1)).replace(null, "a", "b");
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
    void removeVowels_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.removeVowels(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.removeVowels(null));
        verify(textService, times(1)).removeVowels(null);
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
    void removeConsonants_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.removeConsonants(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.removeConsonants(null));
        verify(textService, times(1)).removeConsonants(null);
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
    void countOccurrence_throwsNullPointerException_whenInputNull() {
        // GIVEN
        when(textService.countOccurrence(null, "test")).thenThrow(new NullPointerException("input is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.countOccurrence("test", null));
        verify(textService, times(1)).countOccurrence(null, "test");
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
    void jsonToYaml_throwsNullPointerException_whenJsonNull() {
        // GIVEN
        when(textService.convertJsonToYaml(null)).thenThrow(new NullPointerException("json is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.jsonToYaml(null));
        verify(textService, times(1)).convertJsonToYaml(null);
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
    void jsonToXml_throwsNullPointerException_whenJsonNull() {
        // GIVEN
        when(textService.convertJsonToXml(null)).thenThrow(new NullPointerException("json is null"));

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.jsonToXml(null));
        verify(textService, times(1)).convertJsonToXml(null);
    }
}
