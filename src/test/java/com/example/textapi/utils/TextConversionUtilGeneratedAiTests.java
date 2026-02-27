package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset before each test
    }

    // GIVEN a valid JSON string
    // WHEN convertJsonToYaml is invoked
    // THEN it returns a YAML representation containing the same data
    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30,\"active\":true}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotNull()
                        .contains("name: \"John\"")
                        .contains("age: 30")
                        .contains("active: true");
    }

    // GIVEN an invalid JSON string
    // WHEN convertJsonToYaml is invoked
    // THEN it returns an error message starting with the expected prefix
    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\", age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    // GIVEN an empty JSON object
    // WHEN convertJsonToYaml is invoked
    // THEN it returns an empty YAML document (just a newline)
    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsEmptyYaml() {
        // GIVEN
        String json = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        // Jackson's YAMLMapper writes an empty document as just a newline
        assertThat(yaml.trim()).isEmpty();
    }

    // GIVEN a valid JSON string
    // WHEN convertJsonToXml is invoked
    // THEN it returns an XML representation containing the same data
    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsXml() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"id\":123}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotNull()
                       .contains("<person>")
                       .contains("<name>Alice</name>")
                       .contains("<id>123</id>")
                       .contains("</person>");
    }

    // GIVEN an invalid JSON string
    // WHEN convertJsonToXml is invoked
    // THEN it returns an error message starting with the expected prefix
    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "[{\"key\": \"value\"}"; // missing closing bracket

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    // GIVEN an empty JSON object
    // WHEN convertJsonToXml is invoked
    // THEN it returns an empty XML document (no elements)
    @Test
    void givenEmptyJson_whenConvertJsonToXml_thenReturnsEmptyXml() {
        // GIVEN
        String json = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        // Jackson's XmlMapper writes an empty JSON object as an empty root element
        assertThat(xml).isEqualTo("<ObjectNode/>");
    }
}