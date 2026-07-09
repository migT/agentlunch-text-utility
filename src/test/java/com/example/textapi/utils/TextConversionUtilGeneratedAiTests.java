package com.example.textapi.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
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
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("name: \"John\"") || result.contains("name: John"));
        assertTrue(result.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_withEmptyJson_returnsYamlString() {
        // GIVEN
        String json = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.trim().equals("--- {}") || result.trim().equals("{}"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\""; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<person>"));
        assertTrue(result.contains("<name>John</name>"));
        assertTrue(result.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_withEmptyJson_returnsXmlString() {
        // GIVEN
        String json = "{}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("<ObjectNode") || result.contains("<ObjectNode/>") || result.contains("<ObjectNode />"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\": \"John\""; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
