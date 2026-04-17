package com.example.textapi.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any modified state before each test
    }

    @Test
    void testConvertJsonToYaml_validJson_returnsYamlString() {
        // GIVEN: A valid JSON input
        String jsonInput = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yamlOutput = TextConversionUtil.convertJsonToYaml(jsonInput);

        // THEN: The output should contain expected YAML keys
        assertTrue(yamlOutput.contains("name"));
        assertTrue(yamlOutput.contains("age"));
    }

    @Test
    void testConvertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON input
        String invalidJson = "{name:John, age:30";

        // WHEN: Attempting conversion to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The output should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_validJson_returnsXmlString() {
        // GIVEN: A valid JSON input
        String jsonInput = "{\"city\":\"New York\",\"population\":8000000}";

        // WHEN: Converting JSON to XML
        String xmlOutput = TextConversionUtil.convertJsonToXml(jsonInput);

        // THEN: The output should contain expected XML tags
        assertTrue(xmlOutput.contains("<city>"));
        assertTrue(xmlOutput.contains("<population>"));
    }

    @Test
    void testConvertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON input
        String invalidJson = "{\"city\":\"New York\", population:8000000";

        // WHEN: Attempting conversion to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The output should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML"));
    }

    @Test
    void testConvertJsonToYaml_emptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to YAML
        String yamlOutput = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The output should represent an empty YAML structure
        assertTrue(yamlOutput.trim().isEmpty() || yamlOutput.contains("{}"));
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to XML
        String xmlOutput = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The output should represent an empty XML structure
        assertTrue(xmlOutput.contains("<ObjectNode"));
    }
}
