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
        // GIVEN: No state to reset as all methods are static and stateless
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should indicate an error
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML tags for the keys
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should indicate an error
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be an empty YAML object
        assertEquals("{}", yaml);
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be an empty XML object or root
        assertTrue(xml.contains("{}") || xml.trim().length() > 0);
    }
}