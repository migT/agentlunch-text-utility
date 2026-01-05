package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import java.util.*;

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

    // GIVEN: TextService returns "Hello, World!"
    // WHEN: helloWorld() is called
    // THEN: Should return "Hello, World!"
    @Test
    void helloWorld_shouldReturnHelloWorld() {
        when(textService.helloworld()).thenReturn("Hello, World!");

        String result = textController.helloWorld();

        assertThat(result).isEqualTo("Hello, World!");
        verify(textService, times(1)).helloworld();
    }

    // GIVEN: TextService returns reversed string
    // WHEN: reverse() is called with input
    // THEN: Should return reversed string
    @Test
    void reverse_shouldReturnReversedString() {
        String input = "abc";
        String expected = "cba";
        when(textService.reverse(input)).thenReturn(expected);

        String result = textController.reverse(input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    // GIVEN: TextService returns uppercase string
    // WHEN: uppercase() is called with input
    // THEN: Should return uppercase string
    @Test
    void uppercase_shouldReturnUppercaseString() {
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        String result = textController.uppercase(input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    // GIVEN: TextService returns stats map
    // WHEN: stats() is called with input
    // THEN: Should return stats map
    @Test
    void stats_shouldReturnStatsMap() {
        String input = "hello world";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", Collections.emptyList());
        when(textService.stats(input)).thenReturn(expected);

        Map<String, Object> result = textController.stats(input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }

    // GIVEN: TextService returns replaced string
    // WHEN: replace() is called with input, target, replacement
    // THEN: Should return replaced string
    @Test
    void replace_shouldReturnReplacedString() {
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        String result = textController.replace(target, replacement, input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    // GIVEN: TextService returns string with vowels removed
    // WHEN: removeVowels() is called with input
    // THEN: Should return string without vowels
    @Test
    void removeVowels_shouldReturnStringWithoutVowels() {
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        String result = textController.removeVowels(input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeVowels(input);
    }

    // GIVEN: TextService returns string with consonants removed
    // WHEN: removeConsonants() is called with input
    // THEN: Should return string without consonants
    @Test
    void removeConsonants_shouldReturnStringWithoutConsonants() {
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        String result = textController.removeConsonants(input);

        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeConsonants(input);
    }

    // GIVEN: TextService returns count of keyword occurrence
   // GIVEN: TextService returns count of keyword occurrence
// WHEN: countOccurrence() is called with input and keyword
// THEN: Should return correct count
@Test
void countOccurrence_shouldReturnKeywordCount() {
    String input = "foo bar foo baz foo";
    String keyword = "foo";
    int expected = 3;
    when(textService.countOccurrence(input, keyword)).thenReturn(expected);

    int result = textController.countOccurrence(keyword, input);

    assertThat(result).isEqualTo(expected);
    verify(textService, times(1)).countOccurrence(input, keyword);
}

// GIVEN: TextService returns YAML string from JSON
// WHEN: jsonToYaml() is called with valid JSON
// THEN: Should return YAML string
@Test
void jsonToYaml_shouldReturnYamlString() {
    String json = "{\"name\":\"John\",\"age\":30}";
    String expectedYaml = "name: \"John\"\nage: 30\n";
    when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

    String result = textController.jsonToYaml(json);

    assertThat(result).isEqualTo(expectedYaml);
    verify(textService, times(1)).convertJsonToYaml(json);
}

// GIVEN: TextService returns XML string from JSON
// WHEN: jsonToXml() is called with valid JSON
// THEN: Should return XML string
@Test
void jsonToXml_shouldReturnXmlString() {
    String json = "{\"name\":\"John\",\"age\":30}";
    String expectedXml = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
    when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

    String result = textController.jsonToXml(json);

    assertThat(result).isEqualTo(expectedXml);
    verify(textService, times(1)).convertJsonToXml(json);
}
