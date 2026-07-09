package com.example.textapi.utils;

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

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset in TextConversionUtil
    }

    @Test
    void testConvertJsonToYamlValidJson() {
        // GIVEN a simple valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN the YAML output should contain the expected key-value pairs
        assertNotNull(yaml, "YAML output should not be null");
        assertTrue(yaml.contains("name: John"), "YAML should contain name");
        assertTrue(yaml.contains("age: 30"), "YAML should contain age");
        assertFalse(yaml.startsWith("Error converting JSON to YAML"), "YAML output should not be an error message");
    }

    @Test
    void testConvertJsonToXmlValidJson() {
        // GIVEN a simple valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN the XML output should contain the expected elements
        assertNotNull(xml, "XML output should not be null");
        assertTrue(xml.contains("<name>John</name>"), "XML should contain name element");
        assertTrue(xml.contains("<age>30</age>"), "XML should contain age element");
        assertFalse(xml.startsWith("Error converting JSON to XML"), "XML output should not be an error message");
    }

    @Test
    void testConvertJsonToYamlInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{\"name\":\"John\", \"age\":}";

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN the result should be an error message
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Error converting JSON to YAML"), "Result should indicate a conversion error");
    }

    @Test
    void testConvertJsonToXmlInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "{\"name\":\"John\", \"age\":}";

        // WHEN converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN the result should be an error message
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Error converting JSON to XML"), "Result should indicate a conversion error");
    }

    @Test
    void testConvertJsonToYamlNullInput() {
        // GIVEN a null input
        String nullInput = null;

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(nullInput);

        // THEN the result should be an error message
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Error converting JSON to YAML"), "Result should indicate a conversion error");
    }

    @Test
    void testConvertJsonToXmlNullInput() {
        // GIVEN a null input
        String nullInput = null;

        // WHEN converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(nullInput);

        // THEN the result should be an error message
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Error converting JSON to XML"), "Result should indicate a conversion error");
    }

    @Test
    void testConvertJsonToYamlNestedJson() {
        // GIVEN a nested JSON string
        String nestedJson = "{\"person\":{\"name\":\"Alice\",\"age\":25},\"active\":true}";

        // WHEN converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(nestedJson);

        // THEN the YAML output should contain nested structure
        assertNotNull(yaml, "YAML output should not be null");
        assertTrue(yaml.contains("person:"), "YAML should contain person key");
        assertTrue(yaml.contains("name: Alice"), "YAML should contain nested name");
        assertTrue(yaml.contains("age: 25"), "YAML should contain nested age");
        assertTrue(yaml.contains("active: true"), "YAML should contain active flag");
        assertFalse(yaml.startsWith("Error converting JSON to YAML"), "YAML output should not be an error message");
    }

    @Test
    void testConvertJsonToXmlNestedJson() {
        // GIVEN a nested JSON string
        String nestedJson = "{\"person\":{\"name\":\"Alice\",\"age\":25},\"active\":true}";

        // WHEN converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(nestedJson);

        // THEN the XML output should contain nested elements
        assertNotNull(xml, "XML output should not be null");
        assertTrue(xml.contains("<person>"), "XML should contain person element");
        assertTrue(xml.contains("<name>Alice</name>"), "XML should contain nested name");
        assertTrue(xml.contains("<age>25</age>"), "XML should contain nested age");
        assertTrue(xml.contains("<active>true</active>"), "XML should contain active flag");
        assertFalse(xml.startsWith("Error converting JSON to XML"), "XML output should not be an error message");
    }
}
