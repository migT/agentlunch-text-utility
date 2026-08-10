package com.example.textapi.controller;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

public void testGetText() {
    // Given
    String input = "Hello World";
    TextController controller = new TextController();

    // When
    String result = controller.getText(input);

    // Then
    Assert.assertEquals("Hello World", result);
}

@Test
public void testGetText() {
    // Given
    String input = "Hello World";
    TextController controller = new TextController();

    // When
    String result = controller.getText(input);

    // Then
    assertThat(result).isEqualTo("Hello World");
}