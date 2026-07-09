package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        String input = "abc";
        String result = textService.reverse(input);
        assertEquals("cba", result);
    }

    @Test
    void testUppercase() {
        String input = "hello";
        String result = textService.uppercase(input);
        assertEquals("HELLO", result);
    }

    @Test
    void testStats() {
        String input = "Hello world\nHello again";
        Map<String, Object> result = textService.stats(input);
        assertTrue(result.containsKey("length"));
        assertTrue(result.containsKey("wordCount"));
        assertTrue(result.containsKey("lineCount"));
        assertTrue(result.containsKey("VowelCount"));
        assertTrue(result.containsKey("ConsonantCount"));
        assertTrue(result.containsKey("RepeatedWords"));
    }

    @Test
    void testGetRepeatedWords() {
        String input = "apple banana apple orange banana apple";
        List<String> result = textService.getRepeatedWords(input);
        assertTrue(result.stream().anyMatch(s -> s.contains("apple")));
    }

    @Test
    void testReplace() {
        String input = "Hello World";
        String result = textService.replace(input, "World", "Java");
        assertEquals("Hello Java", result);
    }

    @Test
    void testRemoveVowels() {
        String input = "Hello";
        String result = textService.removeVowels(input);
        assertEquals("Hll", result);
    }

    @Test
    void testRemoveConsonants() {
        String input = "Hello";
        String result = textService.removeConsonants(input);
        assertEquals("eo", result);
    }

    @Test
    void testCountOccurrence() {
        String input = "Java is great. I love Java programming.";
        int count = textService.countOccurrence(input, "Java");
        assertEquals(2, count);
    }

    @Test
    void testHelloWorld() {
        String result = textService.helloworld();
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYamlSuccess() {
        String json = "{\"key\":\"value\"}";
        String result = textService.convertJsonToYaml(json);
        assertTrue(result.contains("key"));
    }

    @Test
    void testConvertJsonToXmlSuccess() {
        String json = "{\"key\":\"value\"}";
        String result = textService.convertJsonToXml(json);
        assertTrue(result.contains("key"));
    }

    @Test
    void testConvertJsonToYamlError() {
        String json = "invalid json";
        String result = textService.convertJsonToYaml(json);
        assertTrue(result.contains("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlError() {
        String json = "invalid json";
        String result = textService.convertJsonToXml(json);
        assertTrue(result.contains("Error converting JSON to XML"));
    }

    @Test
    void testConvertJsonToYamlNullInput() {
        String json = null;
        String result = textService.convertJsonToYaml(json);
        assertTrue(result.contains("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXmlNullInput() {
        String json = null;
        String result = textService.convertJsonToXml(json);
        assertTrue(result.contains("Error converting JSON to XML"));
    }
}
