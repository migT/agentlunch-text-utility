package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("cba", result);
    }

    @Test
    void reverse_ShouldReturnEmptyStringWhenInputIsEmpty() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_ShouldConvertToUpperCase() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void replace_ShouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hello there", result);
    }

    @Test
    void removeVowels_ShouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_ShouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_ShouldReturnCorrectCountCaseInsensitive() {
        // GIVEN
        String input = "Test test TEST";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }
