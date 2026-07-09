package com.example.textapi.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any state if needed before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsYamlString() {
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
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30"; // malformed JSON

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsXmlString() {
        // GIVEN
        String json = "{\"city\":\"New York\",\"population\":8000000}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<city>New York</city>"));
        assertTrue(xmlResult.contains("<population>8000000</population>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{city:New York, population:8000000"; // malformed JSON

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsEmptyYamlStructure() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.trim().isEmpty() || yamlResult.contains("{}") || yamlResult.contains("---"));
    }

    @Test
    void givenEmptyJson_whenConvertJsonToXml_thenReturnsEmptyXmlStructure() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<ObjectNode/>") || xmlResult.contains("<ObjectNode></ObjectNode>"));
    }
}
