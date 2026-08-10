package com.example.textapi.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextControllerTest {

    @Test
    void testGetText() {
        // Assuming TextController has a method getText()
        // and that the method returns a String.
        String expectedText = "This is the expected text.";
        String actualText = TextController.getText(); // Assuming TextController has a method getText()
        assertEquals(expectedText, actualText);
    }
}
