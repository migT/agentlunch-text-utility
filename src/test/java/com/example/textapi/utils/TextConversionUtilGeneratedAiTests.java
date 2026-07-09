package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset in TextConversionUtil
    }

    @Test
    void convertJsonToYaml_givenValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotNull();
        assertThat(yaml).contains("name: \"John\"");
        assertThat(yaml).contains("age: 30");
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToYaml_givenEmptyJson_returnsYamlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertThat(yaml).isNotNull();
        assertThat(yaml.trim()).isEqualTo("{}");
    }

    @Test
    void convertJsonToXml_givenValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotNull();
        assertThat(xml).contains("<person>");
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
    }

    @Test
    void convertJsonToXml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"John\",\"age\":30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void convertJsonToXml_givenEmptyJson_returnsXmlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertThat(xml).isNotNull();
        assertThat(xml.trim()).isEqualTo("<ObjectNode/>");
    }
}