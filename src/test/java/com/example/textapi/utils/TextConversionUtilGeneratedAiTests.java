package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any modified state before each test
    }

    @Test
    void testConvertJsonToYaml_validJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_validJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_emptyJson_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:") || yamlResult.contains("No content to map due to end-of-input") || yamlResult.contains("Unexpected end-of-input") || yamlResult.contains("IllegalArgumentException"));
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:") || xmlResult.contains("No content to map due to end-of-input") || xmlResult.contains("Unexpected end-of-input") || xmlResult.contains("IllegalArgumentException"));
    }

    @Test
    void testConvertJsonToYaml_nullInput_returnsErrorMessage() {
        // GIVEN
        String json = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_nullInput_returnsErrorMessage() {
        // GIVEN
        String json = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_validJson_structureIntegrity() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"age\":25}}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yamlResult.contains("person:"));
        assertTrue(yamlResult.contains("name: \"Alice\""));
        assertTrue(yamlResult.contains("age: 25"));
    }

    @Test
    void testConvertJsonToXml_validJson_structureIntegrity() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"age\":25}}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xmlResult.contains("<person>"));
        assertTrue(xmlResult.contains("<name>Alice</name>"));
        assertTrue(xmlResult.contains("<age>25</age>"));
    }
}
