package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import java.util.Map;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.reset;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void helloWorld_shouldReturnHelloWorld() {
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
    void reverse_shouldReturnReversedString() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "Hello";
        String expected = "HELLO";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void stats_shouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> mockStats = Map.of(
                "length", 17,
                "wordCount", 3,
                "lineCount", 2,
                "VowelCount", 6,
                "ConsonantCount", 9,
                "RepeatedWords", List.of("hello : 2")
        );
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).isEqualTo(mockStats);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void replace_shouldReturnStringWithReplacements() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";
        String expected = "Hll Wrld";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";
        String expected = "eo o";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void countOccurrence_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Test test TEST";
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
    void jsonToYaml_shouldReturnYamlString() {
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
    void jsonToXml_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<key>value</key>\n";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    // Exception handling tests

    @Test
    void reverse_whenInputNull_shouldThrowNullPointerException() {
        // GIVEN
        when(textService.reverse(null)).thenThrow(new NullPointerException());

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(null));
        verify(textService, times(1)).reverse(null);
    }

    @Test
    void uppercase_whenInputNull_shouldThrowNullPointerException() {
        // GIVEN
        when(textService.uppercase(null)).thenThrow(new NullPointerException());

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.uppercase(null));
        verify(textService, times(1)).uppercase(null);
    }

    @Test
    void replace_whenTargetNull_shouldThrowNullPointerException() {
        // GIVEN
        String input = "sample";
        String replacement = "test";
        when(textService.replace(input, null, replacement)).thenThrow(new NullPointerException());

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.replace(null, replacement, input));
        verify(textService, times(1)).replace(input, null, replacement);
    }

    @Test
    void replace_whenReplacementNull_shouldThrowNullPointerException() {
        // GIVEN
        String input = "sample";
        String target = "sam";
        when(textService.replace(input, target, null)).thenThrow(new NullPointerException());

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.replace(target, null, input));
        verify(textService, times(1)).replace(input, target, null);
    }

    @Test
    void replace_whenInputNull_shouldThrowNullPointerException() {
        // GIVEN
        String target = "sam";
        String replacement = "test";
        when(textService.replace(null, target, replacement)).thenThrow(new NullPointerException());

        // WHEN & THEN
        assertThrows(NullPointerException.class, () -> textController.replace(target, replacement, null));
        verify(textService, times(1)).replace(null, target, replacement);
    }
