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
        // No mutable state to reset in TextConversionUtil
    }

    @Test
    void convertJsonToYaml_ValidJson_ReturnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(result);
        assertTrue(result.contains("name: \"John\""));
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
    void convertJsonToXml_InvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"John\",\"age\":30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
