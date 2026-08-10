package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset in the utility class, but method included per requirements
    }

    @Test
    void convertJsonToYaml_ValidJson_ReturnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("name: \"John\"") || result.contains("name: John"));
        assertTrue(result.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_InvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_ValidJson_ReturnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<name>John</name>"));
        assertTrue(result.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_InvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"John\", \"age\":}"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToYaml_EmptyJson_ReturnsYamlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.trim().length() > 0);
    }

    @Test
    void convertJsonToXml_EmptyJson_ReturnsXmlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.trim().length() > 0);
    }
}
