package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    public void setUp() {
        // Reset mock state before each test to ensure independence
        Mockito.reset(textService);
    }

    @Test
    public void helloWorld_shouldReturnServiceGreeting() {
        // GIVEN
        Mockito.when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String response = textController.helloWorld();

        // THEN
        assertNotNull(response);
        assertEquals("Hello, World!", response);
        Mockito.verify(textService, Mockito.times(1)).helloworld();
    }

    @Test
    public void reverse_shouldReturnReversedString() {
        // GIVEN
        String input = "abcd";
        Mockito.when(textService.reverse(input)).thenReturn("dcba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("dcba", result);
        Mockito.verify(textService, Mockito.times(1)).reverse(input);
    }

    @Test
    public void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "hello";
        Mockito.when(textService.uppercase(input)).thenReturn("HELLO");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
        Mockito.verify(textService, Mockito.times(1)).uppercase(input);
    }

    @Test
    public void stats_shouldReturnMapFromService() {
        // GIVEN
        Map<String, Object> statsMap = new HashMap<>();
        statsMap.put("length", 5);
        statsMap.put("wordCount", 1);
        Mockito.when(textService.stats("hello")).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats("hello");

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(5, result.get("length"));
        Mockito.verify(textService, Mockito.times(1)).stats("hello");
    }

    @Test
    public void replace_shouldDelegateToServiceWithParams() {
        // GIVEN
        String input = "apple banana apple";
        String target = "apple";
        String replacement = "orange";
        String expected = "orange banana orange";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService, Mockito.times(1)).replace(input, target, replacement);
    }

    @Test
    public void removeVowels_shouldReturnStringWithoutVowels() {
        // GIVEN
        String input = "education";
        String expected = "dctn";
        Mockito.when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService, Mockito.times(1)).removeVowels(input);
    }

    @Test
    public void removeConsonants_shouldReturnStringWithoutConsonants() {
        // GIVEN
        String input = "education";
        String expected = "euaio";
        Mockito.when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
        Mockito.verify(textService, Mockito.times(1)).removeConsonants(input);
    }

    @Test
    public void countOccurrence_shouldReturnCountFromService() {
        // GIVEN
        String input = "cat dog cat cat";
        String keyword = "cat";
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(3);

        // WHEN
        int count = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(3, count);
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(input, keyword);
    }

    @Test
    public void jsonToYaml_shouldDelegateConversionToService() {
        // GIVEN
        String json = "{\"name\":\"Alice\"}";
        String yaml = "name: \"Alice\"\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("name"));
        assertEquals(yaml, result);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(json);
    }

    @Test
    public void jsonToXml_shouldDelegateConversionToService() {
        // GIVEN
        String json = "{\"name\":\"Bob\"}";
        String xml = "<ObjectNode><name>Bob</name></ObjectNode>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertNotNull(result);
        assertEquals(xml, result);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(json);
    }

    // Exception handling tests - controller should propagate runtime exceptions from service

    @Test
    public void reverse_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.reverse(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.reverse(null));
        Mockito.verify(textService, Mockito.times(1)).reverse(null);
    }

    @Test
    public void uppercase_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.uppercase(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.uppercase(null));
        Mockito.verify(textService, Mockito.times(1)).uppercase(null);
    }

    @Test
    public void stats_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.stats(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.stats(null));
        Mockito.verify(textService, Mockito.times(1)).stats(null);
    }

    @Test
    public void replace_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        String target = "a";
        String replacement = "b";
        Mockito.when(textService.replace(null, target, replacement)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.replace(target, replacement, null));
        Mockito.verify(textService, Mockito.times(1)).replace(null, target, replacement);
    }

    @Test
    public void countOccurrence_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        String keyword = "one";
        Mockito.when(textService.countOccurrence(null, keyword)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> textController.countOccurrence(keyword, null));
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(null, keyword);
    }

    @Test
    public void jsonToYaml_shouldPropagateRuntimeExceptionFromService() {
        // GIVEN
        String invalidJson = "{\"invalid";
        Mockito.when(textService.convertJsonToYaml(invalidJson)).thenThrow(new IllegalArgumentException("invalid json"));

        // WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> textController.jsonToYaml(invalidJson));
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(invalidJson);
    }

    @Test
    public void jsonToXml_shouldPropagateRuntimeExceptionFromService() {
        // GIVEN
        String invalidJson = "{\"invalid";
        Mockito.when(textService.convertJsonToXml(invalidJson)).thenThrow(new IllegalArgumentException("invalid json"));

        // WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> textController.jsonToXml(invalidJson));
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(invalidJson);
    }
}
