package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoJUnitRunner.class)
@MockitoJUnitRunner
public class TextControllerGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = Mockito.createMock(TextService.class);
    }

    @Test
    void helloWorld() {
        // GIVEN
        String expected = "Hello, World!";

        // WHEN
        String actual = textService.helloworld();

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void reverse() {
        // GIVEN
        String input = "hello";
        String expected = "olleh";

        // WHEN
        String actual = textService.reverse(input);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void uppercase() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";

        // WHEN
        String actual = textService.uppercase(input);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void stats() {
        // GIVEN
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 10);
        expected.put("wordCount", 1);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 2);
        expected.put("ConsonantCount", 7);
        expected.put("RepeatedWords", Collections.emptyList());

        // WHEN
        Map<String, Object> actual = textService.stats("hello");

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void replace() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "universe";
        String expected = "hello universe";

        // WHEN
        String actual = textService.replace(input, target, replacement);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";

        // WHEN
        String actual = textService.removeVowels(input);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "aeiou";

        // WHEN
        String actual = textService.removeConsonants(input);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void countOccurrence() {
        // GIVEN
        String input = "hello world";
        String keyword = "world";
        String expected = 1;

        // WHEN
        int actual = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void jsonToYaml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String expected = "{\n  \"name\": \"John\",\n  \"age\": 30\n}";

        // WHEN
        String actual = textService.convertJsonToYaml(json);

        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void jsonToXml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String expected = "<root>\n  <name>John</name>\n  <age>30</age>\n</root>";

        // WHEN
        String actual = textService.java
        // THEN
        assertEquals(expected, actual);
    }
}
