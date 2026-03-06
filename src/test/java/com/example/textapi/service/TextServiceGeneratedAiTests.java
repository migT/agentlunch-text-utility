package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("cba", result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertTrue(stats.containsKey("length"));
        assertTrue(stats.containsKey("wordCount"));
        assertTrue(stats.containsKey("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
        assertEquals(input.length(), stats.get("length"));
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.size() > 0);
        assertTrue(repeated.stream().anyMatch(s -> s.contains("apple")));
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
        assertEquals("Hello Java", result);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eo", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Java is great. I love Java!";
        String keyword = "Java";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(2, count);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYamlSuccess() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.contains("key"));
    }

    @Test
    void testConvertJsonToXmlSuccess() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.contains("key"));
    }

    @Test
    void testConvertJsonToYamlErrorHandling() {
        // GIVEN
        String json = "invalid-json";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result.contains("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlErrorHandling() {
        // GIVEN
        String json = "invalid-json";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result.contains("Error converting JSON to XML"));
    }

    @Test
    void testConvertJsonToYamlNullInput() {
        // GIVEN
        String json = null;
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(result == null || result.contains("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlNullInput() {
        // GIVEN
        String json = null;
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertTrue(result == null || result.contains("Error converting JSON to XML"));
    }
}
