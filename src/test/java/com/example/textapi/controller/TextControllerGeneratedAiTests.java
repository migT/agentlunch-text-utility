package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.textapi.service.TextService;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    @BeforeEach
    public void setup() {
        // Remove MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHelloWorld() {
        // GIVEN
        String expected = "Hello, World!";

        // WHEN
        when(textService.helloworld()).thenReturn(expected);

        // THEN
        String result = controller.helloWorld();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "hello";
        String expected = "olleh";

        // WHEN
        when(textService.reverse(anyString())).thenReturn(expected);

        // THEN
        String result = controller.reverse(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";

        // WHEN
        when(textService.uppercase(anyString())).thenReturn(expected);

        // THEN
        String result = controller.uppercase(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "hello world";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 11);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 4);
        expected.put("RepeatedWords", Collections.emptyList());

        // WHEN
        when(textService.stats(anyString())).thenReturn(expected);

        // THEN
        Map<String, Object> result = controller.stats(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "earth";
        String expected = "hello earth";

        // WHEN
        when(textService.replace(anyString(), anyString(), anyString())).thenReturn(expected);

        // THEN
        String result = controller.replace(target, replacement, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "hello world";
        String expected = "hll wrld";

        // WHEN
        when(textService.removeVowels(anyString())).thenReturn(expected);

        // THEN
        String result = controller.removeVowels(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "hello world";
        String expected = "eo o";

        // WHEN
        when(textService.removeConsonants(anyString())).thenReturn(expected);

        // THEN
        String result = controller.removeConsonants(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "hello world";
        String keyword = "world";
        int expected = 1;

        // WHEN
        when(textService.countOccurrence(anyString(), anyString())).thenReturn(expected);

        // THEN
        int result = controller.countOccurrence(keyword, input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";

        // WHEN
        when(textService.convertJsonToYaml(anyString())).thenReturn(expected);

        // THEN
        String result = controller.jsonToYaml(json);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<root><key>value</key></root>";

        // WHEN
        when(textService.convertJsonToXml(anyString())).thenReturn(expected);

        // THEN
        String result = controller.jsonToXml(json);
        assertThat(result).isEqualTo(expected);
    }
}
