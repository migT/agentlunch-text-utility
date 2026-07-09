package com.example.textapi.service;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertThat(result).isEqualTo("dcba");
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertThat(result).isEqualTo("HELLO");
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertThat(stats).containsKeys("length", "wordCount", "lineCount", "VowelCount", "ConsonantCount", "RepeatedWords");
        assertThat((Integer) stats.get("length")).isEqualTo(input.length());
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertThat(repeated).isNotEmpty();
        assertThat(repeated).anyMatch(s -> s.contains("apple"));
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.replace(input, "World", "Java");
        // THEN
        assertThat(result).isEqualTo("Hello Java");
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertThat(result).isEqualTo("Hll");
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertThat(result).isEqualTo("eo");
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. I love Java programming.";
        // WHEN
        int count = textService.countOccurrence(input, "Java");
        // THEN
        assertThat(count).isEqualTo(2);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void testConvertJsonToYamlSuccess() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        try (MockedStatic<TextConversionUtil> mocked = Mockito.mockStatic(TextConversionUtil.class)) {
            mocked.when(() -> TextConversionUtil.convertJsonToYaml(anyString())).thenReturn("key: value");
            // WHEN
            String result = textService.convertJsonToYaml(json);
            // THEN
            assertThat(result).isEqualTo("key: value");
        }
    }

    @Test
    void testConvertJsonToXmlSuccess() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        try (MockedStatic<TextConversionUtil> mocked = Mockito.mockStatic(TextConversionUtil.class)) {
            mocked.when(() -> TextConversionUtil.convertJsonToXml(anyString())).thenReturn("<key>value</key>");
            // WHEN
            String result = textService.convertJsonToXml(json);
            // THEN
            assertThat(result).isEqualTo("<key>value</key>");
        }
    }
}
