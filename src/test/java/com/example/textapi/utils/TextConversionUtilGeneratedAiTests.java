package com.example.textapi.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or prepare any state if needed before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: converting JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: the YAML result should contain the keys and values
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: converting invalid JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: the result should contain an error message
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: converting JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: the XML result should contain the keys and values
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: converting invalid JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: the result should contain an error message
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsEmptyYamlStructure() {
        // GIVEN: an empty JSON object
        String json = "{}";

        // WHEN: converting empty JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: the YAML result should be empty or minimal
        assertTrue(yamlResult.trim().contains("{}"));
    }

    @Test
    void givenEmptyJson_whenConvertJsonToXml_thenReturnsEmptyXmlStructure() {
        // GIVEN: an empty JSON object
        String json = "{}";

        // WHEN: converting empty JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: the XML result should be empty or minimal
        assertTrue(xmlResult.contains("<ObjectNode/>") || xmlResult.contains("<ObjectNode></ObjectNode>"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN: a null JSON string
        String json = null;

        // WHEN: converting null JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: the result should contain an error message about null input
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN: a null JSON string
        String json = null;

        // WHEN: converting null JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: the result should contain an error message about null input
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN: a malformed JSON string
        String malformedJson = "{\"name\":\"John\", \"age\":}";

        // WHEN: converting malformed JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN: the result should contain an error message about malformed input
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN: a malformed JSON string
        String malformedJson = "{\"name\":\"John\", \"age\":}";

        // WHEN: converting malformed JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN: the result should contain an error message about malformed input
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}
