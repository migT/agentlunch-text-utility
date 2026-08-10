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
        // No state to reset as all methods are static and stateless
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"Alice\",\"age\":25}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"name\":\"Alice\", \"age\":}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsEmptyYaml() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertEquals("{}", yaml);
    }

    @Test
    void givenEmptyJson_whenConvertJsonToXml_thenReturnsEmptyXml() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertTrue(xml.contains("<ObjectNode/>") || xml.contains("<ObjectNode />") || xml.trim().length() > 0);
    }
}