package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "hello, world!";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        // WHEN
        Map<String, Object> result = textService.stats(input);
        // THEN
        assertThat(result.get("length")).isEqualTo(31);
        assertThat((int) result.get("wordCount")).isEqualTo(6);
        assertThat((int) result.get("lineCount")).isEqualTo(1);
    }

    @Test
    public void testGetLength() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        int result = textService.getLength(input);
        // THEN
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void testGetSplitCount() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        String splitRegex = "\\s+";
        // WHEN
        int result = textService.getSplitCount(input, splitRegex);
        // THEN
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testGetRepeatedWords() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).containsExactly("Hello, World! : 2");
    }

    @Test
    public void testGetConsonantCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        int result = textService.getConsonantCount(input);
        // THEN
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void testGetVowelCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        int result = textService.getVowelCount(input);
        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertThat(result).isEqualTo("eoo, eeo!");
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";
        // WHEN
        int result = textService.countOccurrence(input, keyword);
        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml() throws JsonProcessingException {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testConvertJsonToXml() throws JsonProcessingException {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
    @Test
    public void testConvertJsonToXml() throws JsonProcessingException {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testGetRepeatedWords_EmptyInput() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetRepeatedWords_NullInput() {
        // GIVEN
        String input = null;
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).isEmpty();
    }
}
