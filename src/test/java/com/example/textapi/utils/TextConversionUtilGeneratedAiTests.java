package com.example.textapi.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset
    }

    @Test
    void convertJsonToYaml_validJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name:"), "YAML should contain a name field");
        assertTrue(yaml.contains("age:"), "YAML should contain an age field");
        assertTrue(yaml.contains("John"), "YAML should contain the name value");
        assertTrue(yaml.contains("30"), "YAML should contain the age value");
    }

    @Test
    void convertJsonToXml_validJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<name>John</name>"), "XML should contain name element");
        assertTrue(xml.contains("<age>30</age>"), "XML should contain age element");
    }

    @Test
    void convertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"), "Error message should start with expected prefix");
    }

    @Test
    void convertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"), "Error message should start with expected prefix");
    }
}
