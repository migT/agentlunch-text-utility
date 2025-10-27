package com.example.textapi.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        textService = new TextService();
    }

    @Test
    public void testStats_withSimpleText_returnsCorrectStats() {
        String text = "Hello, world! This is a test.";
        TextStats stats = textService.stats(text);
        assertEquals(23, stats.getCharacterCount());
        assertEquals(5, stats.getWordCount());
        assertEquals(7, stats.getVowelCount());
        assertEquals(12, stats.getConsonantCount());
    }

    @Test
    public void testRemoveConsonants_withConsonants_removesConsonants() {
        String input = "beautiful";
        String expected = "eauiu";
        String result = textService.removeConsonants(input);
        assertEquals(expected, result);
    }
}