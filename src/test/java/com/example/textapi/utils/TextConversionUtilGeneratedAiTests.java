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
        // GIVEN: Reset any static state if needed (none in this utility class)
        // No state to reset for this class
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The YAML output should contain the expected keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Converting empty JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"city\":\"Paris\",\"population\":2148327}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The XML output should contain the expected tags and values
        assertTrue(xml.contains("<city>Paris</city>"));
        assertTrue(xml.contains("<population>2148327</population>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{city:Paris,population:2148327}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Converting empty JSON to XML
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should contain an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withJsonArray_returnsYamlArray() {
        // GIVEN: A valid JSON array string
        String jsonArray = "[{\"id\":1},{\"id\":2}]";

        // WHEN: Converting JSON array to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN: The YAML output should contain array elements
        assertTrue(yaml.contains("- id: 1"));
        assertTrue(yaml.contains("- id: 2"));
    }

    @Test
    void testConvertJsonToXml_withJsonArray_returnsXmlArray() {
        // GIVEN: A valid JSON array string
        String jsonArray = "[{\"id\":1},{\"id\":2}]";

        // WHEN: Converting JSON array to XML
        String xml = TextConversionUtil.convertJsonToXml(jsonArray);

        // THEN: The XML output should contain array elements or be a valid XML representation of the array
        assertTrue(xml.contains("<id>1</id>") || xml.contains("<ArrayNode>"));
        assertTrue(xml.contains("<id>2</id>") || xml.contains("<ArrayNode>"));
    }
}