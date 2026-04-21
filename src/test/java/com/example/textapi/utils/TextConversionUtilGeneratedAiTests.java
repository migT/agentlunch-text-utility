package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset in TextConversionUtil as it uses static methods and immutable fields
    }

    @Test
    void convertJsonToYaml_withValidJson_shouldReturnYamlString() {
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
    void convertJsonToYaml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_shouldReturnXmlString() {
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
    void convertJsonToXml_withInvalidJson_shouldReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void convertJsonToYaml_withEmptyJson_shouldReturnYamlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.trim().isEmpty() || result.trim().equals("{}") || result.contains("---"));
    }

    @Test
    void convertJsonToXml_withEmptyJson_shouldReturnXmlRepresentation() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<ObjectNode") || result.contains("<root>") || result.contains("</"));
    }
}
