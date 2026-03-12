package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abcdef";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo("fedcba");
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO WORLD");
    }
