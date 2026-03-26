package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset in TextConversionUtil as it uses only static methods and stateless mappers
    }

    @Test
    void convertJsonToYaml_givenValidJson_shouldReturnEquivalentYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
        assertTrue(yaml.contains("city: \"New York\""));
        assertTrue(!yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30,}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_shouldReturnEquivalentXml() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<person>"));
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
        assertTrue(!xml.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"John\",age:30}}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
