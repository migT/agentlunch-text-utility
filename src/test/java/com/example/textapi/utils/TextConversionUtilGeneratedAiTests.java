package com.example.textapi.utils;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    public void setUp() {
        // GIVEN: No state to reset for static utility methods
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToYaml_withEmptyJson_returnsYaml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should be empty or minimal YAML
        assertTrue(yaml.trim().isEmpty() || yaml.trim().equals("{}") || yaml.trim().equals("{}\n") || yaml.trim().equals("---"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"city\":\"Wonderland\"}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML elements corresponding to the JSON keys
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<city>Wonderland</city>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,city:Wonderland}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    public void testConvertJsonToXml_withEmptyJson_returnsXml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should be minimal XML (could be empty or root element)
        assertTrue(xml.trim().isEmpty() || xml.trim().startsWith("<ObjectNode"));
    }

    @Test
    public void testConvertJsonToYaml_withNullInput_returnsErrorMessage() {
        // GIVEN: A null JSON string
        String nullJson = null;

        // WHEN: Converting null JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToXml_withNullInput_returnsErrorMessage() {
        // GIVEN: A null JSON string
        String nullJson = null;

        // WHEN: Converting null JSON to XML
        String result = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}