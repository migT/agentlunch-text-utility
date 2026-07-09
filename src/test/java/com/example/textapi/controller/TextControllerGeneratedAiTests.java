package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    public void setUp() {
        // Reset mocks before each test
    }

    @Test
    public void testHelloWorld() {
        // GIVEN
        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testReverse() {
        // GIVEN
        // WHEN
        String result = textController.reverse("hello");

        // THEN
        assertThat(result).isEqualTo("olleh");
    }

    @Test
    public void testUppercase() {
        // GIVEN
        // WHEN
        String result = textController.uppercase("hello");

        // THEN
        assertThat(result).isEqualTo("HELLO");
    }

    @Test
    public void testStats() {
        // GIVEN
        // WHEN
        Map<String, Object> result = textController.stats("hello");

        // THEN
        assertThat(result).isEqualTo(Map.of(
                "length", 5,
                "wordCount", 1,
                "lineCount", 1,
                "VowelCount", 2,
                "ConsonantCount", 3,
                "RepeatedWords", "hello : 1"
        ));
    }

    @Test
    public void testReplace() {
        // GIVEN
        // WHEN
        String result = textController.replace("world", "universe", "hello world");

        // THEN
        assertThat(result).isEqualTo("hello universe");
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN
        // WHEN
        String result = textController.removeVowels("hello");

        // THEN
        assertThat(result).isEqualTo("hll");
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN
        // WHEN
        String result = textController.removeConsonants("hello");

        // THEN
        assertThat(result).isEqualTo("eoo");
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN
        // WHEN
        int result = textController.countOccurrence("hello", "hello world hello");

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN
        // WHEN
        String result = textController.jsonToYaml("{\"name\": \"John\"}");

        // THEN
        assertThat(result).isEqualTo("name: John");
    }

    @Test
    public void testJsonToXml() {
        // GIVEN
        // WHEN
        String result = textController.jsonToXml("{\"name\": \"John\"}");

        // THEN
        assertThat(result).isEqualTo("<name>John</name>");
    }
}
