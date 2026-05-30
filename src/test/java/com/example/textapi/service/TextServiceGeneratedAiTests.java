package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcd";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertThat(result).isEqualTo("dcba");
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertThat(result).isEqualTo("HELLO WORLD");
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello world\nHello";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertThat(stats).containsEntry("length", 17);
        assertThat(stats).containsEntry("wordCount", 3);
        assertThat(stats).containsEntry("lineCount", 2);
        assertThat(stats).containsEntry("VowelCount", 5);
        assertThat(stats).containsEntry("ConsonantCount", 10);
        assertThat(stats).containsEntry("RepeatedWords", List.of("hello : 2"));
    }

    @Test
    void testGetRepeatedWordsWithNull() {
        // GIVEN
        String input = null;
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void testGetRepeatedWordsWithEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void testGetRepeatedWords() {
        // GIVEN
        String input = "Apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertThat(result).containsExactlyInAnyOrder(
                "apple : 3",
                "banana : 2"
        );
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello world";
        String target = "world";
        String replacement = "Java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertThat(result).isEqualTo("Hello Java");
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertThat(result).isEqualTo("Hll Wrld");
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello World";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertThat(result).isEqualTo("eo o");
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello hello HELLO";
        String keyword = "hello";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertThat(count).isEqualTo(3);
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = assertDoesNotThrow(() -> textService.convertJsonToYaml(json));
        // THEN
        assertThat(yaml).isNotNull();
        assertThat(yaml).contains("name: John");
        assertThat(yaml).contains("age: 30");
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
    }
}
