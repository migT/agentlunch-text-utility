package com.example.textapi.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

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
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertNotNull(result);
        assertTrue(result.containsKey("length"));
        assertTrue(result.containsKey("wordCount"));
        assertTrue(result.containsKey("lineCount"));
        assertTrue(result.containsKey("VowelCount"));
        assertTrue(result.containsKey("ConsonantCount"));
        assertTrue(result.containsKey("RepeatedWords"));
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";

        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeated.stream().anyMatch(s -> s.contains("apple")));
        assertTrue(repeated.stream().anyMatch(s -> s.contains("banana")));
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
        String input = "Java is fun. Java is powerful.";
        String keyword = "Java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(2, count);
    }

    @Test
    void testHelloworld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_validJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name"));
        assertTrue(yaml.contains("John"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson() {
        // GIVEN
        String invalidJson = "{name:John}";

        // WHEN
        String yaml = textService.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_validJson() {
        // GIVEN
        String json = "{\"city\":\"Paris\"}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("city"));
        assertTrue(xml.contains("Paris"));
    }

    @Test
    void testConvertJsonToXml_invalidJson() {
        // GIVEN
        String invalidJson = "{city:Paris}";

        // WHEN
        String xml = textService.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
