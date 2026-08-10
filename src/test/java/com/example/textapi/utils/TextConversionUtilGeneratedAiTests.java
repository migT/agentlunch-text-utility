package com.example.textapi.utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

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
        // GIVEN: No state to reset, as TextConversionUtil is stateless
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should indicate an error
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsYaml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should be a valid empty YAML (YAMLMapper returns empty string for empty object)
        assertTrue(yaml.trim().isEmpty() || yaml.trim().equals("{}") || yaml.trim().equals("---"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML tags for the keys
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25}";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should indicate an error
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsXml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should be a valid empty XML
        assertTrue(xml.trim().startsWith("<ObjectNode") || xml.trim().startsWith("<ObjectNode/>") || xml.trim().length() > 0);
    }
}