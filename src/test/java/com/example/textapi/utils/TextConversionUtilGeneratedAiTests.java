package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any modified state before each test
    }

    @Test
    void testConvertJsonToYaml_validJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_validJson_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_invalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_nullInput_shouldReturnErrorMessage() {
        // GIVEN
        String json = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_nullInput_shouldReturnErrorMessage() {
        // GIVEN
        String json = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_emptyString_shouldReturnErrorMessage() {
        // GIVEN
        String json = "";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:") || yamlResult.contains("No content to map due to end-of-input") || yamlResult.contains("Unexpected end-of-input"));
    }

    @Test
    void testConvertJsonToXml_emptyString_shouldReturnErrorMessage() {
        // GIVEN
        String json = "";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:") || xmlResult.contains("No content to map due to end-of-input") || xmlResult.contains("Unexpected end-of-input"));
    }

    @Test
    void testConvertJsonToYaml_exceptionHandling_shouldReturnErrorMessageInsteadOfThrowing() {
        // GIVEN
        String invalidJson = "{invalid}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_exceptionHandling_shouldReturnErrorMessageInsteadOfThrowing() {
        // GIVEN
        String invalidJson = "{invalid}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }
}
