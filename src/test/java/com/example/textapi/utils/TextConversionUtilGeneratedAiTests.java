package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

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
        // No state to reset for this stateless utility class
    }

    @Test
    void convertJsonToYaml_withSimpleObject_returnsYamlContainingKeysAndValues() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml, "YAML output should not be null");
        assertFalse(yaml.isEmpty(), "YAML output should not be empty");
        assertTrue(yaml.contains("name"), "YAML should contain the 'name' key");
        assertTrue(yaml.contains("John") || yaml.contains("\"John\""), "YAML should contain the value 'John'");
        assertTrue(yaml.contains("age"), "YAML should contain the 'age' key");
        assertTrue(yaml.contains("30"), "YAML should contain the value '30'");
    }

    @Test
    void convertJsonToXml_withNestedObject_returnsXmlWithNestedTags() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"details\":{\"age\":25}}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xml, "XML output should not be null");
        assertFalse(xml.isEmpty(), "XML output should not be empty");
        assertTrue(xml.contains("<name>") && xml.contains("</name>"), "XML should contain <name> tags");
        assertTrue(xml.contains("Alice"), "XML should contain the name value 'Alice'");
        assertTrue(xml.contains("25") || xml.contains("<age>25</age>"), "XML should contain the age value 25");
    }

    @Test
    void convertJsonToYaml_withArray_returnsYamlContainingArrayValues() {
        // GIVEN
        String jsonArray = "[1,2,3]";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN
        assertNotNull(yaml, "YAML output should not be null");
        assertFalse(yaml.isEmpty(), "YAML output should not be empty");
        assertTrue(yaml.contains("1"), "YAML should contain '1'");
        assertTrue(yaml.contains("2"), "YAML should contain '2'");
        assertTrue(yaml.contains("3"), "YAML should contain '3'");
    }

    @Test
    void convertJsonToXml_withEmptyObject_returnsNonEmptyXml() {
        // GIVEN
        String emptyObjectJson = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(emptyObjectJson);

        // THEN
        assertNotNull(xml, "XML output should not be null for empty object");
        assertFalse(xml.trim().isEmpty(), "XML output should not be empty for empty object");
        assertTrue(xml.trim().startsWith("<") || xml.trim().startsWith("<?xml"), "XML output should start with XML content");
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessagePrefix() {
        // GIVEN
        String invalidJson = "{name: unquoted}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result, "Result should not be null even on error");
        assertTrue(result.startsWith("Error converting JSON to XML:"), "Should return an error message starting with the expected prefix");
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessagePrefix() {
        // GIVEN
        String invalidJson = "{invalid: }";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result, "Result should not be null even on error");
        assertTrue(result.startsWith("Error converting JSON to YAML:"), "Should return an error message starting with the expected prefix");
    }

    @Test
    void convertJsonToYaml_withNullInput_returnsErrorMessagePrefix() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(result, "Result should not be null even on null input");
        assertTrue(result.startsWith("Error converting JSON to YAML:"), "Should return an error message prefix for null input");
    }

    @Test
    void convertJsonToXml_withNullInput_returnsErrorMessagePrefix() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(result, "Result should not be null even on null input");
        assertTrue(result.startsWith("Error converting JSON to XML:"), "Should return an error message prefix for null input");
    }
}
