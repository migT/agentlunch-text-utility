package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;

import com.example.textapi.service.TextService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    private TextController controller;

    @BeforeEach
    public void setUp() {
        // Reset mock state before each test to ensure independence
        Mockito.reset(textService);
        controller = new TextController(textService);
    }

    @Test
    public void helloWorld_shouldReturnServiceValue() {
        // GIVEN
        String expected = "Hello from service";
        Mockito.when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String actual = controller.helloWorld();

        // THEN
        assertEquals(expected, actual, "Controller should return the value provided by the service");
        Mockito.verify(textService, Mockito.times(1)).helloworld();
    }

    @Test
    public void reverse_shouldDelegateToServiceAndReturnReversedString() {
        // GIVEN
        String input = "abc123";
        String reversed = "321cba";
        Mockito.when(textService.reverse(input)).thenReturn(reversed);

        // WHEN
        String result = controller.reverse(input);

        // THEN
        assertEquals(reversed, result, "Controller should return reversed string from service");
        Mockito.verify(textService, Mockito.times(1)).reverse(input);
    }

    @Test
    public void uppercase_shouldDelegateToServiceAndReturnUppercase() {
        // GIVEN
        String input = "hello";
        String upper = "HELLO";
        Mockito.when(textService.uppercase(input)).thenReturn(upper);

        // WHEN
        String result = controller.uppercase(input);

        // THEN
        assertEquals(upper, result, "Controller should return uppercase string from service");
        Mockito.verify(textService, Mockito.times(1)).uppercase(input);
    }

    @Test
    public void stats_shouldReturnMapFromService() {
        // GIVEN
        String input = "one two two\nthree";
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("length", 20);
        expectedMap.put("wordCount", 4);
        Mockito.when(textService.stats(input)).thenReturn(expectedMap);

        // WHEN
        Map<String, Object> result = controller.stats(input);

        // THEN
        assertNotNull(result, "Result map should not be null");
        assertEquals(expectedMap, result, "Controller should return the exact map provided by service");
        Mockito.verify(textService, Mockito.times(1)).stats(input);
    }

    @Test
    public void replace_shouldPassParametersInCorrectOrderAndReturnResult() {
        // GIVEN
        String input = "aabbcc";
        String target = "bb";
        String replacement = "YY";
        String expected = "aaYYcc";
        Mockito.when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = controller.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result, "Controller should return replaced string from service");
        Mockito.verify(textService, Mockito.times(1)).replace(input, target, replacement);
    }

    @Test
    public void removeVowels_shouldDelegateAndReturnResult() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        Mockito.when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = controller.removeVowels(input);

        // THEN
        assertEquals(expected, result, "Controller should return string with vowels removed as provided by service");
        Mockito.verify(textService, Mockito.times(1)).removeVowels(input);
    }

    @Test
    public void removeConsonants_shouldDelegateAndReturnResult() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        Mockito.when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = controller.removeConsonants(input);

        // THEN
        assertEquals(expected, result, "Controller should return string with consonants removed as provided by service");
        Mockito.verify(textService, Mockito.times(1)).removeConsonants(input);
    }

    @Test
    public void countOccurrence_shouldDelegateWithCorrectArgumentOrder() {
        // GIVEN
        String input = "one two one three one";
        String keyword = "one";
        int expectedCount = 3;
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(expectedCount);

        // WHEN
        int result = controller.countOccurrence(keyword, input);

        // THEN
        assertEquals(expectedCount, result, "Controller should return the count provided by the service");
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(input, keyword);
    }

    @Test
    public void jsonToYaml_shouldDelegateToServiceAndReturnYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: \"value\"\n";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = controller.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result, "Controller should return YAML produced by the service");
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(json);
    }

    @Test
    public void jsonToXml_shouldDelegateToServiceAndReturnXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<ObjectNode><key>value</key></ObjectNode>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = controller.jsonToXml(json);

        // THEN
        assertEquals(xml, result, "Controller should return XML produced by the service");
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(json);
    }

    // Exception propagation tests: ensure controller propagates runtime exceptions from service methods

    @Test
    public void reverse_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.reverse(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> controller.reverse(null), "Controller should propagate NPE from service");
        Mockito.verify(textService, Mockito.times(1)).reverse(null);
    }

    @Test
    public void uppercase_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.uppercase(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> controller.uppercase(null), "Controller should propagate NPE from service");
        Mockito.verify(textService, Mockito.times(1)).uppercase(null);
    }

    @Test
    public void stats_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        Mockito.when(textService.stats(null)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> controller.stats(null), "Controller should propagate NPE from service");
        Mockito.verify(textService, Mockito.times(1)).stats(null);
    }

    @Test
    public void replace_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        String target = "a";
        String replacement = "b";
        Mockito.when(textService.replace(null, target, replacement)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> controller.replace(target, replacement, null), "Controller should propagate NPE from service");
        Mockito.verify(textService, Mockito.times(1)).replace(null, target, replacement);
    }

    @Test
    public void countOccurrence_shouldPropagateNullPointerExceptionFromService() {
        // GIVEN
        String keyword = "one";
        Mockito.when(textService.countOccurrence(null, keyword)).thenThrow(new NullPointerException("input is null"));

        // WHEN / THEN
        assertThrows(NullPointerException.class, () -> controller.countOccurrence(keyword, null), "Controller should propagate NPE from service");
        Mockito.verify(textService, Mockito.times(1)).countOccurrence(null, keyword);
    }

    @Test
    public void jsonToYaml_shouldPropagateRuntimeExceptionFromService() {
        // GIVEN
        String json = "{\"invalid";
        Mockito.when(textService.convertJsonToYaml(json)).thenThrow(new IllegalArgumentException("invalid json"));

        // WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> controller.jsonToYaml(json), "Controller should propagate IllegalArgumentException from service");
        Mockito.verify(textService, Mockito.times(1)).convertJsonToYaml(json);
    }

    @Test
    public void jsonToXml_shouldPropagateRuntimeExceptionFromService() {
        // GIVEN
        String json = "{\"invalid";
        Mockito.when(textService.convertJsonToXml(json)).thenThrow(new IllegalArgumentException("invalid json"));

        // WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> controller.jsonToXml(json), "Controller should propagate IllegalArgumentException from service");
        Mockito.verify(textService, Mockito.times(1)).convertJsonToXml(json);
    }
}
