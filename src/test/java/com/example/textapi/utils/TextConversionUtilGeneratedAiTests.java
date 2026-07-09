package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void resetState() {
        // No mutable state to reset in TextConversionUtil
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotNull();
        assertThat(yaml).isNotEmpty();
        assertThat(yaml).contains("name: John");
        assertThat(yaml).contains("age: 30");
        assertThat(yaml).doesNotContain(json);
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotNull();
        assertThat(xml).isNotEmpty();
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
        assertThat(xml).doesNotContain(json);
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).startsWith("Error converting JSON to YAML:");
        assertThat(result).contains("Unexpected character");
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).startsWith("Error converting JSON to XML:");
        assertThat(result).contains("Unexpected character");
    }

    @Test
    void convertJsonToYaml_withNullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).startsWith("Error converting JSON to YAML:");
        assertThat(result).contains("content is null");
    }

    @Test
    void convertJsonToXml_withNullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).startsWith("Error converting JSON to XML:");
        assertThat(result).contains("content is null");
    }