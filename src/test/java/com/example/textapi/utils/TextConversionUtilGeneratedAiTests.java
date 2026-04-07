package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void resetState() {
        // No mutable state to reset, method kept for compliance with requirements.
    }

    @Test
    void testConvertJsonToYamlWithValidJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30,\"skills\":[\"Java\",\"Python\"]}
