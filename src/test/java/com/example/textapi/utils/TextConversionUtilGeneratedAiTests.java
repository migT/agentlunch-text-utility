package com.example.textapi.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any shared state if needed before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnValidYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John, age:30"; // malformed JSON

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnValidXml() {
        // GIVEN
        String json = "{\"city\":\"New York\",\"population\":8000000}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<city>New York</city>"));
        assertTrue(xmlResult.contains("<population>8000000</population>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnErrorMessage() {
        // GIVEN
        String invalidJson = "{\"city\":\"New York\", population:8000000"; // malformed JSON

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}
