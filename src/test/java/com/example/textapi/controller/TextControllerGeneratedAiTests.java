package com.example.textapi.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TextControllerTest {
    @Test
    public void testGetText() {
        // Given
        TextController controller = new TextController();
        
        // When
        String result = controller.getText("Hello World!");
        
        // Then
        assertEquals("Hello World!", result);
    }

    @Test
    public void testGetTextWithNullInput() {
        // Given
        TextController controller = new TextController();
        
        // When
        String result = controller.getText(null);
        
        // Then
        assertNull(result);
    }
}