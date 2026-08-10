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
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void resetState() {
        // GIVEN: No state to reset, as TextConversionUtil is stateless.
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain YAML representation
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String json = "{name:John,age:30}";

        // WHEN: Converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String json = "";

        // WHEN: Converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML representation
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String json = "{name:Alice,age:25}";

        // WHEN: Converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String json = "";

        // WHEN: Converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON"));
    }

    @Test
    void testConvertJsonToYaml_withJsonArray_returnsYamlArray() {
        // GIVEN: A valid JSON array string
        String json = "[{\"city\":\"Paris\"},{\"city\":\"London\"}]";

        // WHEN: Converting JSON array to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain YAML array representation
        assertTrue(yaml.contains("- city: \"Paris\""));
        assertTrue(yaml.contains("- city: \"London\""));
    }

    @Test
    void testConvertJsonToXml_withJsonArray_returnsXmlArray() {
        // GIVEN: A valid JSON array string
        String json = "[{\"country\":\"France\"},{\"country\":\"UK\"}]";

        // WHEN: Converting JSON array to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML array representation
        assertTrue(xml.contains("<country>France</country>"));
        assertTrue(xml.contains("<country>UK</country>"));
    }
}