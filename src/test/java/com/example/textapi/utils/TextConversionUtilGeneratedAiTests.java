package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
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
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_validJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_emptyJson_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:") || result.contains("No content to map due to end-of-input") || result.contains("Unexpected end-of-input") || result.contains("EOF"));
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:") || result.contains("No content to map due to end-of-input") || result.contains("Unexpected end-of-input") || result.contains("EOF"));
    }

    @Test
    void testConvertJsonToYaml_nullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_nullInput_returnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_handlesMalformedJsonGracefully() {
        // GIVEN
        String malformedJson = "{invalidJson}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_handlesMalformedJsonGracefully() {
        // GIVEN
        String malformedJson = "{invalidJson}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
