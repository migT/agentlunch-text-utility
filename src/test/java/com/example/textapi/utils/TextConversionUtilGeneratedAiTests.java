package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void resetState() {
        // No mutable state in TextConversionUtil, method kept for compliance with requirements
    }

    @Test
    void convertJsonToYaml_validJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN
        assertThat(yaml).contains("name: John");
        assertThat(yaml).contains("age: 30");
    }

    @Test
    void convertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":30"; // missing closing brace
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_validJson_returnsXml() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"city\":\"Wonderland\"}}";
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN
        assertThat(xml).contains("<person>");
        assertThat(xml).contains("<name>Alice</name>");
        assertThat(xml).contains("<city>Wonderland</city>");
    }

    @Test
    void convertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"Alice\", \"city\":\"Wonderland\""; // missing closing braces
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }
}