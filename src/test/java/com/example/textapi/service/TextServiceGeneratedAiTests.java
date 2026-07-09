package com.example.textapi.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "Hello";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("olleH", result);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello again";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(6, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        assertTrue(((List<?>) stats.get("RepeatedWords")).contains("hello : 2"));
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "test test example example test";

        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);

        // THEN
        assertEquals(2, repeated.size());
        assertTrue(repeated.contains("test : 3"));
        assertTrue(repeated.contains("example : 2"));
    }

    @Test
    void testGetConsonantCount() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        int count = textService.getConsonantCount(input);

        // THEN
        assertEquals(7, count);
    }

    @Test
    void testGetVowelCount() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        int count = textService.getVowelCount(input);

        // THEN
        assertEquals(3, count);
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
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eoo", result);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello world hello world";
        String keyword = "world";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(2, count);
    }

    @Test
    void testHelloworld() {
        // GIVEN
        // No setup needed

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }
}
