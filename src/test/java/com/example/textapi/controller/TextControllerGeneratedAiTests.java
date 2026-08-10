package com.example.textapi.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReverseText() {
        String input = "hello";
        String reversed = "olleh";
        when(textService.reverse(input)).thenReturn(reversed);

        ResponseEntity<String> response = textController.reverseText(input);

        assertEquals(reversed, response.getBody());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercaseText() {
        String input = "hello";
        String uppercased = "HELLO";
        when(textService.uppercase(input)).thenReturn(uppercased);

        ResponseEntity<String> response = textController.uppercaseText(input);

        assertEquals(uppercased, response.getBody());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testLowercaseText() {
        String input = "HELLO";
        String lowercased = "hello";
        when(textService.lowercase(input)).thenReturn(lowercased);

        ResponseEntity<String> response = textController.lowercaseText(input);

        assertEquals(lowercased, response.getBody());
        verify(textService, times(1)).lowercase(input);
    }

    @Test
    void testCountCharacters() {
        String input = "hello";
        Map<String, Object> result = new HashMap<>();
        result.put("count", 5);
        when(textService.countCharacters(input)).thenReturn(result);

        ResponseEntity<Map<String, Object>> response = textController.countCharacters(input);

        assertEquals(result, response.getBody());
        verify(textService, times(1)).countCharacters(input);
    }

    @Test
    void testCapitalizeText() {
        String input = "hello world";
        String capitalized = "Hello world";
        when(textService.capitalize(input)).thenReturn(capitalized);

        ResponseEntity<String> response = textController.capitalizeText(input);

        assertEquals(capitalized, response.getBody());
        verify(textService, times(1)).capitalize(input);
    }

    @Test
    void testRepeatText() {
        String input = "abc";
        int timesToRepeat = 3;
        String repeated = "abcabcabc";
        when(textService.repeat(input, timesToRepeat)).thenReturn(repeated);

        ResponseEntity<String> response = textController.repeatText(input, timesToRepeat);

        assertEquals(repeated, response.getBody());
        verify(textService, times(1)).repeat(input, timesToRepeat);
    }

    @Test
    void testRemoveSpaces() {
        String input = "a b c";
        String noSpaces = "abc";
        when(textService.removeSpaces(input)).thenReturn(noSpaces);

        ResponseEntity<String> response = textController.removeSpaces(input);

        assertEquals(noSpaces, response.getBody());
        verify(textService, times(1)).removeSpaces(input);
    }

    @Test
    void testIsPalindrome() {
        String input = "madam";
        boolean isPalindrome = true;
        when(textService.isPalindrome(input)).thenReturn(isPalindrome);

        ResponseEntity<Boolean> response = textController.isPalindrome(input);

        assertEquals(isPalindrome, response.getBody());
        verify(textService, times(1)).isPalindrome(input);
    }

    @Test
    void testGetTextLength() {
        String input = "hello";
        int length = 5;
        when(textService.getTextLength(input)).thenReturn(length);

        ResponseEntity<Integer> response = textController.getTextLength(input);

        assertEquals(length, response.getBody());
        verify(textService, times(1)).getTextLength(input);
    }