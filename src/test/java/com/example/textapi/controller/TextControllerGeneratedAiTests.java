package com.example.textapi.controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
@MockitoJUnitRunner
public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = Mockito.createMock(TextService.class);
        textController = new TextController(textService);
    }

    @Test
    void helloWorld() {
        // GIVEN: A mock TextService instance
        // WHEN: The helloWorld method is called
        // THEN: "Hello, World!" is returned
        String expected = "Hello, World!";
        Mockito.when(textService.helloworld()).thenReturn(expected);
        assertEquals(expected, textController.helloworld());
    }

    @Test
    void removePattern() {
        // GIVEN: A mock TextService instance
        // WHEN: The removePattern method is called with "hello", "(?i)[aeiou]"
        // THEN: "" is returned
        String input = "hello";
        String regex = "(?i)[aeiou]";
        String expected = "";
        Mockito.when(textService.removePattern(input, regex)).thenReturn(expected);
        assertEquals(expected, textController.removePattern(input, regex));
    }

    @Test
    void countOccurrence() {
        // GIVEN: A mock TextService instance
        // WHEN: The countOccurrence method is called with "hello", "hello"
        // THEN: 1 is returned
        String input = "hello";
        String keyword = "hello";
        String expected = 1;
        Mockito.when(textService.countOccurrence(input, keyword)).thenReturn(expected);
        assertEquals(expected, textController.countOccurrence(input, keyword));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToYaml method is called with "{\"key\": \"value\"}"
        // THEN: "key: value" is returned
        String json = "{ \"key\": \"value\"}";
        String expected = "key: value";
        Mockito.when(textService.convertJsonToYaml(json)).thenReturn(expected);
        assertEquals(expected, textController.convertJsonToYaml(json));
    }

    @Test
    void convertJsonToXml() {
        // GIVEN: A mock TextService instance
        // WHEN: The convertJsonToXml method is called with "{\"key\": \"value\"}"
        // THEN: "<key>value</key>" is returned
        String json = "{ \"key\": \"value\"}";
        String expected = "<key>value</key>";
        Mockito.when(textService.convertJsonToXml(json)).thenReturn(expected);
        assertEquals(expected, textController.convertJsonToXml(json));
    }
}