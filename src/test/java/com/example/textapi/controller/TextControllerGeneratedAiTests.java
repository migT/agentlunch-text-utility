package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @BeforeEach
    void setUp() {
        Mockito.reset(textService);
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
        // WHEN
        // THEN
    }

    @Test
    void replace() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void removeVowels() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void removeConsonants() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void countOccurrence() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void jsonToYaml() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void jsonToXml() {
        // GIVEN
        // WHEN
        // THEN
    }
}
