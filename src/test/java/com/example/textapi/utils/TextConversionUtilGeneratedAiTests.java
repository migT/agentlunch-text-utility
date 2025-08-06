package com.example.textapi.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset in the utility class
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN the result should be a YAML representation containing the keys and values
        assertTrue(result.contains("name: \"John\"") || result.contains("name: John"));
        assertTrue(result.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN an invalid JSON string
        String invalidJson = "{name:John, age:30}";

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN the result should contain an error message about conversion failure
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN a valid JSON string
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN the result should be an XML representation containing the keys and values
        assertTrue(result.contains("<person>"));
        assertTrue(result.contains("<name>John</name>"));
        assertTrue(result.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN an invalid JSON string
        String invalidJson = "{person:{name:John, age:30}}";

        // WHEN converting JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN the result should contain an error message about conversion failure
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
