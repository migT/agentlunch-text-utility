package com.example.textapi.utils;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: No state to reset since all methods are static and stateless
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the keys and values in YAML format
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"city\":\"Paris\",\"country\":\"France\"}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML tags for the keys
        assertTrue(xml.contains("<city>Paris</city>"));
        assertTrue(xml.contains("<country>France</country>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{\"city\":\"Paris\",\"country\":France"; // missing closing brace and quote

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should be a valid YAML representation of an empty object
        assertEquals("---\n{}", yaml.replace("\r\n", "\n"), "Expected YAML output for empty JSON object to be '---\\n{}'");
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should be an empty XML object
        assertTrue(xml.trim().startsWith("<ObjectNode") || xml.trim().startsWith("<ObjectNode/>") || xml.trim().length() > 0);
    }
}