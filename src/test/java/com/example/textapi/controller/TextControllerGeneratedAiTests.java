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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    public void setUp() {
        // Reset mocks to ensure no state leaks between tests
        Mockito.reset(textService);
    }

    @Test
    public void testHelloWorldReturnsExpectedGreeting() {
        // GIVEN
        String expected = "Hello, World!";
        Mockito.when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String actual = textController.helloWorld();

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).helloworld();
    }

    @Test
    public void testReverseDelegatesToServiceAndReturnsReversedString() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        Mockito.when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String actual = textController.reverse(input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).reverse(input);
    }

    @Test
    public void testUppercaseDelegatesToServiceAndReturnsUppercase() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";
        Mockito.when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String actual = textController.uppercase(input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).uppercase(input);
    }

    @Test
    public void testStatsReturnsMapFromServiceContainingExpectedEntries() {
        // GIVEN
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        Mockito.when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> actual = textController.stats(input);

        // THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).stats(input);
    }

    @Test
    public void testReplacePassesParametersToServiceAndReturnsResult() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String actual = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).replace(input, target, replacement);
    }

    @Test
    public void testRemoveVowelsDelegatesToServiceAndReturnsResult() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        Mockito.when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeVowels(input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).removeVowels(input);
    }

    @Test
    public void testRemoveConsonantsDelegatesToServiceAndReturnsResult() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        Mockito.when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String actual = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).removeConsonants(input);
    }

    @Test
    public void testCountOccurrenceDelegatesToServiceAndReturnsCount() {
        // GIVEN
        String input = "one two one three one";
        String keyword = "one";
        int expected = 3;
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int actual = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, actual);
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(input, keyword);
    }

    @Test
    public void testJsonToYamlDelegatesToServiceAndReturnsYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: \"value\"\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(expectedYaml);

        // WHEN
        String actual = textController.jsonToYaml(json);

        // THEN
        assertEquals(expectedYaml, actual);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(json);
    }

    @Test
    public void testJsonToXmlDelegatesToServiceAndReturnsXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<ObjectNode><key>value</key></ObjectNode>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(expectedXml);

        // WHEN
        String actual = textController.jsonToXml(json);

        // THEN
        assertEquals(expectedXml, actual);
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(json);
    }

    @Test
    public void testJsonToYamlPropagatesExceptionFromService() {
        // GIVEN
        String badJson = "{ invalid ";
        Mockito.when(textService.convertJsonToYaml(badJson)).thenThrow(new IllegalArgumentException("invalid json"));

        // WHEN / THEN
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> textController.jsonToYaml(badJson));
        assertEquals("invalid json", ex.getMessage());
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(badJson);
    }

    @Test
    public void testJsonToXmlPropagatesExceptionFromService() {
        // GIVEN
        String badJson = "{ invalid ";
        Mockito.when(textService.convertJsonToXml(badJson)).thenThrow(new RuntimeException("conversion failed"));

        // WHEN / THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(badJson));
        assertEquals("conversion failed", ex.getMessage());
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(badJson);
    }
}
