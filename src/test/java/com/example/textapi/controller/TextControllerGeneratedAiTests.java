package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN
        textService = mock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld_ShouldReturnHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

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
        when(textService.reverse(input)).thenReturn("edcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("edcba", result);
    }

    @Test
    void reverse_ShouldReturnEmptyString_WhenInputIsEmpty() {
        // GIVEN
        String input = "";
        when(textService.reverse(input)).thenReturn("");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_ShouldReturnUppercaseString() {
        // GIVEN
        String input = "abcDef";
        when(textService.uppercase(input)).thenReturn("ABCDEF");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABCDEF", result);
    }

    @Test
    void uppercase_ShouldReturnEmptyString_WhenInputIsEmpty() {
        // GIVEN
        String input = "";
        when(textService.uppercase(input)).thenReturn("");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void stats_ShouldReturnCorrectStatsMap() {
        // GIVEN
        String input = "Hello hello\nWorld world world";
        Map<String, Object> expectedStats = Map.of(
                "length", input.length(),
                "wordCount", 5,
                "lineCount", 2,
                "VowelCount", 7,
                "ConsonantCount", 13,
                "RepeatedWords", List.of("hello : 2", "world : 3")
        );
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> stats = textController.stats(input);

        // THEN
        assertNotNull(stats);
        assertEquals(input.length(), stats.get("length"));
        assertEquals(5, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.containsKey("VowelCount"));
        assertTrue(stats.containsKey("ConsonantCount"));
        assertTrue(stats.containsKey("RepeatedWords"));
        List<?> repeatedWords = (List<?>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.toString().startsWith("world")));
    }

    @Test
    void replace_ShouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        when(textService.replace(input, target, replacement)).thenReturn("baz bar baz");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("baz bar baz", result);
    }

    @Test
    void replace_ShouldReturnOriginalString_WhenTargetNotFound() {
        // GIVEN
        String input = "foo bar foo";
        String target = "xyz";
        String replacement = "baz";
        when(textService.replace(input, target, replacement)).thenReturn(input);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(input, result);
    }

    @Test
    void removeVowels_ShouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";
        when(textService.removeVowels(input)).thenReturn("Hll Wrld");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeVowels_ShouldReturnEmptyString_WhenInputIsEmpty() {
        // GIVEN
        String input = "";
        when(textService.removeVowels(input)).thenReturn("");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void removeConsonants_ShouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";
        when(textService.removeConsonants(input)).thenReturn("eo o");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void removeConsonants_ShouldReturnEmptyString_WhenInputIsEmpty() {
        // GIVEN
        String input = "";
        when(textService.removeConsonants(input)).thenReturn("");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCount() {
        // GIVEN
        String input = "foo bar foo Foo fOo";
        String keyword = "foo";
        when(textService.countOccurrence(input, keyword)).thenReturn(4);

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(4, count);
    }

    @Test
    void countOccurrence_ShouldReturnZero_WhenKeywordNotFound() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "baz";
        when(textService.countOccurrence(input, keyword)).thenReturn(0);

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void jsonToYaml_ShouldConvertValidJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String yaml = textController.jsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("key: value"));
    }

    @Test
    void jsonToYaml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{key: value}";
        String errorMessage = "Error converting JSON to YAML: ...";
        when(textService.convertJsonToYaml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String yaml = textController.jsonToYaml(invalidJson);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void jsonToXml_ShouldConvertValidJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String xml = textController.jsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<key>value</key>"));
    }

    @Test
    void jsonToXml_ShouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{key: value}";
        String errorMessage = "Error converting JSON to XML: ...";
        when(textService.convertJsonToXml(invalidJson)).thenReturn(errorMessage);

        // WHEN
        String xml = textController.jsonToXml(invalidJson);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
