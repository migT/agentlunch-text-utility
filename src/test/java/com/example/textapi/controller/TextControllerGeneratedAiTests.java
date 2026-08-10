package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reset(textService);
    }

    // GIVEN: TextService returns "Hello, World!"
    // WHEN: helloWorld() is called
    // THEN: Should return "Hello, World!"
    @Test
    void testHelloWorld() {
        when(textService.helloworld()).thenReturn("Hello, World!");
        String result = textController.helloWorld();
        assertThat(result).isEqualTo("Hello, World!");
        verify(textService, times(1)).helloworld();
    }

    // GIVEN: TextService returns reversed string
    // WHEN: reverse() is called with input
    // THEN: Should return reversed string
    @Test
    void testReverse() {
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);
        String result = textController.reverse(input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    // GIVEN: TextService returns uppercase string
    // WHEN: uppercase() is called with input
    // THEN: Should return uppercase string
    @Test
    void testUppercase() {
        String input = "abcDef";
        String expected = "ABCDEF";
        when(textService.uppercase(input)).thenReturn(expected);
        String result = textController.uppercase(input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    // GIVEN: TextService returns stats map
    // WHEN: stats() is called with input
    // THEN: Should return stats map
    @Test
    void testStats() {
        String input = "Hello world\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);
        Map<String, Object> result = textController.stats(input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }

    // GIVEN: TextService returns replaced string
    // WHEN: replace() is called with input, target, replacement
    // THEN: Should return replaced string
    @Test
    void testReplace() {
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);
        String result = textController.replace(target, replacement, input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    // GIVEN: TextService returns string with vowels removed
    // WHEN: removeVowels() is called with input
    // THEN: Should return string without vowels
    @Test
    void testRemoveVowels() {
        String input = "Hello World";
        String expected = "Hll Wrld";
        when(textService.removeVowels(input)).thenReturn(expected);
        String result = textController.removeVowels(input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeVowels(input);
    }

    // GIVEN: TextService returns string with consonants removed
    // WHEN: removeConsonants() is called with input
    // THEN: Should return string without consonants
    @Test
    void testRemoveConsonants() {
        String input = "Hello World";
        String expected = "eo o";
        when(textService.removeConsonants(input)).thenReturn(expected);
        String result = textController.removeConsonants(input);
        assertThat(result).isEqualTo(expected);
        verify(textService, times(1)).removeConsonants(input);
    }
