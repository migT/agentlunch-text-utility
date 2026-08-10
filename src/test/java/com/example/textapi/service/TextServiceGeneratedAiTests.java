package com.example.textapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

public class TextServiceGeneratedAiTests {

    public void testStats_withTypicalText_returnsCorrectStats() {
        String text = "Hello world! This is a test.";
        TextStats stats = textService.stats(text);
        assertEquals(6, stats.getWordCount());
        assertEquals(29, stats.getCharCount());
        assertEquals(12, stats.getUniqueCharCount());
    }

}
