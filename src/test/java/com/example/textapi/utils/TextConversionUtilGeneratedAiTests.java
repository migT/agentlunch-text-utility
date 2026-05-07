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
    void setUp() {
        // No state to reset as methods are static and stateless
    }

    @Test
    void convertJsonToYaml_withValidJson_shouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_shouldReturnXmlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<person>"));
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"John\",\"age\":30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToYaml_withEmptyJson_shouldReturnYamlRepresentation() {
        // GIVEN
        String json = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        String trimmedYaml = yaml.trim();
        assertTrue(trimmedYaml.equals("{}") || trimmedYaml.equals("--- {}") || trimmedYaml.equals("---"));
    }

    @Test
    void convertJsonToXml_withEmptyJson_shouldReturnXmlRepresentation() {
        // GIVEN
        String json = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<ObjectNode") || xml.contains("<ObjectNode/>") || xml.contains("<ObjectNode></ObjectNode>"));
    }
}
