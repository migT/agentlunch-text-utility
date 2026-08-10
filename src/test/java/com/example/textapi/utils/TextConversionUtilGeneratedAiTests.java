package com.example.textapi.utils;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any static/global state if necessary (none in this class)
        // No state to reset for TextConversionUtil
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30,\"active\":true}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the YAML representation
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("name: \"John\""));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("age: 30"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("active: true"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30,active:true}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should contain the actual error message for empty input
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to YAML: No content to map due to end-of-input"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25,\"active\":false}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain the XML representation
        org.junit.jupiter.api.Assertions.assertTrue(xml.contains("<name>Alice</name>"));
        org.junit.jupiter.api.Assertions.assertTrue(xml.contains("<age>25</age>"));
        org.junit.jupiter.api.Assertions.assertTrue(xml.contains("<active>false</active>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25,active:false}";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should contain the actual error message for empty input
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to XML: No content to map due to end-of-input"));
    }

    @Test
    void testConvertJsonToYaml_withNullJson_returnsErrorMessage() {
        // GIVEN: A null JSON string
        String nullJson = null;

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withNullJson_returnsErrorMessage() {
        // GIVEN: A null JSON string
        String nullJson = null;

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}