package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    @Mock
    private TextConversionUtil textConversionUtil;

    @InjectMocks
    private TextService textService;

    @BeforeEach
    public void setUp() {
        // Reset any state before each test
    }

    @Test
    public void testReverse() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertThat(result).isEqualTo("!dlroW ,olleH");
    }

    @Test
    public void testUppercase() {
        // GIVEN
        String input = "hello, world!";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        // WHEN
        Map<String, Object> result = textService.stats(input);
        // THEN
        assertThat(result).isNotNull();
        assertThat(result.get("length")).isEqualTo(20);
        assertThat(result.get("wordCount")).isEqualTo(5);
        assertThat(result.get("lineCount")).isEqualTo(1);
        assertThat(result.get("VowelCount")).isEqualTo(4);
        assertThat(result.get("ConsonantCount")).isEqualTo(16);
        assertThat(result.get("RepeatedWords")).isNotEmpty();
    }

    @Test
    public void testReplace() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertThat(result).isEqualTo("eoo, ooo!");
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";
        // WHEN
        int result = textService.countOccurrence(input, keyword);
        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"name\": \"John\", \"age\": 30}";
        // WHEN
        String result = textService.convertJsonToYaml(json);
        // THEN
        assertThat(result).isNotNull();
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"name\": \"John\", \"age\": 30}";
        // WHEN
        String result = textService.convertJsonToXml(json);
        // THEN
        assertThat(result).isNotNull();
    }
}
