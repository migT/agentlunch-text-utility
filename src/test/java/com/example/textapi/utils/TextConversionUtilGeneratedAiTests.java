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
    void setUp() {
        // No state to reset
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN
        assertThat(yaml).contains("name: John").contains("age: 30");
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN
        assertThat(xml).contains("<name>John</name>").contains("<age>30</age>");
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML");
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to XML");
    }

    @Test
    void convertJsonToYaml_withEmptyString_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML");
    }

    @Test
    void convertJsonToXml_withEmptyString_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to XML");
    }
}
