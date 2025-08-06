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

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    public void setUp() {
        // No mutable state to reset before each test
    }

    @Test
    public void testConvertJsonToYaml_ValidJson_ReturnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        // YAML output may quote or not quote strings depending on mapper version/configuration
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
        assertFalse(yaml.startsWith("Error"));
    }

    @Test
    public void testConvertJsonToYaml_InvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:\"John\",age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToXml_ValidJson_ReturnsXml() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Jane\",\"age\":25}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<person>"));
        assertTrue(xml.contains("<name>Jane</name>"));
        assertTrue(xml.contains("<age>25</age>"));
        assertFalse(xml.startsWith("Error"));
    }

    @Test
    public void testConvertJsonToXml_InvalidJson_ReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"Jane\",\"age\":25"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
