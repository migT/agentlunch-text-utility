package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        Mockito.when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertNotNull(result);
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abcde";
        Mockito.when(textService.reverse(input)).thenReturn("edcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertNotNull(result);
        assertEquals("edcba", result);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abcde";
        Mockito.when(textService.uppercase(input)).thenReturn("ABCDE");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertNotNull(result);
        assertEquals("ABCDE", result);
    }

    @Test
    void stats_ShouldReturnCorrectStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 17);
        expectedStats.put("wordCount", 3);
        expectedStats.put("lineCount", 2);
        expectedStats.put("VowelCount", 5);
        expectedStats.put("ConsonantCount", 7);
        expectedStats.put("RepeatedWords", Arrays.asList("hello : 2"));
        Mockito.when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> stats = textController.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(17, stats.get("length"));
        assertEquals(3, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(5, stats.get("VowelCount"));
        assertEquals(7, stats.get("ConsonantCount"));
        assertTrue(stats.get("RepeatedWords") instanceof List);
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("hello")));
    }

    @Test
    void replace_ShouldReturnStringWithReplacements() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn("baz bar baz");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertNotNull(result);
        assertEquals("baz bar baz", result);
    }

    @Test
    void removeVowels_ShouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "Hello World";
        Mockito.when(textService.removeVowels(input)).thenReturn("Hll Wrld");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertNotNull(result);
        assertFalse(result.matches(".*[aeiouAEIOU].*"));
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_ShouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "Hello World";
        Mockito.when(textService.removeConsonants(input)).thenReturn("eo o");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertNotNull(result);
        assertFalse(result.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*"));
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "foo bar foo Foo";
        String keyword = "foo";
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void jsonToYaml_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String yaml = "name: John\nage: 30\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("name: John"));
        assertTrue(result.contains("age: 30"));
    }

    @Test
    void jsonToYaml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{name:\"John\"";
        String errorMessage = "Error converting JSON to YAML: some error";
        Mockito.when(textService.convertJsonToYaml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void jsonToXml_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String xml = "<name>John</name><age>30</age>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<name>John</name>"));
        assertTrue(result.contains("<age>30</age>"));
    }

    @Test
    void jsonToXml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{name:\"John\"";
        String errorMessage = "Error converting JSON to XML: some error";
        Mockito.when(textService.convertJsonToXml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String result = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }
}
