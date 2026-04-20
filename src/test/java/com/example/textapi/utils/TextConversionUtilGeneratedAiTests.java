package com.example.textapi.utils;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No mutable state to reset
    }

    @Test
    void testConvertJsonToYamlValidJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToXmlValidJson() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN
        assertNotNull(xml);
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToYamlInvalidJson() {
        // GIVEN
        String invalidJson = "{name:John}";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXmlInvalidJson() {
        // GIVEN
        String invalidJson = "{name:John}";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYamlEmptyString() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXmlEmptyString() {
        // GIVEN
        String emptyJson = "";
        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);
        // THEN
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}