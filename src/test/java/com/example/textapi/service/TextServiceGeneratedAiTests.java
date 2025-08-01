package com.example.textapi.service;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TextServiceGeneratedAiTests {

    @Test
    public void testGenerateText() {
        // Arrange
        String input = "Hello World";
        TextService textService = new TextService();

        // Act
        String result = textService.generateText(input);

        // Assert
        assertNotNull(result);
        assertEquals("Hello World", result);
    }

    @Test
    public void testGenerateTextWithMultipleInputs() {
        // Arrange
        String input1 = "Hello";
        String input2 = "World";
        TextService textService = new TextService();

        // Act
        String result = textService.generateText(input1, input2);

        // Assert
        assertNotNull(result);
        assertEquals("Hello World", result);
    }

    @Test
    public void testGenerateRandomText() {
        // Arrange
        TextService textService = new TextService();

        // Act
        String result = textService.generateRandomText();

        // Assert
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
