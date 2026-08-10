package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void helloWorld_returnsHelloWorldString() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN
        String input = "abcdef";
        when(textService.reverse(input)).thenReturn("fedcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void reverse_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "abcdef";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
    }

    @Test
    void uppercase_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new IllegalArgumentException("Uppercase error"));

        // WHEN & THEN
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
    }

    @Test
    void stats_returnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expectedStats = new HashMap<>();
        expectedStats.put("length", 17);
        expectedStats.put("wordCount", 3);
        expectedStats.put("lineCount", 2);
        expectedStats.put("VowelCount", 5);
        expectedStats.put("ConsonantCount", 8);
        expectedStats.put("RepeatedWords", Collections.singletonList("hello : 2"));
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
    }

    @Test
    void stats_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "Hello World\nHello";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
    }

    @Test
    void replace_returnsReplacedString() {
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
    void replace_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
    }

    @Test
    void removeVowels_removesVowelsFromString() {
        // GIVEN
        String input = "abcdef";
        when(textService.removeVowels(input)).thenReturn("bcdf");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("bcdf", result);
    }

    @Test
    void removeVowels_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "abcdef";
        when(textService.removeVowels(input)).thenThrow(new IllegalStateException("Remove vowels error"));

        // WHEN & THEN
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
    }

    @Test
    void removeConsonants_removesConsonantsFromString() {
        // GIVEN
        String input = "abcdef";
        when(textService.removeConsonants(input)).thenReturn("ae");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("ae", result);
    }

    @Test
    void removeConsonants_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "abcdef";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
    }

    @Test
    void countOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo baz foo";
        String keyword = "foo";
        when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, result);
    }

    @Test
    void countOccurrence_throwsException_whenServiceThrows() {
        // GIVEN
        String input = "foo bar foo baz foo";
        String keyword = "foo";
        when(textService.countOccurrence(input, keyword)).thenThrow(new IllegalArgumentException("Count occurrence error"));

        // WHEN & THEN
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
    }

    @Test
    void jsonToYaml_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expectedYaml = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, result);
    }

    @Test
    void jsonToYaml_throwsException_whenServiceThrows() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
    }

    @Test
    void jsonToXml_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expectedXml = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, result);
    }

    @Test
    void jsonToXml_throwsException_whenServiceThrows() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
    }
}
