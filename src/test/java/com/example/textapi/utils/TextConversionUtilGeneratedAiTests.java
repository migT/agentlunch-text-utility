package com.example.textapi.utils;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void resetState() {
        // GIVEN: No state to reset since TextConversionUtil only has static methods and no mutable state.
    }

    @Test
    void testConvertJsonToYaml_validJson_returnsExpectedYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The returned YAML should contain the expected keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_validJson_returnsExpectedXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"city\":\"Wonderland\"}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The returned XML should contain the expected elements
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<city>Wonderland</city>"));
    }

    @Test
    void testConvertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{\"name\": \"Bob\", \"age\": }";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_emptyJson_returnsYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The returned YAML should represent an empty object
        assertTrue(yaml.trim().isEmpty() || yaml.trim().equals("---") || yaml.trim().equals("{}"));
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The returned XML should represent an empty object
        assertTrue(xml.trim().startsWith("<ObjectNode"));
    }

    @Test
    void testConvertJsonToYaml_nullInput_returnsErrorMessage() {
        // GIVEN: A null input
        String json = null;

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_nullInput_returnsErrorMessage() {
        // GIVEN: A null input
        String json = null;

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}