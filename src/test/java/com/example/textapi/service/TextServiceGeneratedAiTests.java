package com.example.textapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;

public class TextServiceGeneratedAiTests {

    private TextService textService = new TextService();

    public void testRemoveConsonants_withConsonants_removesConsonants() {
        String input = "Hello World";
        String expected = "eo o";
        String actual = textService.removeConsonants(input);
        assertEquals(expected, actual);
    }
}
