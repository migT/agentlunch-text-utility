package com.example.textapi.utils;
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

import com.example.textapi.utils.TextConversionUtil;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset
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
    void convertJsonToXml_validJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
    }

    @Test
    void convertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML");
    }

    @Test
    void convertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to XML");
    }

    @Test
    void convertJsonToYaml_emptyString_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML");
    }

    @Test
    void convertJsonToXml_emptyString_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);
        // THEN
        assertThat(result).startsWith("Error converting JSON to XML");
    }
}