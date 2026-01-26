package com.example.textapi.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Before correcting the error:
@Test
public void testGetText() {
    // Given
    String text = "Hello World";
    TextController controller = new TextController();

    // When
    String result = controller.getText(text);

    // Then
    assertEquals("Hello World", result);
}

// After correcting the error:
@Test
public void testGetText() {
    // Given
    String text = "Hello World";
    TextController controller = new TextController();

    // When
    String result = controller.getText(text);

    // Then
    assertEquals("Hello World", result);
}