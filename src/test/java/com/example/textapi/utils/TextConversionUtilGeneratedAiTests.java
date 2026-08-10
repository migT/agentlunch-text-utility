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

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any state if needed before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\"") || yamlResult.contains("name: John"));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML:"));
    }
}
