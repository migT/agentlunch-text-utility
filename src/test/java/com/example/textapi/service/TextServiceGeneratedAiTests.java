package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
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
        String target = "World";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
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
        String keyword = "Java";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
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
    void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertThat(yaml).contains("name: \"John\"");
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertThat(xml).contains("<name>John</name>");
    }
}
