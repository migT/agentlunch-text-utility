package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset in TextConversionUtil
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("name: John");
        assertThat(yaml).contains("age: 30");
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid json";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void convertJsonToYaml_withNullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_withNullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }
}
