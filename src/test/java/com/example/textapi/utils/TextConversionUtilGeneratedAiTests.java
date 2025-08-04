package com.example.textapi.utils;

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

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset as methods are static and stateless
    }

    @Test
    void convertJsonToYaml_withValidJson_shouldReturnYamlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN the result should be a valid YAML representation containing the keys and values
        assertNotNull(yaml);
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN an invalid JSON string
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN the result should be an error message containing "Error converting JSON to YAML"
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_shouldReturnXmlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN the result should be a valid XML string containing the keys and values
        assertNotNull(xml);
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN an invalid JSON string
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN the result should be an error message containing "Error converting JSON to XML"
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToYaml_withEmptyJson_shouldReturnYamlRepresentation() {
        // GIVEN an empty JSON object
        String json = "{}";

        // WHEN converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN the result should be a YAML string representing an empty object
        assertNotNull(yaml);
        String trimmedYaml = yaml.trim();
        assertTrue(trimmedYaml.equals("{}") || trimmedYaml.equals("--- {}"));
    }

    @Test
    void convertJsonToXml_withEmptyJson_shouldReturnXmlRepresentation() {
        // GIVEN an empty JSON object
        String json = "{}";

        // WHEN converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN the result should be a valid XML string representing an empty object
        assertNotNull(xml);
        assertTrue(xml.contains("<ObjectNode") && (xml.contains("/>") || xml.contains("</ObjectNode>")));
    }
}
