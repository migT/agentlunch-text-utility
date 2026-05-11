package com.example.textapi.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset before each test
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name:"));
        assertTrue(yaml.contains("John"));
        assertTrue(yaml.contains("age:"));
        assertTrue(yaml.contains("30"));
        assertFalse(yaml.startsWith("Error"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
        assertFalse(xml.startsWith("Error"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToYaml_withEmptyJson_returnsYamlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(yaml);
        // YAML representation of empty JSON object can vary, so check it contains "{}" or "---"
        assertTrue(yaml.trim().equals("{}") || yaml.trim().startsWith("---") || yaml.trim().contains("{}"));
        assertFalse(yaml.startsWith("Error"));
    }

    @Test
    void convertJsonToXml_withEmptyJson_returnsXmlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<ObjectNode"));
        assertFalse(xml.startsWith("Error"));
    }
}
